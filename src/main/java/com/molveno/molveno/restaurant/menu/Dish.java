package com.molveno.molveno.restaurant.menu;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    @Column(name = "ingredientsquan")
    private String ingredientsQuan;

    @Column(name = "dishname")
    private String dishName;
    @Column(name = "dishprice")
    private double dishPrice;

    @Column(name = "dishtype")
    private String dishType;

    @ManyToMany
    @JoinTable(name = "dishingredients",
            joinColumns = {@JoinColumn(name = "dishid")},
            inverseJoinColumns = {@JoinColumn(name = "ingredientsid")})
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }






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

    public String getIngredientsQuan() {
        return ingredientsQuan;
    }

    public void setIngredientsQuan(String ingredientsQuan) {
        this.ingredientsQuan = ingredientsQuan;
    }

//public  void dishprice(){
    //dishPrice= ingredients.getPriceIngredients() + ingredients.getExtraPriceIngredients();


    // }


}

