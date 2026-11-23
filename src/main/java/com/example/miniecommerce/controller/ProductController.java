
package com.example.miniecommerce.controller;

import com.example.miniecommerce.model.Product;
import com.example.miniecommerce.service.ProductService;
import com.example.miniecommerce.dto.ProductResponseDTO;
import com.example.miniecommerce.dto.ProductRequestDTO;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Add a new product using ProductRequestDTO with validation
    @PostMapping
    public Product addProduct(@Valid @RequestBody ProductRequestDTO dto) {
        return productService.saveProduct(dto);
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Get product response using DTO
    @GetMapping("/dto/{id}")
    public ProductResponseDTO getProductDTO(@PathVariable Long id) {
        return productService.getProductResponse(id);
    }

    // Update a product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {
        product.setId(id);
        return productService.saveProduct(product);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}
