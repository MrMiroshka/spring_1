package ru.miroshka.hw10.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.miroshka.hw10.data.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Data

public class Basket {
    List<Product> listProducts;

    public Basket() {
        listProducts = new ArrayList<>();
    }
}
