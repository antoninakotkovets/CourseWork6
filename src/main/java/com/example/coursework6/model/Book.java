package com.example.coursework6.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//название, автор, год издания, стоимость, жанр, страницы, вес, изготвитель, картинка
public class Book extends IdField {
    private String name;
    private String author;
    private  int yearOfPublishing;
    private int price;
    private String genre;
    private String numberOfPages;
    private int weight;
    private String manufacturer;
    private String image;

    @Column(name = "is_deleted", columnDefinition = "bit default 0")
    private boolean isDeleted;

}
