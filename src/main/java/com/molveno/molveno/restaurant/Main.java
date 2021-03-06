package com.molveno.molveno.restaurant;


import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.menu.*;
import com.molveno.molveno.restaurant.order.Order;
import com.molveno.molveno.restaurant.order.OrderLogic;
import com.molveno.molveno.restaurant.reservation.*;
import com.molveno.molveno.restaurant.table.Tablee;
import com.molveno.molveno.general.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dish dish1 = new Dish();
        Ingredient ingredients1 = new Ingredient();
        Comstumization comstumization1 = new Comstumization();
        Order order = new Order();


        System.out.println("Welcome to Molveno Restaurant");
        Reservation reservation1 = new Reservation();
        Guest geust1 = new Guest();
        Tablee table11 = new Tablee();
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String x = sc.nextLine();
        geust1.setName(x);
        System.out.println("The name is " + geust1.getName());
        Scanner sc1 = new Scanner(System.in);
        System.out.println("What is your telephone number ?");
        String y = sc.nextLine();
        geust1.setMobileNumber(y);
        System.out.println("Your telephone number is  " + geust1.getMobileNumber());
        String email = "";
        do {
            System.out.println("What is your email address?");
            email = sc.nextLine();
        }
        while (!Validation.isValidEmail(email));

        geust1.setEmail(email);
        System.out.println("Your email  is  " + geust1.getEmail());
        Scanner sc2 = new Scanner(System.in);

        int z;
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setPriceIngredients(10);

        comstumization1.setEffortPrice(3);
        ingredients1.setPriceIngredients(50);
        List<Ingredient> ingredientlist = new ArrayList<>();
        ingredientlist.add(ingredients1);
        comstumization1.setIngredient(ingredient2);
        comstumization1.setDish(dish1);
        dish1.setIngredients(ingredientlist);

        comstumization1.setCostumizationPrice(ComstumizationLogic.calculateCustomizationPrice(comstumization1));
        dish1.setDishPrice(DishLogic.calculateDishprice(dish1));


        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);

        List<Comstumization> comstumizations = new ArrayList<>();
        comstumizations.add(comstumization1);


        order.setDishes(dishes);
        order.setComstumizations(comstumizations);


        System.out.println(OrderLogic.calculateTotalprice(order));


        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 05);


        LocalTime time = LocalTime.of(17, 0);

        LocalDateTime ReservationRequest = LocalDateTime.of(date, time);
        System.out.println("ReservationRequest is " + ReservationRequest);

        LocalDate date1 = LocalDate.of(2018, Month.DECEMBER, 05);


        LocalTime time1 = LocalTime.of(10, 0);

        LocalDateTime Reservation1 = LocalDateTime.of(date1, time1);

        LocalDate date2 = LocalDate.of(2018, Month.DECEMBER, 05);


        LocalTime time2 = LocalTime.of(23, 0);

        LocalDateTime Reservation2 = LocalDateTime.of(date2, time2);

        List<LocalDateTime> current = new ArrayList<>();
        current.add(Reservation1);
        current.add(Reservation2);
        // System.out.println("current is  " + current);

        //System.out.println(ReservationLogic.checkDateTime(ReservationRequest, current));




        Reservation rese1 = new Reservation();
        //rese1.setTable(table1);
        rese1.setReservationTime(Reservation1);

        Reservation rese2 = new Reservation();
       // rese2.setTable(table2);
        rese2.setReservationTime(Reservation2);
        List<Reservation> listReservations = new ArrayList<>();

        listReservations.add(rese1);
        listReservations.add(rese2);
        Reservation reservation3 = new Reservation();


        //System.out.println(ReservationLogic.getAvailableTables(ReservationRequest,tables,listReservations));
        //System.out.println(listReservations);


        // System.out.println(listReservations);
       // ReservationLogic.doReserve(ReservationRequest, tables, listReservations, reservation3);
        //System.out.println(listReservations);


        //ReservationLogic.cancel(reservation3, listReservations);
        //   ReservationLogic.cancel(rese1,listReservations);
        // ReservationLogic.cancel(rese2,listReservations);
        //   ReservationLogic.cancel(r,listReservations);


        //System.out.println((listReservations));

        //    System.out.println(reservation3.getTable().getId());
        //  System.out.println(reservation3.getReservationTime());
        //System.out.println(rese2.getTable().getId());
        //System.out.println(rese2.getReservationTime());
        //System.out.println(rese1.getTable().getId());
        //System.out.println(rese1.getReservationTime());

        //      LocalDate date4 = LocalDate.of(2018, Month.DECEMBER, 05);


//        LocalTime time4 = LocalTime.of(13, 0);

        //  LocalDateTime ReservationRequest2 = LocalDateTime.of(date4, time4);
        //System.out.println( ReservationLogic.getAvailableTables(ReservationRequest2,tables,listReservations).toString());



    }
}

