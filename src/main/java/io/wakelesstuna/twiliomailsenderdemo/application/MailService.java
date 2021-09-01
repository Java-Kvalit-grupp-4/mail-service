package io.wakelesstuna.twiliomailsenderdemo.application;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;
import io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate.CreateAccountPayLoad;
import io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate.NewPasswordPayLoad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@ComponentScan
public class MailService {

    @Value(value = "${twilio.api-key}")
    private String apiKey;

    public void sendCreateAccountMail(AppUser appUser) {
        CreateAccountPayLoad payload = new CreateAccountPayLoad(appUser);
        sendMail(payload.getPayload());
    }
    
    public void sendNewPasswordMail(AppUser appUser) {
        NewPasswordPayLoad payload = new NewPasswordPayLoad(appUser);
        sendMail(payload.getPayload());
    }

    public void sendMail(String payload) {
        try {
            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(payload);
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw new ResponseStatusException(BAD_REQUEST, ex.getMessage());
        }
    }
}
