package com.molveno.molveno.restaurant.menu;

public class Drink {
    private long id;
    private String name;
    private String DrinkType;
    // drinktype ? arr
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrinkType() {
        return DrinkType;
    }

    public void setDrinkType(String drinkType) {
        DrinkType = drinkType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
