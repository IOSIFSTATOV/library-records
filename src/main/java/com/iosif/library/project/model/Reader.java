package com.iosif.library.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reader")
@Getter
@NoArgsConstructor
public class Reader {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_surname")
    @Setter
    private String nameSurname;

    @Column(name = "age")
    @Setter
    private Integer age;

    @OneToOne
    @Setter
    @Getter
    private Book reservedBook;

    public Reader(String nameSurname, Integer age, Book reservedBook) {
        this.nameSurname = nameSurname;
        this.age = age;
        this.reservedBook = reservedBook;
    }

}
