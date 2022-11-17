package com.loginregister;

public class PasswordException extends Throwable {
    private int code;

    public PasswordException(int code) {
        this.code = code;
        if (code == 1) {
            System.out.println("Maaf, password minimal 7 karakter!");
        } else if (code == 2) {
            System.out.println("Maaf, password tidak boleh sama dengan username");
        } else if (code == 3) {
            System.out.println("Maaf, password harus mengandung huruf besar, huruf kecil, simbol, dan angka!");
        }
    }

    public int getCode() {
        return code;
    }
}

