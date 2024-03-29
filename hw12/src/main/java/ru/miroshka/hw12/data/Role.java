package ru.miroshka.hw12.data;

//import jakarta.persistence.*;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private  String name;
}
