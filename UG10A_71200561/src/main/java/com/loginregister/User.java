package com.loginregister;

import java.util.Scanner;

public class User {
    private String username = "";
    private String email = "";
    private String password = "";

    public boolean cekSymbol (String s) {
        return (s == null) ? false : s.matches("[^A-Za-z0-9 ]");
    }

    public User (String username, String email, String password) throws LoginException, UsernameException, EmailException, PasswordException {
        this.username = username;
        this.email = email;
        this.password = password;
        boolean flag = true;

        if (username.isEmpty() && username.length() < 6) {
            flag = false;
            throw new UsernameException();
        } else if (email.isEmpty() && email.contains("@ukdw.com")) {
            flag = false;
            throw new EmailException();
        } else if (username.isEmpty() && password.isEmpty()) {
            flag = false;
            throw new LoginException();
        } else if (password.isEmpty()) {
            if (password.length() < 7) {
                flag = false;
                throw new PasswordException(1);
            } else if (password.equals(username)) {
                flag = false;
                throw new PasswordException(2);
            } else {
                boolean flagLower = false;
                boolean flagUpper = false;
                boolean flagNum = false;
                boolean flagSym = false;
                for (int i = 0; i < password.length(); i++) {
                    char cha = password.charAt(i);
                    if (Character.isLetter(cha) && Character.isLowerCase(cha)) {
                        flagLower = true;
                    }
                    if (Character.isLetter(cha) && Character.isUpperCase(cha)) {
                        flagUpper = true;
                    }
                    if (Character.isDigit(cha)) {
                        flagNum = true;
                    }
                }
                if (cekSymbol(password) == false) {
                    flagSym = true;
                }
                if (!(flagLower && flagUpper && flagSym && flagSym)) {
                    throw new PasswordException(3);
                }
            }
        }
    }

    public static void main(String[] args) throws UsernameException, EmailException, LoginException, PasswordException {
        System.out.println("Selamat datang di Toko Valen");
        System.out.println("Silahkan daftarkan diri kamu untuk dapat mengakses menu di Toko Valen");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        try {
            String u = "";
            String e = "";
            String p = "";
            System.out.print("Username: ");
            u = sc.nextLine();
            System.out.print("Email: ");
            e = sc.nextLine();
            System.out.print("Password: ");
            p = sc.nextLine();
            System.out.print("Konfirmasi password: ");
            String cp = sc.nextLine();
            User use = new User(u,e,p);
        } catch (PasswordException e) {
            throw new PasswordException(e.getCode());
        } catch (UsernameException e) {
            throw new UsernameException();
        } catch (EmailException e) {
            throw new EmailException();
        } catch (LoginException e) {
            throw new LoginException();
        } finally {
            System.out.println("Akun kamu berhasil didaftarkan!");
            System.out.println("Silahkan login untuk melanjutkan.");
        }

        System.out.println("Akun kamu berhasil didaftarkan!");
        System.out.println("Silakan login untuk melanjutkan");
        String u = "";
        String e = "";
        String p = "";
        try {
            System.out.print("Username: ");
            u = sc.nextLine();
            System.out.print("Email: ");
            e = sc.nextLine();
            System.out.print("Password: ");
            p = sc.nextLine();
            System.out.print("Konfirmasi password: ");
            String cp = sc.nextLine();
            User use = new User(u,e,p);
        } catch (PasswordException exc) {
            throw new PasswordException(exc.getCode());
        } catch (UsernameException exc) {
            throw new UsernameException();
        } catch (EmailException exc) {
            throw new EmailException();
        } catch (LoginException exc) {
            throw new LoginException();
        } finally {
            System.out.println("Selamat datang, " + u);
        }
    }
}

