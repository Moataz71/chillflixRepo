package com.molveno.molveno.restaurant.menu;

import javax.persistence.*;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    @Column(name = "ingredientsname")
    private String ingredientsName;
    @Column(name = "priceingredients")
    private double priceIngredients;
    @Column(name = "ingredientquantitytype")
private String ingredientQuantityType;


    public String getIngredientQuantityType() {
        return ingredientQuantityType;
    }

    public void setIngredientQuantityType(String ingredientQuantityType) {
        this.ingredientQuantityType = ingredientQuantityType;
    }

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


