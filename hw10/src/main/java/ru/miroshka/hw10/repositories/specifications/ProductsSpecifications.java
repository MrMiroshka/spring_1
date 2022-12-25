package ru.miroshka.hw10.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.miroshka.hw10.data.Product;

public class ProductsSpecifications {
    //>=
    public static Specification<Product> costGreaterOrEqualsThen(Integer cost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .greaterThanOrEqualTo(root.get("cost"), cost);
    }

    //<=
    public static Specification<Product> costLesserOrEqualsThen(Integer cost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .lessThanOrEqualTo(root.get("cost"), cost);
    }

    //ищем продукты по части названия
    public static Specification<Product> nameLike(String nameProduct) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(root.get("name"), String.format("%%%s%%",nameProduct));
    }

}
