package io.wakelesstuna.twiliomailsenderdemo.api;

import io.wakelesstuna.twiliomailsenderdemo.application.MailService;
import io.wakelesstuna.twiliomailsenderdemo.domain.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/mail")
@RequiredArgsConstructor
@Slf4j
public class MailResource {

    private final MailService mailService;

    @PostMapping("/account/create")
    public ResponseEntity<?> sendCreateAccount(@RequestBody AppUser appUser) {
        mailService.sendCreateAccountMail(appUser);
        // TODO: 2021-09-01 send error msg if mail dident go thro
        final String msg = String.format("Mail sent to %s for creating account", appUser.getMail());
        log.info(msg);
        return ResponseEntity.ok(msg);
    }
    
    @PostMapping("/account/password_reset_request")
    public ResponseEntity<?> sendPasswordResetRequest(@RequestBody AppUser appUser) {
        mailService.sendNewPasswordMail(appUser);
        // TODO: 2021-09-01 send error msg if mail dident go thro
        final String msg = String.format("Reset link sent for account %s", appUser.getMail());
        log.info(msg);
        return ResponseEntity.ok(msg);
    }
    
    @PostMapping("/order")
    public ResponseEntity<?> sendOrder(@RequestBody AppUser appUser) {
        mailService.sendCreateAccountMail(appUser);
        // TODO: 2021-09-01 send error msg if mail dident go thro
        final String msg = String.format("Order details sent for account %s", appUser.getMail());
        log.info(msg);
        return ResponseEntity.ok(msg);
    }
    
    @PostMapping("/info/change")
    public ResponseEntity<?> sendInfoChangeNotification(@RequestBody AppUser appUser) {
        mailService.sendCreateAccountMail(appUser);
        // TODO: 2021-09-01 send error msg if mail dident go thro
        final String msg = String.format("Change notification sent for account %s", appUser.getMail());
        log.info(msg);
        return ResponseEntity.ok(msg);
    }
}
