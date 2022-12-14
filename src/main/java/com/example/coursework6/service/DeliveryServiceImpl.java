package com.example.coursework6.service;


import com.example.coursework6.model.Book;
import com.example.coursework6.model.Delivery;
import com.example.coursework6.repository.DeliveryRepository;
import com.example.coursework6.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public boolean saveDelivery(Delivery delivery){
        //delivery.setUser(usersRepository.findById(userId).get());
        deliveryRepository.save(delivery);
        return true;
    }
    @Override
    public List<Delivery> getAll(){
        return deliveryRepository.findAll();
    }


}
