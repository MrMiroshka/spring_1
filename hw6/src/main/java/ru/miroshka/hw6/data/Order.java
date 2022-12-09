package ru.miroshka.hw6.data;

import jakarta.persistence.*;

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


    public Order() {
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
