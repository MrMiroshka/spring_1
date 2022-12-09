package ru.miroshka.hw6.data;

import jakarta.persistence.*;

import java.util.List;


@Entity

@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_customer")
    private Long id;

    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
