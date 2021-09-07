package io.wakelesstuna.twiliomailsenderdemo.application;

import com.sendgrid.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MailServiceTest {

    @Mock
    MailService mailService;

    @BeforeEach
    void init() {
        mailService = new MailService();
    }

    @Test
    void throwErrorIfStatusCodeNotValidThrowErrorTest() {
        Response response = new Response();
        response.setStatusCode(404);

        assertThrows(InternalError.class, () -> mailService.throwErrorIfStatusCodeNotValid(response));
    }

    @Test
    void throwErrorIfStatusCodeNotValidDoesNotThrowErrorTest() {
        Response response = new Response();
        response.setStatusCode(202);

        assertDoesNotThrow(() -> mailService.throwErrorIfStatusCodeNotValid(response));
    }

    /*@Test
    void postTest() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8082/user/signup",
                new SignUpDto("user", "pass", List.of("ADMIN")), String.class);

        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());


    }

    @AllArgsConstructor
    @Data
    static class SignUpDto {
        @JsonProperty("username")
        private String username;
        @JsonProperty("password")
        private String password;
        @JsonProperty("roles")
        private List<String> roles;
    }
*/


    /*@Test
    void riskApiTest() {
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dto> response = restTemplate.getForEntity("http://localhost:8082/risk/username", Dto.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());


    }


    static class Dto {
        boolean pass;

        @JsonCreator
        public Dto(@JsonProperty("pass") boolean pass) {
            this.pass = pass;
        }

        public boolean isPass() {
            return pass;
        }

        public void setPass(boolean pass) {
            this.pass = pass;
        }

        @Override
        public String toString() {
            return "Dto{" +
                    "pass=" + pass +
                    '}';
        }
    }*/
}