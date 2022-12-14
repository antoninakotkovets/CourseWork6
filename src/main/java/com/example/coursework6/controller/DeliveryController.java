package com.example.coursework6.controller;


import com.example.coursework6.model.Delivery;
import com.example.coursework6.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/add")
    public boolean add(@RequestBody Delivery delivery){
        return deliveryService.saveDelivery(delivery);
    }

    @GetMapping("/getAll")
    public List<Delivery> getAll(){
        return deliveryService.getAll();
    }
}
