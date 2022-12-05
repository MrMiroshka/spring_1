package ru.miroshka.hibernate.zadanie_1_2;

import jakarta.persistence.*;
import ru.miroshka.hibernate.UserDetails;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nanme")
    private String name;

    @OneToOne
    @JoinColumn(name = "details_id")
    private UserDetails details;

    public User() {
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

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return String.format("User [id = %d, name = '%s']", id, name);
    }
}
