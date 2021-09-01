package io.wakelesstuna.twiliomailsenderdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AppUser {
    private String mail;
    private String firstname;
    private String lastname;
}
