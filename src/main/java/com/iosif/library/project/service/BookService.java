package com.iosif.library.project.service;

import com.iosif.library.project.dto.BookDto;
import com.iosif.library.project.model.Book;
import com.iosif.library.project.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public void addBook(BookDto bookDto) {
        Book book = new Book(bookDto.getName(), bookDto.getAuthor(), bookDto.getAge());
        bookRepository.save(book);
    }

    public List<BookDto> findByAuthor(String author) {
        return bookRepository.findByAuthor(author)
                .stream()
                .map(book -> new BookDto(book.getName(), book.getAuthor(), book.getAge()))
                .toList();
    }

    public List<BookDto> findByName(String name) {
        return bookRepository.findByAuthor(name)
                .stream()
                .map(book -> new BookDto(book.getName(), book.getAuthor(), book.getAge()))
                .toList();
    }

    public List<BookDto> getAllBooks() {
        Iterable<Book> books = bookRepository.findAll();
        return StreamSupport.stream(books.spliterator(), false)
                .map(book -> new BookDto(book.getName(), book.getAuthor(), book.getAge()))
                .toList();
    }

}
