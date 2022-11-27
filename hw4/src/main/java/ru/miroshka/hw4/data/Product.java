package ru.miroshka.hw4.data;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder

public class Product {
    private final Long id;
    private final String title;
    private final Integer cost;

}
