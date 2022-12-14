package com.example.coursework6.service;

import com.example.coursework6.model.Book;
import com.example.coursework6.model.Delivery;

import java.util.List;

public interface DeliveryService {
    boolean saveDelivery(Delivery delivery);
    List<Delivery> getAll();


}
