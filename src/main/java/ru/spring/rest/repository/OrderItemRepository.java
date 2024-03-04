package ru.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.rest.entity.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<Long, OrderItem> {
}
