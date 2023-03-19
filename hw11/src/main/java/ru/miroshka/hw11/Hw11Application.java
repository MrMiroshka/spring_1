package ru.miroshka.hw11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;

@SpringBootApplication
public class Hw11Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw11Application.class, args);
        //.execute(conn, new FileReader("test.sql"));
    }

}
