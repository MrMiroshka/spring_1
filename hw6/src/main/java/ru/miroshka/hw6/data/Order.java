package ru.miroshka.hw6.data;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity

@Table(name = "order_product")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "id_customer")
    private Customer customer;


    @ManyToOne
    @JoinColumn (name = "id_product")
    private Product product;

    @Column(name = "cost")
    private int cost;

    @Column(name = "count")
    private int count;

    @Column(name = "time_order")
    private OffsetDateTime dateTime;

    public Order() {
    }

    public int getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer.toString() +
                ", product=" + product.toString() +
                '}';
    }
}
