package com.ug11.instapost;

public class InstaPost {
    private int totalMention;
    private String email;
    private String username;

    public InstaPost(){}

    public void printInfo(){
        System.out.println("Username: "+this.username);
        System.out.println("Email: "+this.email);
        System.out.println("Total Mention: "+this.totalMention);
    }

    public void login (String email) throws EmailException {
        try {
            if (!(email.contains("@"))) {
                throw new EmailException(1);
            } else if (!(email.contains("@gmail.com"))) {
                throw new EmailException(2);
            } else {
                this.email = email;
                String[] bagi = email.split("@");
                this.username = bagi[0].toUpperCase();
                System.out.println("Login berhasil!");
            }
        } catch (EmailException e) {
            System.out.println("Error : " + e.getErrorMessage());
        }
    }

    public void post (String string) {
        System.out.println("Caption: " + string);
        String[] bagi = string.split(" ");
        if(string.contains("@")) {
            String sum = "";
            for (int i = 0; i < bagi.length; i++) {
                String c = bagi[i];
                if (c.contains("@")) {
                    sum += c + ", ";
                }
            }
            System.out.println("Pengguna yang Anda mention: " + sum);
        } else {
            System.out.println("Pengguna yang Anda mention: -");
        }
        int summ = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '@') {
                summ += 1;
                this.totalMention += 1;
            }
        }
        System.out.println("Total username yang anda mention: "+summ);
    }
}
