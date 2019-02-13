package com.molveno.molveno.restaurant.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;
    @Mock
    private  ReservationRepository reservationRepository;
    private TableRepository tableRepository;
    private GuestRepository guestRepository;

    private MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Test
    public void reservationControllerTest() throws Exception {
        Reservation res1 = new Reservation();
        Guest gus1 = new Guest();
        Tablee t1 = new Tablee();
        t1.setNumberOfChairs(4);
        t1.setNameoftable("table1");
        t1.setId(1);
        List<Tablee> x = new ArrayList<>();
        x.add(t1);
        gus1.setName("Nina");
        gus1.setId(1);
        gus1.setMobileNumber("0687443322");
        res1.setGuest(gus1);
        res1.setTablees(x);
        LocalDateTime l1 = LocalDateTime.of(2019,3,13,14,3,00,0);
       // res1.setReservationTime(l1);
        res1.setNumberOfpoeple(4);
        res1.setId(7);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(res1);
        when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(res1);
        this.mockMvc.perform(post("/save-reservation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id", is((int) res1.getId())))
                .andExpect(jsonPath("$.numberOfpoeple", is(res1.getNumberOfpoeple())))
                .andExpect(jsonPath("$.guest.id", is((int) res1.getGuest().getId())))
               // .andExpect(jsonPath("$.tablees.id", is(res1.getTablees().get(0).getId())))
             //   .andExpect(jsonPath("$.reservationtime", is(res1.getReservationTime())))

                .andExpect(status().isOk());


    }
}
