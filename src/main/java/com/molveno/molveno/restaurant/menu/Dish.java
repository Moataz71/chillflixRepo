package com.molveno.molveno.restaurant.menu;

import java.util.List;

public class Dish {
    private long id;
    private String dishName;
    private double dishPrice;
    // create an array of ingredients
    private List<Ingredient> ingredients;


    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return dishPrice;
    }

    public void setPrice(double price) {
        this.dishPrice = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    //public  void dishprice(){
    //dishPrice= ingredients.getPriceIngredients() + ingredients.getExtraPriceIngredients();


    // }


}

