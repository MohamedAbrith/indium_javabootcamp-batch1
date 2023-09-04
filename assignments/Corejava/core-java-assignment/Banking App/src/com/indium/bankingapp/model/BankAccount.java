package com.indium.bankingapp.model;

public class BankAccount {
    private int id;
    private String name;
    private double balance;
    private String type;
    public BankAccount(int id, String name, double balance, String type) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}

