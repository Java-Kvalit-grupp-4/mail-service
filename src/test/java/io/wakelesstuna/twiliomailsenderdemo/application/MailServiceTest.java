package io.wakelesstuna.twiliomailsenderdemo.application;

import com.sendgrid.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceTest {

    @Mock
    MailService mailService;

    @BeforeEach
    void init() {
        mailService = new MailService();
    }

    @Test
    void throwErrorIfStatusCodeNotValidThrowErrorTest() {
        Response response = new Response();
        response.setStatusCode(404);

        assertThrows(InternalError.class, () -> mailService.throwErrorIfStatusCodeNotValid(response));
    }

    @Test
    void throwErrorIfStatusCodeNotValidDoesNotThrowErrorTest() {
        Response response = new Response();
        response.setStatusCode(202);

        assertDoesNotThrow(() -> mailService.throwErrorIfStatusCodeNotValid(response));
    }
}