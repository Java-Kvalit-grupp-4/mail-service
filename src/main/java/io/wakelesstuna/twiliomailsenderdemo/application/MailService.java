package io.wakelesstuna.twiliomailsenderdemo.application;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;
import io.wakelesstuna.twiliomailsenderdemo.domain.Order;
import io.wakelesstuna.twiliomailsenderdemo.domain.mail.Payload;
import io.wakelesstuna.twiliomailsenderdemo.domain.mail.TemplateId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
public class MailService {

    //@Value(value = "${sender_email}")
    private String senderEmail;
    //@Value(value = "${twilio_api_key}")
    private String apiKey;
    //@Value(value = "${create_account_template_id}")
    private String CREATE_ACCOUNT_TEMPLATE_ID;
    //@Value(value = "${password_reset_template_id}")
    private String PASSWORD_RESET_TEMPLATE_ID;
    //@Value(value = "${update_user_information_template_id}")
    private String UPDATE_USER_INFORMATION_TEMPLATE_ID;
    //@Value(value = "${order_confirm_template_id}")
    private String ORDER_CONFIRMATION_TEMPLATE_ID;


    public MailService(String senderEmail, String apiKey, String CREATE_ACCOUNT_TEMPLATE_ID, String PASSWORD_RESET_TEMPLATE_ID, String UPDATE_USER_INFORMATION_TEMPLATE_ID, String ORDER_CONFIRMATION_TEMPLATE_ID) {
        this.senderEmail = senderEmail;
        this.apiKey = apiKey;
        this.CREATE_ACCOUNT_TEMPLATE_ID = CREATE_ACCOUNT_TEMPLATE_ID;
        this.PASSWORD_RESET_TEMPLATE_ID = PASSWORD_RESET_TEMPLATE_ID;
        this.UPDATE_USER_INFORMATION_TEMPLATE_ID = UPDATE_USER_INFORMATION_TEMPLATE_ID;
        this.ORDER_CONFIRMATION_TEMPLATE_ID = ORDER_CONFIRMATION_TEMPLATE_ID;
    }

    /**
     * Sends and email to a user that created an account
     * @param appUser AppUser object who to send email to
     */
    public void sendCreateAccountMail(AppUser appUser) {
        Payload payload = new Payload(senderEmail, "Account Created", CREATE_ACCOUNT_TEMPLATE_ID, appUser, TemplateId.CREATE_ACCOUNT);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }


    public void sendOrderConfirmMail(Order order) {
        AppUser user = new AppUser();
        user.setOrder(order);
        user.setMail(order.getMail());
        Payload payload = new Payload(senderEmail, "Order Confirmation", ORDER_CONFIRMATION_TEMPLATE_ID, user, TemplateId.ORDER_CONFIRMATION);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }

    /**
     * Sends and email to the user who requested a new password
     * @param appUser AppUser object who to send email to
     */
    public void sendNewPasswordMail(AppUser appUser) {
        Payload payload = new Payload(senderEmail, "Account Created", PASSWORD_RESET_TEMPLATE_ID, appUser, TemplateId.NEW_PASSWORD);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }

    /**
     * Sends an email to a user when the user update his information
     * @param appUser AppUser object who to send email to
     */
    public void sendUpdateUserInfoMail(AppUser appUser) {
        Payload payload = new Payload(senderEmail, "Account Created", UPDATE_USER_INFORMATION_TEMPLATE_ID, appUser, TemplateId.UPDATE_USER_INFORMATION);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }

    /**
     * Sends and api request to Twilio api
     * @param payload Mail object to send to Twilio
     * @return Response from Twilio api
     */
    public Response sendMail(Mail payload) {
        try {
            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(payload.build());
            System.out.println(payload.build());
            Response response = sg.api(request);
            log.info("status code: {}", response.getStatusCode());
            return response;
        } catch (IOException ex) {
            throw new ResponseStatusException(BAD_REQUEST, ex.getMessage());
        }
    }

    /**
     * Check if the status code from the request starts with 2
     * @param response the response to check the status code of
     * @throws InternalError if status code does not start with 2
     */
    public void throwErrorIfStatusCodeNotValid(Response response) {
        char c = String.valueOf(response.getStatusCode()).charAt(0);
        if (c != '2') throw new InternalError("could not send email");
    }
}
