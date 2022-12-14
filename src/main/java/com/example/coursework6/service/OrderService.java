package com.example.coursework6.service;

import com.example.coursework6.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    boolean saveOrder(Order order);
    List<Order> getAll();

    int calcProfit();
    boolean addNewOrder(Map<String, Object> params);
}
