package io.wakelesstuna.twiliomailsenderdemo.api;

import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;
import io.wakelesstuna.twiliomailsenderdemo.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MailResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sendCreateAccount() throws Exception {
      /*  AppUser user = new AppUser();
        user.setFirstname("user")
                .setLastname("root")
                .setMail("user@gmail.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/account/create", user))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.message").value(ResponseDto.class));*/
    }

    @Test
    void sendPasswordResetRequest() {
    }

    @Test
    void sendOrder() {
    }

    @Test
    void sendInfoChangeNotification() {
    }
}