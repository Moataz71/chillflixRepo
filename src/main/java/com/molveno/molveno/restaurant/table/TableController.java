package com.molveno.molveno.restaurant.table;


import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TableController {


    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private GuestRepository guestRepository;

        @RequestMapping(value = "/catch", method = RequestMethod.GET)
        public List<Tablee> getAll() {
            return tableRepository.findAll();
        }


    }

