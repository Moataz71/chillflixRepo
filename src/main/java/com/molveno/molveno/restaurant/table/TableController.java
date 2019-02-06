package com.molveno.molveno.restaurant.table;


import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TableController {



    @Autowired
    private TableRepository tableRepository;


        @RequestMapping(value = "/catch", method = RequestMethod.GET)
        public List<Tablee> getAll() {
            return tableRepository.findAll();
        }
        @RequestMapping(value = "/delete-table",method = RequestMethod.DELETE)
    public void deleteTable(@RequestBody Tablee tablee){
            tableRepository.deleteById(tablee.getId());


        }

    @RequestMapping(value = "/add-table", method = RequestMethod.POST,consumes = "application/json")
    public void addTable(@RequestBody Tablee table) {
        tableRepository.save(table);
    }
    @RequestMapping(value = "/edit-table", method = RequestMethod.POST,consumes = "application/json")
    public void editTable(@RequestBody Tablee table) {
        Tablee p = tableRepository.findById(table.getId());
      //  p.setNameoftable(table.getNameoftable());
        p.setNumberofchairs(table.getNumberofchairs());
        tableRepository.save(p);
    }


    }

