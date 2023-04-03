package com.example.project.Model;

public class BankModel {
    private int id;
    String name,email,phoneno,pin,balance;

    public BankModel(String name, String email, String phoneno, String pin, String balance) {
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}