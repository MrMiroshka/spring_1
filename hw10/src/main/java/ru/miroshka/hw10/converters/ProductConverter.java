package ru.miroshka.hw10.converters;

import org.springframework.stereotype.Component;
import ru.miroshka.hw10.data.Product;
import ru.miroshka.hw10.dto.ProductDto;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(),productDto.getName(),productDto.getCost());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getCost());
    }
}
