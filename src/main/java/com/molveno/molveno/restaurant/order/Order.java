package com.molveno.molveno.restaurant.order;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.menu.Comstumization;
import com.molveno.molveno.restaurant.menu.Dish;
import com.molveno.molveno.restaurant.menu.Drink;
import com.molveno.molveno.restaurant.table.Table;

import java.util.List;

public class Order {
    private long id;
    private List<Dish> dishes;
    private List<Drink> drinks;
    private double totalPrice;
    private Table table;
    private Guest guest;
    private List<Comstumization> comstumizations;

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }


    public List<Comstumization> getComstumizations() {
        return comstumizations;
    }

    public void setComstumizations(List<Comstumization> comstumizations) {
        this.comstumizations = comstumizations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }


}
