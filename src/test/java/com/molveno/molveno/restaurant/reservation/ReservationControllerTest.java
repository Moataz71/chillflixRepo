package com.molveno.molveno.restaurant.reservation;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;
    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private GuestRepository guestRepository;
    @Mock
    private TableRepository tableRepository;


    private MockMvc mockMvc;
@Test
    public  void gettingReservationAPItest(){
    Reservation reservation = new Reservation();
    reservation.setNumberOfpoeple(4);

    LocalDateTime a= LocalDateTime.of(2019,03,03,12,30,30,30);
    reservation.setNumberOfpoeple(4);
    reservation.setReservationTime(a);
    Guest guest = new Guest();
    guest.setName("Samer");
    guest.setMobileNumber("0932969327");
    guest.setEmail("Sam01715@hotmail.com");
    List<Tablee> tablees= new ArrayList<>();
    Tablee t = new Tablee();
    t.setNumberOfChairs(4);
    t.setNameoftable("table1");
    reservation.setTablees(tablees);
    reservation.setGuest(guest);












}

}
