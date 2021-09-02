package io.wakelesstuna.twiliomailsenderdemo.domain.mailTemplate;

import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;

public class NewPasswordPayLoad {

    private final String payload;

    public NewPasswordPayLoad(AppUser appUser, String templateId) {

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
                "            \"password\":\"" + appUser.getPassword() + "\",\n" +
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
