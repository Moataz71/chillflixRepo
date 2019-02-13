package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.table.Tablee;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    @Column(name = "reservationtime")
    private LocalDateTime reservationTime;


    //@OneToMany
//@JoinColumn(name = "reservationid",referencedColumnName = "id")
    @ManyToMany
    @JoinTable(name = "tabelreservation",
            joinColumns = {@JoinColumn(name = "reservationid")},
            inverseJoinColumns = {@JoinColumn(name = "tableid")})
    private List<Tablee> tablees;

    public List<Tablee> getTablees() {
        return tablees;
    }

    public void setTablees(List<Tablee> tablees) {
        this.tablees = tablees;
    }
//@JoinColumn(name="tableid",referencedColumnName = "id")
//@OneToOne
//private Tablee tablee;


    @JoinColumn(name = "guestid", referencedColumnName = "id")
    @OneToOne

    private Guest guest;
    @Column(name = "numberofpople")
    private int numberOfpoeple;

    public int getNumberOfpoeple() {
        return numberOfpoeple;
    }

    public void setNumberOfpoeple(int numberOfpoeple) {
        this.numberOfpoeple = numberOfpoeple;
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


    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }


}
