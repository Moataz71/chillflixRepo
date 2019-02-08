package com.molveno.molveno.restaurant.reservation;

import com.molveno.molveno.restaurant.guest.Guest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;
    @Mock
    private  ReservationRepository reservationRepository;

    private MockMvc mockMvc;
    @Before
    @Test
    public void reservationControllerTest() {
        Reservation res1 = new Reservation();
        Guest gus1 = new Guest();
        gus1.setName("Nina");
        gus1.setMobileNumber("0687443322");
        res1.setGuest(gus1);
        LocalDateTime l1 = LocalDateTime.of(2019,3,13,14,3,00,0);
        res1.setReservationTime(l1);
        res1.setNumberOfpoeple(4);

    }
}
