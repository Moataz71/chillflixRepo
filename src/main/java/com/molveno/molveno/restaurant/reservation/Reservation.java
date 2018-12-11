package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.table.Table;
import java.time.LocalDateTime;

public class Reservation {
    private long id;
    private LocalDateTime ReservationsTime;
    private Guest guest;
    private Table table;


    public LocalDateTime getReservationsTime() {
        return ReservationsTime;
    }

    public void setReservationsTime(LocalDateTime reservationsTime) {
        ReservationsTime = reservationsTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
