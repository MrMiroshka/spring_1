package ru.geekbrains.spring_hw2;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

@Getter
@Builder
@Scope("prototype")
public class Product {
    private final long id;
    private final String title;
    private final int cost;

}
