package com.molveno.molveno.hotel.Booking;

import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class Booking {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Room room;
    private Guest guest;

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getCheckIn(LocalDate date2) {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

}
