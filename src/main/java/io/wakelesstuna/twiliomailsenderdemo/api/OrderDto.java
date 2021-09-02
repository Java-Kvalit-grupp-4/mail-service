package io.wakelesstuna.twiliomailsenderdemo.api;

import io.wakelesstuna.twiliomailsenderdemo.domain.LineItem.LineItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class OrderDto {

    private String firstname;
    private String lastname;
    private String mail;
    private String address;
    private String zip;
    private String city;
    private String phoneNumber;

    private LocalDate dateOfOrder;
    private long orderNumber;
    private List<LineItem> lineItem;

}
