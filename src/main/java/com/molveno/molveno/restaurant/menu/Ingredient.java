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
@Column(name = "priceperquantityingredient")
    private double pricePerquantityIngredient;


    public double getPricePerquantityIngredient() {
        return pricePerquantityIngredient;
    }

    public void setPricePerquantityIngredient(double pricePerquantityIngredient) {
        this.pricePerquantityIngredient = pricePerquantityIngredient;
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


