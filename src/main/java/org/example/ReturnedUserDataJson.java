package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnedUserDataJson {

    private String success;
    private User user;
    private String accessToken;
    private String refreshToken;
}
