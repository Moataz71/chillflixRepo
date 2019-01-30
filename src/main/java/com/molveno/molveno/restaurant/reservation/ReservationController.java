package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
    @RequestMapping(value = "/compare-time", method = RequestMethod.POST, consumes = "application/json")
    public List<Tablee> checkAva(@RequestBody Reservation reservation) {

        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(), tableRepository.findAll(), reservationRepository.findAll());

//if(tablees!=null&i<tablees.size()) {
        //  reservation.setTablee(tablees.get(i));
//}
        if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() >= reservation.getNumberOfpoeple()) {
                    reservation.setTablee(tablee);
                    break;
                }
            }
        }


        return tablees;
    }




    @RequestMapping(value = "/test1", method = RequestMethod.POST, consumes = "application/json")
    public List<Tablee> test1(@RequestBody Reservation reservation) {
        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(), tableRepository.findAll(), reservationRepository.findAll());
        // int i = 0;
        //if (tablees != null & i < tablees.size()) {
        //  reservation.setTablee(tablees.get(i));
        //reservationRepository.save(reservation);
        //}

        if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() >= reservation.getNumberOfpoeple()) {
                    reservation.setTablee(tablee);
                    break;
                }


            }
            reservation.setGuest(guestRepository.save(reservation.getGuest()));
            reservationRepository.save(reservation);
        }






        return tablees;
    }






*/

    @RequestMapping(value = "/compare-time", method = RequestMethod.POST, consumes = "application/json")
    public List<Tablee> checkAva(@RequestBody Reservation reservation) {

        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(), tableRepository.findAll(), reservationRepository.findAll());

//if(tablees!=null&i<tablees.size()) {
        //  reservation.setTablee(tablees.get(i));
//}
      if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() >= reservation.getNumberOfpoeple()) {
                    List<Tablee> s = new ArrayList<>();
                    s.add(tablee);
                    reservation.setTablees(s);
                    break;
                }
            }
        }


        return tablees;
    }




    @RequestMapping(value = "/test1", method = RequestMethod.POST, consumes = "application/json")
    public List<Tablee> test1(@RequestBody Reservation reservation) {
        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(), tableRepository.findAll(), reservationRepository.findAll());
        // int i = 0;
        //if (tablees != null & i < tablees.size()) {
        //  reservation.setTablee(tablees.get(i));
        //reservationRepository.save(reservation);
        //}
        int x=0;
        int i=reservation.getNumberOfpoeple();
 List<Tablee> s= new ArrayList<>();

        if (0 < tablees.size()) {
            for (Tablee tablee : tablees) {
                if (tablee.getNumberOfChairs() == i) {
                    s.add(tablee);
                    reservation.setTablees(s);
                    reservation.setGuest(guestRepository.save(reservation.getGuest()));
                    reservationRepository.save(reservation);
                    break;
                }
                else if (tablee.getNumberOfChairs() > i) {
                    s.add(tablee);
                    reservation.setTablees(s);
                    reservation.setGuest(guestRepository.save(reservation.getGuest()));
                    reservationRepository.save(reservation);
                    break;
                }
               else {
                   s.add(tablee);
                   i=i-tablee.getNumberOfChairs();
                   continue;

                }

            }

        }


for(Tablee tablee:s){


    x=tablee.getNumberOfChairs()+x;
}

if(x<=reservation.getNumberOfpoeple()) {
    for (Tablee t : s) {
        s.remove(t);

    }
    if(tablees.isEmpty()&s.isEmpty()){

        return s;
    }
}

        return tablees;
    }









}

