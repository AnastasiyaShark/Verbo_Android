package com.ashark.verbo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SigningRequest {

    String email;
    String password;

    public SigningRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
