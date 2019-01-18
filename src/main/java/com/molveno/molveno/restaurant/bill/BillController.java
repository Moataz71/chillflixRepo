package com.molveno.molveno.restaurant.bill;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.order.Order;
import com.molveno.molveno.restaurant.menu.Dish;
import com.molveno.molveno.restaurant.menu.Drink;
import com.molveno.molveno.restaurant.menu.Comstumization;




public class BillController {
    public Bill generateBill(Guest guest, Order order) {
        Bill bill = new Bill();
        bill.setGuest(guest);
        bill.setOrder(order);
        double amount = calculateTotal(order);
        return bill;
    }

    public double calculateTotal(Order order) {
        double total = 0;

        //all dishes, drinks, customs
        for (Dish d : order.getDishes()) {
            total = total + d.getPrice();
        }

       /* for(int i = 0; i < order.getDishes().size(); i++)
        {
            total = total + order.getDishes().get(i).getPrice();
        }*/
        for (Drink d : order.getDrinks()) {
            total = total + d.getPrice();
        }


        if(order.getComstumizations().size()>0)
        {
            for (Comstumization c : order.getComstumizations()) {
                total = total + c.getCostumizationPrice();
            }
        }



        return total;
    }
}
