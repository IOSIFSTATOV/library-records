package com.iosif.library.project.controller;

import com.iosif.library.project.PersonDto.BookDto;
import com.iosif.library.project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        this.bookService.addBook(bookDto);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping
    @RequestMapping("/author")
    public List<BookDto> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping
    @RequestMapping("/name")
    public List<BookDto> findByName(@RequestParam String name) {
        return bookService.findByAuthor(name);
    }

}
