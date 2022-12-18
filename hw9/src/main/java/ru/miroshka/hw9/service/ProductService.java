package ru.miroshka.hw9.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.miroshka.hw9.data.Product;
import ru.miroshka.hw9.repositories.ProductDao;
import ru.miroshka.hw9.repositories.specifications.ProductsSpecifications;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class ProductService {
    private ProductDao productRepository;

    public ProductService(ProductDao productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> find(Integer minCost, Integer maxCost, String nameProduct, Integer page, Integer pageSize) {
        Specification<Product> spec = Specification.where(null);
        if (minCost != null) {
            spec = spec.and(ProductsSpecifications.costGreaterOrEqualsThen(minCost));
        }
        if (maxCost != null) {
            spec = spec.and(ProductsSpecifications.costLesserOrEqualsThen(maxCost));
        }
        if (nameProduct != null) {
            spec = spec.and(ProductsSpecifications.nameLike(nameProduct));
        }
        return this.productRepository.findAll(spec, PageRequest.of(page - 1, pageSize));

    }


    public List<Product> getProduct(Long id) {
        return this.productRepository.findById(id).stream().toList();
    }

    public void delProductById(Long id) {
        this.productRepository.deleteById(id);
    }

/*    public void addProduct(String name, Integer cost) {
        this.productRepository.save(new Product(name,cost));
    }*/

    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Transactional
    public void changeProduct(Product product) {
        Product productChange = this.productRepository.findById(product.getId()).orElseThrow(() ->
                new ResolutionException("В базе нет продукта с таким id"));
        if (product.getCost() != null && product.getCost() > 0) {
            productChange.setCost(product.getCost());
        }
        if (!product.getName().isEmpty() && product.getName().length() > 3) {
            productChange.setName(product.getName());
        }
    }
}
