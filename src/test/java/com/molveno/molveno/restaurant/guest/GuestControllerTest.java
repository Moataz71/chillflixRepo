package com.molveno.molveno.restaurant.guest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GuestControllerTest {

    @InjectMocks
    private GuestController guestController;
    @Mock
    private GuestRepository guestRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
    }

    @Test
    public void guestcontroller ()throws Exception {
        Guest gus1 = new Guest();
        gus1.setName("Nina");
        gus1.setMobileNumber("0687443322");
        gus1.setEmail("nina@yahoo.com");
        gus1.setId(1);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(gus1);
        when(guestRepository.save(Mockito.any(Guest.class))).thenReturn(gus1);
        this.mockMvc.perform(post("/save-guest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id", is((int) gus1.getId())))
                .andExpect(jsonPath("$.name", is(gus1.getName())))
                .andExpect(jsonPath("$.mobileNumber", is(gus1.getMobileNumber())))
                .andExpect(jsonPath("$.email", is(gus1.getEmail())))
                .andExpect(status().isOk());
    }
}