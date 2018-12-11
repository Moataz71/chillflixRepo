package com.molveno.molveno.restaurant.menu;

public class Ingredient {
    private long id;
    private String ingredientsName;
    private double priceIngredients;


    public double getPriceIngredients() {
        return priceIngredients;
    }

    public void setPriceIngredients(double priceIngredients) {
        this.priceIngredients = priceIngredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }


}


