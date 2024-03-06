package ru.spring.rest.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.spring.rest.dto.OrderItemDto;
import ru.spring.rest.dto.ProductDto;
import ru.spring.rest.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@SessionScope
public class Cart {
    private final ProductService productService;
    private final List<OrderItemDto> orderItems;
    private BigDecimal totalPrice;

    public Cart(List<OrderItemDto> orderItems, BigDecimal totalPrice, ProductService productService) {
        this.productService = productService;
        this.orderItems = new ArrayList<>();
        this.totalPrice = calculateTotalPrice();
    }
//Основы веб-разработки на Spring Framework geek урок практика 60 минута
    public void addProductToCart(Long id) { //ищем продукт в корзине если не находим вытаскиваем его из БД
        //получаем product и прикрепляем id price на orderItemDto(orderItem) добавляем его в корзину пересчитываем количество и стоимость в корзине

        final OrderItemDto orderItemDto = orderItems.stream()
                .filter(it->it.getProductId().equals(id))
                .findFirst()
                .orElseGet(()->{
                    final ProductDto product = productService.findById(id);
                    final OrderItemDto orderItem = new OrderItemDto(product.getId(), product.getPrice(),0);
                    orderItems.add(orderItem);
                    return orderItem;
                });
        orderItemDto.setQuantity(orderItemDto.getQuantity()+1);
        totalPrice = calculateTotalPrice();

    }

    public void deleteProductToCart(Long id) {
        Optional<OrderItemDto> orderItemDto = orderItems.stream()
                .filter(it -> it.getProductId().equals(id))
                .findFirst();
        if (orderItemDto.isPresent()) {
            final OrderItemDto orderItem = orderItemDto.get();
            if (orderItem.getQuantity()== 0) {
                return;
            }
            orderItem.setQuantity(orderItem.getQuantity() - 1);
            totalPrice = calculateTotalPrice();
        }
    }

    public void clear() {
        orderItems.clear();
        totalPrice = BigDecimal.valueOf(0);
    }

    private BigDecimal calculateTotalPrice() {
        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        for (OrderItemDto order: orderItems) {
           itemCost = order.getProductPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
          totalCost = totalCost.add(itemCost);
        }
        return totalCost;
    }


}
