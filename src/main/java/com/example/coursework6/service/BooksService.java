package com.example.coursework6.service;

import com.example.coursework6.model.Book;

import java.util.List;

public interface BooksService {
    boolean saveBooks(Book book);
    List<Book> getAll();

    Book getById(int id);
    boolean deleteBook(Integer id);
    Book editInfo(int id, Book book);
    List<Book> findByNameContaining(String value);
    List<Book> findByGenreCaseIgnoreCase(String valueForSearch);
}
