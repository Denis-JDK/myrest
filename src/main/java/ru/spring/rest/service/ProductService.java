package ru.spring.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.rest.dto.ProductDto;
import ru.spring.rest.exception.ResourceNotFoundException;
import ru.spring.rest.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
private final ProductRepository productRepository;

public ProductDto findById(Long id) {
    return productRepository.findById(id).map(ProductDto::new)
            .orElseThrow(()->new ResourceNotFoundException(String.format("product with id %d not found", id)));
}
}
