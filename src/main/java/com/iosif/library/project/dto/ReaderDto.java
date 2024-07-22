package com.iosif.library.project.dto;

import com.iosif.library.project.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {

    private String nameSurname;
    private int age;
    private Book reservedBook;
}
