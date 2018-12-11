package com.molveno.molveno.hotel.room;


public class RoomType {
    private final String budget = "Budget";
    private final String standard = "Standard";
    private final String luxury = "Luxury";

    private final double budgetPrice = 80.00;
    private final double standardPrice = 100.00;
    private final double luxuryPrice = 140.00;

    public String getBudget() {
        return budget;
    }

    public String getStandard() {
        return standard;
    }

    public String getLuxury() {
        return luxury;
    }

    public double getBudgetPrice() {
        return budgetPrice;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public double getLuxuryPrice() {
        return luxuryPrice;
    }
}
