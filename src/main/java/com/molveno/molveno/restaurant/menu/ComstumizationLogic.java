package com.molveno.molveno.restaurant.menu;

public class ComstumizationLogic {
    /**
     * Calculation of effort price + extra ingredients prices
     * @param c
     * @return
     */
    public static double calculateCustomizationPrice(Comstumization c) {
        double total = c.getEffortPrice() + c.getIngredient().getPriceIngredients();
        return total;
    }
}
