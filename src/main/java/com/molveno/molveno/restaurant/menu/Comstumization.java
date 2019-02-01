package com.molveno.molveno.restaurant.menu;

import javax.persistence.*;

public class Comstumization {
private long id;

    private double costumizationPrice;

    private double effortPrice;
    private Ingredient ingredient;
    private Dish dish;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCostumizationPrice() {
        return costumizationPrice;
    }

    public void setCostumizationPrice(double costumizationPrice) {
        this.costumizationPrice = costumizationPrice;
    }

    public double getEffortPrice() {
        return effortPrice;
    }

    public void setEffortPrice(double effortPrice) {
        this.effortPrice = effortPrice;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
