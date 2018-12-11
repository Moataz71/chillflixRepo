package com.molveno.molveno.restaurant.menu;

public class DishLogic {

    /**
     *  Dish price for the chef
     * @param dish
     * @return
     */
    public static double calculateDishprice(Dish dish) {

        double total = 0;

        for (Ingredient ingredient : dish.getIngredients()) {
            total = total + ingredient.getPriceIngredients();
        }


        return total;

    }


}