package com.molveno.molveno.restaurant.guest;

import javax.persistence.*;

@Entity
@Table
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    @Column
    private String name;

    @Column (name="mobilenumber")
    private String mobileNumber;

    @Column
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    //INSERT INTO Reservation (guestid, reservationtime,numberofpople) VALUES ('1', parseDateTime('2019020102900','yyyyMMddHHmmss'),'4');
}
