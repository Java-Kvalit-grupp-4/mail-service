package io.wakelesstuna.twiliomailsenderdemo;

import io.wakelesstuna.twiliomailsenderdemo.application.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value(value = "${spring.sendgrid.sender-email}")
    private String senderEmail;
    @Value(value = "${spring.sendgrid.api-key}")
    private String apiKey;
    @Value(value = "${spring.sendgrid.create-account-template-id}")
    private String CREATE_ACCOUNT_TEMPLATE_ID;
    @Value(value = "${spring.sendgrid.password-reset-template-id}")
    private String PASSWORD_RESET_TEMPLATE_ID;
    @Value(value = "${spring.sendgrid.update-user-information-template-id}")
    private String UPDATE_USER_INFORMATION_TEMPLATE_ID;
    @Value(value = "${spring.sendgrid.order-confirm-template-id}")
    private String ORDER_CONFIRMATION_TEMPLATE_ID;

    @Bean
    public MailService mailService() {
        return new MailService(senderEmail,apiKey,CREATE_ACCOUNT_TEMPLATE_ID, PASSWORD_RESET_TEMPLATE_ID, UPDATE_USER_INFORMATION_TEMPLATE_ID, ORDER_CONFIRMATION_TEMPLATE_ID);
    }

}
