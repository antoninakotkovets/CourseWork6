package com.example.coursework6.controller;


import com.example.coursework6.model.Delivery;
import com.example.coursework6.model.Order;
import com.example.coursework6.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @PostMapping("/add")
//    public boolean add(@RequestBody int currentUser,
////                       @RequestBody int bookId,
//                       @RequestBody String name,
//                       @RequestBody String surname,
//                       @RequestBody String city,
//                       @RequestBody String street,
//                       @RequestBody int houseNumber,
//                       @RequestBody int entranceNumber,
//                       @RequestBody int floor,
//                       @RequestBody int flatNumber,
//                       @RequestBody String phoneNumber){
//        System.out.println(123);
//        return true;
//    };
//
    @PostMapping("/add")
    public boolean add(@RequestBody Map<String, Object> params) {
        orderService.addNewOrder(params);
        return true;
    }

    @GetMapping("/getAll")
    public List<Order> getAll(){
        return orderService.getAll();
    }
    @GetMapping("/profit")
    public int calcProfit(){
        return orderService.calcProfit();
    }

}
