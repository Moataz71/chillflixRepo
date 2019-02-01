package com.molveno.molveno.restaurant.bill;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.order.Order;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Bill {

    private int id;

    private Order order;
    private Guest guest;

    private LocalDateTime t;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDateTime getT() {
        return t;
    }

    public void setT(LocalDateTime t) {
        this.t = t;
    }

    static void generateBill() {
        Bill bill = new Bill();

        System.out.println();

    }
}
