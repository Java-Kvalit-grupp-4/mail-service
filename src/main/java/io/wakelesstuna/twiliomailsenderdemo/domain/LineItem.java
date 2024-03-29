package io.wakelesstuna.twiliomailsenderdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {
    private String productName;
    private int quantity;
    private double productPrice;
    private double totalPrice;

}
