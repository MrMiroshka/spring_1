package ru.miroshka.hw12.validators;

import org.springframework.stereotype.Component;
import ru.miroshka.hw12.dto.ProductDto;
import ru.miroshka.hw12.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public  void  validate (ProductDto productDto){
        List<String> errors = new ArrayList<>();
        if (productDto.getCost() < 1) {
            errors.add("Цена продукта не может быть меньше 1");
        }

        if (productDto.getName().isBlank()){
            errors.add("Продукт не может иметь пустое название");
        }

        if (!errors.isEmpty()){
            throw new ValidationException(errors );
        }
    }
}
