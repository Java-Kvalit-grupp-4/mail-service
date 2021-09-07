package io.wakelesstuna.twiliomailsenderdemo.domain.mail;

import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;
import io.wakelesstuna.twiliomailsenderdemo.domain.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayloadTest {

    Payload payload;

    @Test
    void createPayloadWithUser() {
        String expected = "from";

        payload = new Payload("from", "subject", "1234", new AppUser(), TemplateId.CREATE_ACCOUNT);
        String actual = payload.getPayload().getFrom().getEmail();

        assertEquals(expected, actual);
    }

    @Test
    void getPayloadCREATE_ACCOUNTTest() {
        payload = new Payload("from", "subject", "1234", new AppUser(), TemplateId.CREATE_ACCOUNT);
        assertDoesNotThrow(() -> payload.getPayload());
    }

    @Test
    void getPayloadNEW_PASSWORDTest() {
        payload = new Payload("from", "subject", "1234", new AppUser(), TemplateId.NEW_PASSWORD);
        assertDoesNotThrow(() -> payload.getPayload());
    }

    @Test
    void getPayloadUPDATE_USER_INFORMATIONTest() {
        payload = new Payload("from", "subject", "1234", new AppUser(), TemplateId.UPDATE_USER_INFORMATION);
        assertDoesNotThrow(() -> payload.getPayload());
    }

    @Test
    void getPayloadORDER_CONFIRMATIONTest() {
        Order order = new Order();
        AppUser user = new AppUser();
        user.setOrder(order);
        user.setMail("mail");
        payload = new Payload("from", "subject", "1234", user, TemplateId.ORDER_CONFIRMATION);
        assertDoesNotThrow(() -> payload.getPayload());
    }


}