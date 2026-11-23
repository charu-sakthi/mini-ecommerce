package com.example.miniecommerce.mapper;

import com.example.miniecommerce.model.Product;
import com.example.miniecommerce.dto.ProductRequestDTO;
import com.example.miniecommerce.dto.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequestDTO dto);

    ProductResponseDTO toProductResponseDTO(Product product);
}