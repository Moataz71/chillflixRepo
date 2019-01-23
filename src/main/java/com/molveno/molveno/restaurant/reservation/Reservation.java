package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.table.Tablee;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    @Column(name = "reservationtime")
    private LocalDateTime ReservationTime;

    @JoinColumn(name = "guestid", referencedColumnName = "id")
    @ManyToOne
    // many reservation to one guest
    private Guest guest;

    @JoinColumn(name = "tableeid", referencedColumnName = "id")
    @ManyToOne
    // many reservation to one table
    private Tablee table;

    @Column
    public LocalDateTime getReservationTime() {
        return ReservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        ReservationTime = reservationTime;
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
