package ru.spring.rest.component;

import org.springframework.stereotype.Component;
import ru.spring.rest.entity.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class Cart {
    private List<OrderItem> orderItems;
    private BigDecimal totalPrice;

    public Cart(List<OrderItem> orderItems, BigDecimal totalPrice) {
        this.orderItems = new ArrayList<>();
        this.totalPrice = calculateTotalPrice();
    }

    private BigDecimal calculateTotalPrice() {
        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        for (OrderItem order: orderItems) {
           itemCost = order.getProductPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
          totalCost = totalCost.add(itemCost);
        }
        return totalCost;
    }


}
