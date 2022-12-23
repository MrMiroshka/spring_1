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

    /**
     * Удаляет первый попавшийся продукт в корзине с заданным id
     */
    public void deleteById(Long id) {
        for (Product p : listProducts) {
            if (p.getId() == id) {
                listProducts.remove(p);
                break;
            }
        }
    }

    /**
     * Удаляет все продукт в корзине с заданным id
     */
    public void deleteByIdAll(Long id) {
        List<Product> listDelete = new ArrayList<>();
        for (Product p : listProducts) {
            if (p.getId() == id) {
                listDelete.add(p);
            }
        }

        for (Product p : listDelete) {
            listProducts.remove(p);
        }
    }
}
