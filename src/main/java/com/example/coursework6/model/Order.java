package com.example.coursework6.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ordr")
public class Order extends IdField {
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private User customer;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataOrder;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    private Book book;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    private Delivery destination;

    public Order(User customer, Date dataOrder, Book book, Delivery destination) {
        this.customer = customer;
        this.dataOrder = dataOrder;
        this.book = book;
        this.destination = destination;
    }
}
