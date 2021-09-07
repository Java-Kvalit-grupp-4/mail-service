package io.wakelesstuna.twiliomailsenderdemo.domain.mail;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;

/**
 * Creates a Payload for an email for Twilio templates
 */
public class Payload {

    private final Mail mail;

    public Payload(String from,String subject, String templateId, AppUser user, TemplateId templateEnum) {
        mail = new Mail();
        // select with personalization we wanna use
        Personalization personalization = new Personalization();
        switch (templateEnum) {
            case CREATE_ACCOUNT: personalization  = Template.getCreateAccountPersonalization(user); break;
            case NEW_PASSWORD: personalization = Template.getNewPasswordPersonalization(user); break;
            case UPDATE_USER_INFORMATION: personalization =  Template.getUpdateUserInformationPersonalization(user); break;
            case ORDER_CONFIRMATION: personalization =  Template.getConfirmationOrderPersonalization(user.getOrder()); break;
        }
        // Add who you wanna send the email to
        personalization.addTo(new Email(user.getMail()));
        // set who the sender is
        mail.setFrom(new Email(from));
        // set the subject line of the email
        mail.setSubject(subject);
        // add personal variables that match the template on twilio
        mail.addPersonalization(personalization);
        // the id for the template
        mail.setTemplateId(templateId);
    }

    public Mail getPayload() {
        return this.mail;
    }
}
