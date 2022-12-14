package com.example.coursework6.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
//класс доставка: город, улица, номер дома, подъезд, этаж, квартира, номер телефона
public class Delivery  extends IdField{
    private String name;
    private String surname;
    private String city;
    private String street;
    private int houseNumber;
    private int entranceNumber;
    private int floor;
    private int flatNumber;
    private String phoneNumber;

    public Delivery(){}
}
