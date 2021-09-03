package io.wakelesstuna.twiliomailsenderdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private String firstname;
    private String lastname;
    private String mail;
    private String address;
    private String zip;
    private String city;
    private String phoneNumber;

    private String dateOfOrder;
    private long orderNumber;
    private String orderTotal;
    private List<LineItem> lineItem;

}
