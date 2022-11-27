package ru.miroshka.hw4.data;

public enum DictionaryProductsName {
    SAUSAGE("Колбаса"),
    CHEESE("Сыр"),
    EGG("Яйцо"),
    MILK("Молоко"),
    POTATOES("Картошка"),
    TOMATO("Помидор"),
    BUTTER("Сливочное масло"),
    PEPPER("Перец"),
    BREAD("Хлеб"),
    BANANA("Банан"),
    BLACKBERRY("Ежевика"),
    APPLE("Яблоко");

    private String title;

    DictionaryProductsName(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                '}';
    }
}
