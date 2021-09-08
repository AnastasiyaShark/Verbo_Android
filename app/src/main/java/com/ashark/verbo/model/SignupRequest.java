package com.ashark.verbo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SignupRequest {
    String name;
    String password;
    String email;
    String nativeLanguage;
    String learningLanguage1;

    public SignupRequest(String name, String password, String email, String nativeLanguage, String learningLanguage1) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.nativeLanguage = nativeLanguage;
        this.learningLanguage1 = learningLanguage1;
    }
}
