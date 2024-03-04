package ru.spring.rest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="names")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "createdDateTime")
    @CreatedDate
    private LocalDateTime createdDateTime;
    @Column(name = "updatedDateTime")
    @LastModifiedDate
    private LocalDateTime updatedDateTime;
}
