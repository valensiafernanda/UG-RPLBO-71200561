package com.loginregister;

public class LoginException extends Throwable {
    public LoginException() {
        System.out.println("Username dan password invalid");
    }
}

