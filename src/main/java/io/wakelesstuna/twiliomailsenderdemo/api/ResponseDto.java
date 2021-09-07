package io.wakelesstuna.twiliomailsenderdemo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    @JsonProperty("message")
    private String message;

}
