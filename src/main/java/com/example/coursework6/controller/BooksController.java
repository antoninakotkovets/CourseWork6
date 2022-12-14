package com.example.coursework6.controller;


import com.example.coursework6.model.Book;
import com.example.coursework6.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/add")
    public boolean add(@RequestBody Book book){
        return booksService.saveBooks(book);
    }

    /*@GetMapping("/getAll")
    public List<Book> getAll(){
        return booksService.getAll();
    }*/

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return booksService.getAll().stream().filter(u -> !u.isDeleted()).collect(Collectors.toList());
    }
    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable int id){
        return booksService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable Integer id){
        return booksService.deleteBook(id);
    }

    @PutMapping("/edit/{id}")
    public Book editInfo(@PathVariable Integer id, @RequestBody Book book){
        return booksService.editInfo(id, book);
    }

    @GetMapping()
    public List<Book> filtering(@RequestParam String valueForSearch) {
        return booksService.findByNameContaining(valueForSearch);
    }

    //GET http://localhost:8080/books/genre?genre=Roman
    @GetMapping("/genre")
    public List<Book> filteringByGenre(@RequestParam String genre) {
        return booksService.findByGenreCaseIgnoreCase(genre);
    }

//    @PostMapping("/genre")
//    public List<Book> filteringByGenre(@RequestBody Map<String, String> params) {
//        return booksService.findByGenreCaseIgnoreCase(params.get("genre"));
//    }

}
