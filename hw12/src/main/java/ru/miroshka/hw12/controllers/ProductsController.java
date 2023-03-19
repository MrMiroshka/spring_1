package ru.miroshka.hw12.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.hw12.converters.ProductConverter;
import ru.miroshka.hw12.data.Product;
import ru.miroshka.hw12.dto.ProductDto;
import ru.miroshka.hw12.service.ProductsService;
import ru.miroshka.hw12.validators.ProductValidator;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping("/{id}")
    public List<ProductDto> getProduct(@PathVariable Long id) {
         List<ProductDto> lpDto= new ArrayList<>();
         lpDto.add(productConverter.entityToDto(productsService.findById(id)));
         return lpDto;
       /* List<ProductDto> listPDto = new ArrayList<>();
        for (Product p:this.productsService.getProduct(id)) {
            listPDto.add(new ProductDto(p));
        }
        return listPDto;*/
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productsService.delProductById(id);
    }

    @DeleteMapping("/basket/{id}")
    public void deleteProductBasket(@PathVariable Long id) {
        this.productsService.delProductBasketById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto postProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        productDto.setId(null);
        Product product = this.productsService.addProduct(productConverter.dtoToEntity(productDto));
        return productConverter.entityToDto(product);
    }


    @GetMapping("/basket/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<ProductDto> getProductBasket(
    ) {
        List<Product> listProduct = this.productsService.getProductsFromBasket();
        List<ProductDto> listProductDto = new ArrayList<>();
        for (Product p: listProduct) {
            listProductDto.add(productConverter.entityToDto(p));
        }
        return new PageImpl<>(listProductDto);
    }

    @GetMapping("/basket/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<ProductDto>  putProductToBasket(@PathVariable Long id) {
        List<Product> listProduct = this.productsService.putProductToBasket((this.productsService.findById(id)));
        List<ProductDto> listProductDto = new ArrayList<>();
        for (Product p: listProduct) {
            listProductDto.add(productConverter.entityToDto(p));
        }
        return new PageImpl<>(listProductDto);

 /*       productDto.setId(null);
        Product product = this.productsService.addProduct(productConverter.dtoToEntity(productDto));
        return productConverter.entityToDto(product);*/
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        this.productsService.changeProduct(productConverter.dtoToEntity(productDto));
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
        return this.productsService.find(minCost, maxCost, nameProduct, page, pageSize).map(
                //  p -> new ProductDto(p.getId(),p.getName(),p.getCost())
                p->productConverter.entityToDto(p)
        );
    }


}
