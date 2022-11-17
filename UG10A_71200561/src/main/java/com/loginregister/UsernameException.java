package com.loginregister;

public class UsernameException extends Throwable {
    public UsernameException() {
        System.out.println("Maaf, username minimal harus terdiri dari 6 karakter");
    }
}

