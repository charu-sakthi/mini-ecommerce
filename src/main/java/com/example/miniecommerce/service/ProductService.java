
package com.example.miniecommerce.service;

import com.example.miniecommerce.model.Product;
import com.example.miniecommerce.repository.ProductRepository;
import com.example.miniecommerce.exception.ProductNotFoundException;
import com.example.miniecommerce.dto.ProductResponseDTO;
import com.example.miniecommerce.dto.ProductRequestDTO;
import com.example.miniecommerce.mapper.ProductMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // Constructor injection
    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // Add or update a product using Product entity
    public Product saveProduct(Product product) {

        if (product.getId() != null) {
            getProductById(product.getId());
        }

        return productRepository.save(product);
    }

    // Add a new product using ProductRequestDTO and MapStruct
    public Product saveProduct(ProductRequestDTO dto) {
        Product product = productMapper.toProduct(dto);
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id: " + id
                        )
                );
    }

    // Convert Product entity into ProductResponseDTO using MapStruct
    public ProductResponseDTO getProductResponse(Long id) {
        Product product = getProductById(id);
        return productMapper.toProductResponseDTO(product);
    }

    // Delete a product after checking whether it exists
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
