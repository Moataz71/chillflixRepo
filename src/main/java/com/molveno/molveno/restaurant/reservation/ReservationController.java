package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


import static com.molveno.molveno.restaurant.reservation.ReservationLogic.getAvailableTables;

@RestController

public class ReservationController {


    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private GuestRepository guestRepository;


    @RequestMapping(value = "/get-reservation", method = RequestMethod.GET)
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value = "/save-reservation", method = RequestMethod.POST, consumes = "application/json")
    public void saveReservation(@RequestBody Reservation reservation) {


        reservationRepository.save(reservation);
    }

    @RequestMapping(value = "/delete-reservation", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteReservation(@RequestBody Reservation reservation) {
        reservationRepository.deleteById(reservation.getId());

    }




   /* @RequestMapping(value = "/get-time",method = RequestMethod.GET)
    public void getTime(@RequestParam String s){
        Reservation a = new Reservation();
        LocalDateTime dateTime=LocalDateTime.parse(s);
        a.setReservationTime(dateTime);
        reservationRepository.save(a);


    }
*/


/*
    @RequestMapping(value = "/compare-time", method = RequestMethod.POST, consumes = "application/json")
    public List<Tablee> checkAva(@RequestBody Reservation reservation) {

        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(), tableRepository.findAll(), reservationRepository.findAll());

        int x = 0;
        int i = reservation.getNumberOfpoeple();
        List<Tablee> s = new ArrayList<>();

        if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() == i) {
                    s.add(tablee);
                    reservation.setTablees(s);
                    break;
                } else if (tablee.getNumberOfChairs() > i) {
                    s.add(tablee);
                    reservation.setTablees(s);
                    break;
                } else {
                    s.add(tablee);
                    i = i - tablee.getNumberOfChairs();
                    continue;

                }

            }

        }

        if (tablees.isEmpty()) {
            return tablees;
        }
        for (Tablee tablee : s) {


            x = tablee.getNumberOfChairs() + x;
        }

        if (x <= reservation.getNumberOfpoeple()) {
            for (Tablee t : s) {
                s.remove(t);

            }


            return s;

        }

        return tablees;
    }

*/
@RequestMapping(value = "/compare-time", method = RequestMethod.GET)
public boolean checkAva(@RequestParam String localDateTime, int num) {


    LocalDateTime dateTime=LocalDateTime.parse(localDateTime);
    List<Tablee> tablees = getAvailableTables(dateTime, tableRepository.findAll(), reservationRepository.findAll());


    if (0 < tablees.size()) {
        for (Tablee tablee : tablees) {
            if (tablee.getNumberOfChairs() == num) {


                return true;
            } else if (tablee.getNumberOfChairs() > num) {


                return true;
            } else {

                num = num - tablee.getNumberOfChairs();
                continue;

            }

        }

    }
return false;
}










    @RequestMapping(value = "/test1", method = RequestMethod.POST, consumes = "application/json")
    public List<Tablee> test1(@RequestBody Reservation reservation) {
        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(), tableRepository.findAll(), reservationRepository.findAll());
                int x = 0;
        int i = reservation.getNumberOfpoeple();
        List<Tablee> s = new ArrayList<>();

        if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() == i) {
                    s.add(tablee);
                    reservation.setTablees(s);
                    reservation.setGuest(guestRepository.save(reservation.getGuest()));
                    reservationRepository.save(reservation);
                    break;
                } else if (tablee.getNumberOfChairs() > i) {
                    s.add(tablee);
                    reservation.setTablees(s);
                    reservation.setGuest(guestRepository.save(reservation.getGuest()));
                    reservationRepository.save(reservation);
                    break;
                } else {
                    s.add(tablee);
                    i = i - tablee.getNumberOfChairs();
                    continue;

                }

            }

        }




        return tablees;
    }


}

