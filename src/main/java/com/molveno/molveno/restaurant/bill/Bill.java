package com.molveno.molveno.restaurant.bill;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.order.Order;
import com.molveno.molveno.restaurant.menu.Dish;
import com.molveno.molveno.restaurant.menu.Drink;
import com.molveno.molveno.restaurant.table.Table;
import com.molveno.molveno.restaurant.menu.Comstumization;
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
