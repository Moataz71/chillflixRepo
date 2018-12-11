package com.molveno.molveno.hotel;


import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;
import com.molveno.molveno.hotel.Booking.Booking;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Welcome to the Molveno Hotel Portal!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Check-In Date:  (yyyy-MM-dd)");

        String checkIn = scanner.nextLine();

        LocalDate date2 = null;

        //Parsing the String
        date2 = LocalDate.parse(checkIn);//dateFormat.parse(checkIn);

        while (date2.compareTo(LocalDate.now()) < 0) {
            System.out.println("Enter the Correct Check-In Date: (yyyy-MM-dd) ");
            checkIn = scanner.nextLine();
            date2 = LocalDate.parse(checkIn);
        }
        Booking booking = new Booking();
        booking.setCheckIn(date2);

        System.out.println("Enter the Check-Out Date: (yyyy-MM-dd) ");

        String checkOut = scanner.nextLine();

        LocalDate date3 = null;

        date3 = LocalDate.parse(checkOut);

        booking.setCheckOut(date3);

        System.out.println("Guest Count: ");
        int guestCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rooms are available:" + "\n" + "*Budget = 80 Euro" + "\n" + "*Standard = 100 Euro" + "\n" + "*Lux = 140 Euro");
        System.out.println("Enter your Choice: ");
        String roomChoice = scanner.nextLine();
        System.out.println("Enter your full name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Address: ");
        String address = scanner.nextLine();

        System.out.println("Country: ");
        String country = scanner.nextLine();

        System.out.println("Nationality: ");
        String nationality = scanner.nextLine();

        Guest guestInfo = new Guest();
        guestInfo.setName(name);
        guestInfo.setEmail(email);
        guestInfo.setPhone(phoneNumber);
        guestInfo.setAddress(address);
        guestInfo.setCountry(country);
        guestInfo.setNationality(nationality);

        Date date = new Date();
        // display time and date using toString()
        System.out.println(date.toString());


        LocalDate BookingRequest = LocalDate.of(2018, Month.DECEMBER, 05);
        System.out.println("ReservationRequest is " + BookingRequest);


        LocalDate checkInDate = LocalDate.of(2018, Month.DECEMBER, 05);
        //LocalDate Booking1 = LocalDate.of(checkInDate);

        LocalDate checkOutDate = LocalDate.of(2018, Month.DECEMBER, 06);

        //LocalDate Booking2 = LocalDate.of(checkOutDate);

        List<LocalDate> current = new ArrayList<>();
        //current.add(Booking1);
        //current.add(Booking2);

        System.out.println("current is  " + current);

        //System.out.println(ReservationLogic.checkDateTime(ReservationRequest, current));

        Room room1 = new Room();
        room1.setId(1);

        Room room2 = new Room();
        room2.setId(2);

        Room room3 = new Room();
        room3.setId(3);

        Room room4 = new Room();
        room4.setId(4);

        //boolean timeAvailable = ReservationLogic.checkDateTime(ReservationRequest, current);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        System.out.println(rooms);

        Booking rese1= new Booking();
        rese1.setRoom(room1);
       // rese1.setCheckIn(Booking1);

        Booking rese2= new Booking();
        rese2.setRoom(room2);
        //rese2.setCheckIn(Booking2);
        List<Booking> listBookings = new ArrayList<>();

        listBookings.add(rese1);
        listBookings.add(rese2);


    }
}


