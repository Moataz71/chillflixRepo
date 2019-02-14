package com.molveno.molveno.restaurant.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.molveno.molveno.restaurant.order.OrderLogic;
import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.stereotype.Component;


public class ReservationLogic {



   public static boolean checkDateTime(LocalDateTime reservationRequest, List<Reservation> currentReservations, Tablee table) {
        long tableId = table.getId();

        LocalDateTime min = reservationRequest.minusHours(3);
        LocalDateTime max = reservationRequest.plusHours(3);

        A:for (Reservation current : currentReservations) {

            B:for (int i=0;i<current.getTablees().size();i++) {
                if (current.getTablees().get(i).getId() != tableId) {
                    if(i==current.getTablees().size()-1){continue A; }
                    continue B;
                }

                if (current.getReservationTime().isBefore(max) && current.getReservationTime().isAfter(min)) {
                    return false;
                }
            }

        }

        return true;
    }


    public static List<Tablee> getAvailableTables(LocalDateTime reservationRequest, List<Tablee> tables, List<Reservation> reservations) {
        List<Tablee> availableTables = new ArrayList<>();
        for (Tablee table : tables) {
            if (checkDateTime(reservationRequest, reservations, table)) {
                availableTables.add(table);

            }

        }

        return availableTables;


    }

/*
    public static boolean checkDateTime(LocalDateTime reservationRequest, List<Reservation> currentReservations, Tablee table) {
        long tableId = table.getId();

        LocalDateTime min = reservationRequest.minusHours(3);
        LocalDateTime max = reservationRequest.plusHours(3);

        for (Reservation current : currentReservations) {
            if (current.getTablee().getId() != tableId) {
                continue;
            }
            if (current.getReservationTime().isBefore(max) && current.getReservationTime().isAfter(min)) {
                return false;
            }
        }

        return true;
    }



    public static List<Tablee> getAvailableTables(LocalDateTime reservationRequest, List<Tablee> tables, List<Reservation> reservations) {
        List<Tablee> availableTables = new ArrayList<>();
        for (Tablee table : tables) {
            if (checkDateTime(reservationRequest, reservations, table)) {
                availableTables.add(table);

            }

        }

        return availableTables;


    }







*/
}





















