package com.example.javawebcourse.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.javawebcourse.dto.ProductDTO;
import com.example.javawebcourse.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import com.example.javawebcourse.domain.Product;
import com.example.javawebcourse.web.exception.DuplicateProductNameException;
import com.example.javawebcourse.web.exception.ProductNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        return products.stream()
                .map(productMapper::toProductDTO)
                .toList();
    }

    public ProductDTO getProductById(UUID id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .map(productMapper::toProductDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product = product.toBuilder().id(UUID.randomUUID()).build();
        products.add(product);
        return productMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

        products.remove(product);

        Product updatedProduct = productMapper.toProduct(productDTO).toBuilder().id(id).build();
        products.add(updatedProduct);
        return productMapper.toProductDTO(updatedProduct);
    }

    public void deleteProduct(UUID id) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

        products.remove(product);
    }
}