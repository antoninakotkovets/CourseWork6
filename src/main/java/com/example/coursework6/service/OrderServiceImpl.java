package com.example.coursework6.service;

import com.example.coursework6.model.Book;
import com.example.coursework6.model.Delivery;
import com.example.coursework6.model.Order;
import com.example.coursework6.model.User;
import com.example.coursework6.repository.BooksRepository;
import com.example.coursework6.repository.OrderRepository;
import com.example.coursework6.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public boolean saveOrder(@RequestBody Order order){
        //order.setUser(usersRepository.findById(userId).get());
        orderRepository.save(order);
        return true;
    }

    @Override
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @Override
    public boolean addNewOrder(Map<String, Object> params) {
        System.out.println(params);
        Delivery destination = Delivery.builder()
                .name(String.valueOf(params.get("name")))
                .surname(String.valueOf(params.get("surname")))
                .city(String.valueOf(params.get("city")))
                .street(String.valueOf(params.get("street")))
                .houseNumber(Integer.parseInt(String.valueOf(params.get("houseNumber"))))
                .floor(Integer.parseInt(String.valueOf(params.get("floor"))))
                .entranceNumber(Integer.parseInt(String.valueOf(params.get("entranceNumber"))))
                .flatNumber(Integer.parseInt(String.valueOf(params.get("flatNumber"))))
                .phoneNumber(String.valueOf(params.get("phoneNumber")))
                .build();
        User user = usersRepository.findById(parseMapToMap("currentUser", params)).get();
        Book book = booksRepository.findById(parseMapToMap("bookId", params)).get();

        Order order = new Order(user, new Date(), book, destination);
        orderRepository.save(order);
        return true;
    }

    private Integer parseMapToMap(String field, Map<String, Object> params) {
        return Integer.parseInt(String.valueOf(params.get(field)));
    }

    @Override
    public int calcProfit() {
        return orderRepository.findAll().stream().flatMapToInt(e -> IntStream.of(e.getBook().getPrice())).sum();
    }

}
