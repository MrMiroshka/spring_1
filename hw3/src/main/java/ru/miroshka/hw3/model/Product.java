package ru.miroshka.hw3.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder

public class Product {
    private final long id;
    private final String title;
    private final int cost;

}
