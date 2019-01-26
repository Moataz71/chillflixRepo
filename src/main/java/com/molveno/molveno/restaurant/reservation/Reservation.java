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
    private LocalDateTime reservationTime;



    // many reservation to one guest
    //@Column(name = "guestid")
    //private long guestId;

    //@Column(name = "tableid")
    // many reservation to one table
    //private long tableId;

    @JoinColumn(name="tableid",referencedColumnName = "id")
    @ManyToOne

    private Tablee tablee;

    @JoinColumn(name="guestid",referencedColumnName = "id")
    @ManyToOne

    private Guest guest;
@Column(name = "numberofpople")
    private int numberOfPoeple;

    public int getNumberOfpoeple() {
        return numberOfPoeple;
    }

    public void setNumberOfpoeple(int numberOfpoeple) {
        this.numberOfPoeple = numberOfpoeple;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tablee getTablee() {
        return tablee;
    }

    public void setTablee(Tablee tablee) {
        this.tablee = tablee;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }


    /*public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }
    */
}
