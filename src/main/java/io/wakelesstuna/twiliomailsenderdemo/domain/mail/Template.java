package io.wakelesstuna.twiliomailsenderdemo.domain.mail;

import com.sendgrid.helpers.mail.objects.Personalization;
import io.wakelesstuna.twiliomailsenderdemo.domain.Order;
import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;

public class Template {

    /**
     * Setting the variables to use for sending information to twilio about
     * the content in the email to send. The key must match the create account template
     * key on twilio to work
     * @param user AppUser object to send the email to
     * @return Personalization object with all the variables used in the template
     */
    public static Personalization getCreateAccountPersonalization(AppUser user) {
        Personalization personalization = new Personalization();
        personalization.addDynamicTemplateData("user_firstname", user.getFirstname());
        personalization.addDynamicTemplateData("user_lastname", user.getLastname());
        getAdminData(personalization);
        return personalization;
    }

    /**
     * Setting the variables to use for sending information to twilio about
     * the content in the email to send. The key must match the update user information template
     * key on twilio to work
     * @param user AppUser object to send the email to
     * @return Personalization object with all the variables used in the template
     */
    public static Personalization getUpdateUserInformationPersonalization(AppUser user) {
        Personalization personalization = new Personalization();
        personalization.addDynamicTemplateData("user_firstname", user.getFirstname());
        personalization.addDynamicTemplateData("user_lastname", user.getLastname());
        personalization.addDynamicTemplateData("user_phone_number", user.getPhonenumber());
        personalization.addDynamicTemplateData("user_address", user.getAddress());
        personalization.addDynamicTemplateData("user_zipcode", user.getZip());
        personalization.addDynamicTemplateData("user_city", user.getCity());
        getAdminData(personalization);
        return personalization;
    }

    /**
     * Setting the variables to use for sending information to twilio about
     * the content in the email to send. The key must match the new password template
     * key on twilio to work
     * @param user AppUser object to send the email to
     * @return Personalization object with all the variables used in the template
     */
    public static Personalization getNewPasswordPersonalization(AppUser user) {
        Personalization personalization = new Personalization();
        personalization.addDynamicTemplateData("user_firstname", user.getFirstname());
        personalization.addDynamicTemplateData("user_lastname", user.getLastname());
        personalization.addDynamicTemplateData("user_password", user.getPassword());
        getAdminData(personalization);
        return personalization;
    }

    /**
     * Setting the variables to use for sending information to twilio about
     * the content in the email to send. The key must match the new password template
     * key on twilio to work
     * @param order AppUser object to send the email to
     * @return Personalization object with all the variables used in the template
     */
    public static Personalization getConfirmationOrderPersonalization(Order order) {
        Personalization personalization = new Personalization();
        personalization.addDynamicTemplateData("user_firstname", order.getFirstname());
        personalization.addDynamicTemplateData("user_lastname", order.getLastname());
        personalization.addDynamicTemplateData("user_email", order.getMail());
        personalization.addDynamicTemplateData("user_phone_number", order.getPhoneNumber());
        personalization.addDynamicTemplateData("user_address", order.getAddress());
        personalization.addDynamicTemplateData("user_zipcode", order.getZip());
        personalization.addDynamicTemplateData("user_city", order.getCity());
        personalization.addDynamicTemplateData("order_number", order.getOrderNumber());
        personalization.addDynamicTemplateData("date_of_order", order.getDateOfOrder());
        personalization.addDynamicTemplateData("order_total", order.getOrderTotal());
        personalization.addDynamicTemplateData("line_item", order.getLineItem());

        getAdminData(personalization);
        return personalization;
    }

    /**
     * Setting the admin variables to use in mails, keys must match
     * keys on twilio to work
     */
    private static void getAdminData(Personalization personalization) {
        personalization.addDynamicTemplateData("address", "Tomtebodavägen 3A");
        personalization.addDynamicTemplateData("city", "Solna");
        personalization.addDynamicTemplateData("zipcode", "171 65");
    }
}
