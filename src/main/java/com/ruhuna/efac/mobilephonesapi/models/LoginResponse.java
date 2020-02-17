package com.ruhuna.efac.mobilephonesapi.models;

public class LoginResponse {
    String status;

    public LoginResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
