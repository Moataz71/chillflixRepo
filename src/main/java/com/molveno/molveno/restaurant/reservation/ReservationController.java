package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.molveno.molveno.restaurant.reservation.ReservationLogic.doReserve;
import static com.molveno.molveno.restaurant.reservation.ReservationLogic.getAvailableTables;

@RestController

public class ReservationController {


    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepository tableRepository;


    @RequestMapping(value = "/get-reservation", method = RequestMethod.GET)
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value = "/save-reservation", method = RequestMethod.POST , consumes="application/json")
    public void saveReservation(@RequestBody Reservation reservation) {





        reservationRepository.save(reservation);
    }

    @RequestMapping(value = "/delete-reservation", method = RequestMethod.DELETE , consumes="application/json")
    public void deleteReservation(@RequestBody Reservation reservation){
        reservationRepository.deleteById(reservation.getId());

    }
@RequestMapping(value = "/compare-time",method =RequestMethod.POST,consumes = "application/json")
    public List<Tablee> checkAva(@RequestBody Reservation reservation){

List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(),tableRepository.findAll(),reservationRepository.findAll());
int i=0;
if(tablees!=null&i<tablees.size()) {
    reservation.setTablee(tablees.get(i));
    reservationRepository.save(reservation);
}

return tablees;
}
    @RequestMapping(value = "/do-reserve",method =RequestMethod.POST,consumes = "application/json")
    public List<Tablee> reserve(@RequestBody Reservation reservation){

        List<Tablee> tablees = getAvailableTables(reservation.getReservationTime(),tableRepository.findAll(),reservationRepository.findAll());

        if(tablees!=null) {
            reservation.setTablee(tablees.get(0));
reservationRepository.save(reservation);
        }

        return tablees;
    }


}

