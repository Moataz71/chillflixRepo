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





    @RequestMapping(value = "/test12", method = RequestMethod.GET)
    public List<Tablee> test2(@RequestParam String reservationTime, int num) {
        LocalDateTime dateTime=LocalDateTime.parse(reservationTime);
    List<Tablee> tablees = getAvailableTables(dateTime, tableRepository.findAll(), reservationRepository.findAll());

        int x = 0;
        int i = num;
        List<Tablee> s = new ArrayList<>();

        if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() == i) {
                    s.add(tablee);
                    return  s;

                } else if (tablee.getNumberOfChairs() > i) {
                    s.add(tablee);
                   return s;

                } else {
                    s.add(tablee);
                    i = i - tablee.getNumberOfChairs();
                    continue;

                }

            }

        }




        return s;
    }



}

