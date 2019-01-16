package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.table.Tablee;

import java.time.LocalDateTime;

public class Reservation {
    private long id;
    private LocalDateTime ReservationsTime;
    private Guest guest;
    private Tablee table;


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

    public Tablee getTable() {
        return table;
    }

    public void setTable(Tablee table) {
        this.table = table;
    }
}
