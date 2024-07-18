package com.iosif.library.project.repository;

import com.iosif.library.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    List<Book> findByName(String name);
}
