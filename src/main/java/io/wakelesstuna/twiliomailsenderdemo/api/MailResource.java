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

    @PostMapping("/send/create")
    public ResponseEntity<?> sendEmail(@RequestBody AppUser appUser) {
        mailService.sendCreateAccountMail(appUser);
        // TODO: 2021-09-01 send error msg if mail dident go thro
        final String msg = String.format("Mail sent to %s for creating account", appUser.getMail());
        log.info(msg);
        return ResponseEntity.ok(msg);
    }
}
