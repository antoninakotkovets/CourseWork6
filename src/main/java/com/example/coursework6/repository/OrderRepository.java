package com.example.coursework6.repository;

import com.example.coursework6.model.Book;
import com.example.coursework6.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order, Integer> {

    Order findById(int id);

}
