package com.example.coursework6.service;


import com.example.coursework6.model.Book;
import com.example.coursework6.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class BooksServiceImpl implements  BooksService{

    @Autowired
    private BooksRepository booksRepository;


    @Override
    public boolean saveBooks(Book book){
        booksRepository.save(book);
        return true;
    }

    @Override
    public List<Book> getAll(){
        return booksRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return booksRepository.findById(id);
    }

    /*Override
    public boolean deleteBook(Integer id){
        booksRepository.deleteById(id);
        return true;
    }*/
    @Override
    public boolean deleteBook(Integer id){
        Book book = booksRepository.findById(id).get();
        book.setDeleted(true);
        booksRepository.save(book);
        return true;

    }

    @Override
    public Book editInfo(int id, Book book){
        Book found = booksRepository.findById(id);
        found.setName(book.getName());
        found.setAuthor(book.getAuthor());
        found.setGenre(book.getGenre());
        found.setManufacturer(book.getManufacturer());
        found.setPrice(book.getPrice());
        found.setWeight(book.getWeight());
        found.setNumberOfPages(book.getNumberOfPages());
        found.setYearOfPublishing(book.getYearOfPublishing());
        found.setImage(book.getImage());


        return booksRepository.save(found);
    }

    @Override
    public List<Book> findByNameContaining(String value) {
        return booksRepository.findByNameContaining(value);
    }

    @Override
    public List<Book> findByGenreCaseIgnoreCase(String valueForSearch) {
        return booksRepository.findByNameContaining(valueForSearch);
    }

}
