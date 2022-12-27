package ru.miroshka.hw11.data;
import javax.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private  String name;
}
