package ru.miroshka.hw9.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.hw9.data.Product;
import ru.miroshka.hw9.dto.ProductDto;
import ru.miroshka.hw9.service.ProductService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public List<ProductDto> getProduct(@PathVariable Long id) {
        List<ProductDto> listPDto = new ArrayList<>();
        for (Product p:this.productService.getProduct(id)) {
            listPDto.add(new ProductDto(p));
        }
        return listPDto;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.delProductById(id);
    }

/*    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postProduct(@RequestParam String name, @RequestParam int cost) {
        this.productService.addProduct(name, cost);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postProduct(@RequestBody ProductDto productDto) {
        productDto.setId(null);
        this.productService.addProduct(new Product(productDto));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody ProductDto productDto) {
        this.productService.changeProduct(new Product(productDto));
    }

    @GetMapping
    public Page<ProductDto> getProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "name_product", required = false) String nameProduct,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
    ) {
        if (page < 1) {
            page = 1;
        }
        return this.productService.find(minCost, maxCost, nameProduct, page, pageSize).map(
                p -> new ProductDto(p)
        );
    }


}
