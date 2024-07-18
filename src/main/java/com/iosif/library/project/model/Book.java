package com.iosif.library.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Setter
    private String name;

    @Column(name = "author")
    @Setter
    private String author;

    @Column(name = "age")
    @Setter
    private Integer age;

    public Book(String name, String author, Integer age) {
        this.name = name;
        this.author = author;
        this.age = age;
    }
}


