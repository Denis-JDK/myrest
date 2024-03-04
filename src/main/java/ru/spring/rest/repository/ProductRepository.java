package ru.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.rest.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Long, Product> {
}