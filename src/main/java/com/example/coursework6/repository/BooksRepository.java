package com.example.coursework6.repository;

import com.example.coursework6.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository <Book, Integer> {

    Book findById(int id);
//    @Query("SELECT new Book (b.id as id, b.author as author, ) from Book b")
//    @Query("SELECT b from Book b where b.name")
    List<Book> findByNameContaining(String value);
    List<Book> findByGenreIgnoreCase(String genre);
}
