package io.wakelesstuna.twiliomailsenderdemo.application;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;
import io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate.CreateAccountPayLoad;
import io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate.NewPasswordPayLoad;
import io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate.UpdateUserInformationPayLoad;
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
    @Value(value = "${create_account_id}")
    private String CREATE_ACCOUNT_TEMPLATE_ID;
    @Value(value = "${password_reset_template_id}")
    private String PASSWORD_RESET_TEMPLATE_ID;
    @Value(value = "${update_user_information_template_id}")
    private String UPDATE_USER_INFORMATION_TEMPLATE_ID;

    public void sendCreateAccountMail(AppUser appUser) {
        CreateAccountPayLoad payload = new CreateAccountPayLoad(appUser, CREATE_ACCOUNT_TEMPLATE_ID);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }
    
    public void sendNewPasswordMail(AppUser appUser) {
        NewPasswordPayLoad payload = new NewPasswordPayLoad(appUser, PASSWORD_RESET_TEMPLATE_ID);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }

    public void sendUpdateUserInfoMail(AppUser appUser) {
        UpdateUserInformationPayLoad payload = new UpdateUserInformationPayLoad(appUser, UPDATE_USER_INFORMATION_TEMPLATE_ID);
        throwErrorIfStatusCodeNotValid(sendMail(payload.getPayload()));
    }

    public Response sendMail(String payload) {
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
