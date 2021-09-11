package com.ashark.verbo.model;


public class SignupRequest {
    Integer id;
    String name;
    String password;
    String email;
    Integer nativeLanguageId;
    Integer learningLanguage1Id;


    public SignupRequest(Integer id, String name, String password, String email, Integer nativeLanguageId, Integer learningLanguage1Id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.nativeLanguageId = nativeLanguageId;
        this.learningLanguage1Id = learningLanguage1Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNativeLanguageId(Integer nativeLanguageId) {
        this.nativeLanguageId = nativeLanguageId;
    }

    public void setLearningLanguage1Id(Integer learningLanguage1Id) {
        this.learningLanguage1Id = learningLanguage1Id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNativeLanguageId() {
        return nativeLanguageId;
    }

    public Integer getLearningLanguage1Id() {
        return learningLanguage1Id;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nativeLanguageId=" + nativeLanguageId +
                ", learningLanguage1Id=" + learningLanguage1Id +
                '}';
    }
}
