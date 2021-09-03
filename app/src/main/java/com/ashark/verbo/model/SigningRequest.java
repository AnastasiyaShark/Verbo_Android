package com.ashark.verbo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SigningRequest {

    String login;
    String password;

    public SigningRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
