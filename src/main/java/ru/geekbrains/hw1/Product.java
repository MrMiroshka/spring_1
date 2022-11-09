package ru.geekbrains.hw1;

public class Product {
 //(id, title, cost);
 private final Integer id;
 private final String title;
 private final int cost;

    private Product (Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.cost = builder.cost;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    public static class Builder {
        private Integer id;
        private String title;
        private int cost;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder cost(int cost) {
            this.cost = cost;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

}
