package com.molveno.molveno.restaurant.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.table.Table;

public class ReservationLogic {
    /**
     * check reservation based on user request datetime and current reservation , table
     *
     * @param reservationRequest
     * @param currentReservations
     * @param table
     * @return
     */


    public static boolean checkDateTime(LocalDateTime reservationRequest, List<Reservation> currentReservations, Table table) {
        long tableId = table.getId();

        LocalDateTime min = reservationRequest.minusHours(3);
        LocalDateTime max = reservationRequest.plusHours(3);

        for (Reservation current : currentReservations) {
            if (current.getTable().getId() != tableId) {
                continue;
            }
            if (current.getReservationsTime().isBefore(max) && current.getReservationsTime().isAfter(min)) {
                return false;
            }
        }

        return true;
    }

    /**
     * check available table based on user request(datetime) and tables, reservation
     * adds not reserved tables in table object
     *
     * @param reservationRequest
     * @param tables
     * @param reservations
     * @return
     */
    public static List<Table> getAvailableTables(LocalDateTime reservationRequest, List<Table> tables, List<Reservation> reservations) {
        List<Table> availableTables = new ArrayList<>();
        for (Table table : tables) {
            if (checkDateTime(reservationRequest, reservations, table)) {
                availableTables.add(table);

            }

        }

        return availableTables;


    }


    public static void doReserve(LocalDateTime reservationRequest,List<Table> tables,List<Reservation> reservations,Reservation reservation){
        int i=0;
        if((getAvailableTables(reservationRequest,tables,reservations )!=null)) {

            reservation.setTable(getAvailableTables(reservationRequest, tables, reservations).get(i));
            reservation.setReservationsTime(reservationRequest);
            getAvailableTables(reservationRequest, tables, reservations).remove(i);
            reservations.add(reservation);
        }


    }





    public static void cancel(Reservation reservation,List<Reservation> reservations){
        if(reservations.contains(reservation)){

            reservations.remove(reservation);


        }



    }









}





















