package io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate;

import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;

import static io.wakelesstuna.twiliomailsenderdemo.TwilioMailSenderDemoApplication.dotenv;

public class UpdateUserInformationPayLoad {

    private final String payload;

    public UpdateUserInformationPayLoad(AppUser appUser) {
        String templateId = dotenv.get("update_userinformation_template_id");

        this.payload = "" +
                "{\n" +
                "   \"from\":{\n" +
                "      \"email\":\"hakimlivs@gmail.com\"\n" +
                "   },\n" +
                "   \"personalizations\":[\n" +
                "      {\n" +
                "         \"to\":[\n" +
                "            {\n" +
                "               \"email\":\"" + appUser.getMail() +"\"\n" +
                "            }\n" +
                "         ],\n" +
                "         \"dynamic_template_data\":{\n" +
                "             \"first_name\": \"" + appUser.getFirstname() + "\",\n" +
                "             \"last_name\": \"" + appUser.getLastname() +"\",\n" +
                "            \"address_line_1\":\"" + appUser.getAddress() + "\",\n" +
                "            \"postal_code\":\"" + appUser.getZip() + "\",\n" +
                "            \"city\":\"" + appUser.getCity() + "\",\n" +
                "            \"phone_number\":\"" + appUser.getPhonenumber() + "\",\n" +
                "            \"Sender_Name\":\"Hakim Livs\",\n" +
                "            \"address_line_1\":\"Tomtebodavägen 3A\",\n" +
                "            \"city\":\"Solna\",\n" +
                "            \"postal_code\":\"171 65\"\n" +
                "          }\n" +
                "      }\n" +
                "   ],\n" +
                "   \"template_id\":\"" + templateId +"\"\n" +
                "}";
    }

    public String getPayload() {
        return payload;
    }
}