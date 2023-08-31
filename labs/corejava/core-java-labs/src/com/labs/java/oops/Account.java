package com.labs.java.oops;

public class Account {


    int id;
    String name;
    String type;

    double balance;
    boolean active;

    public Account(){
        System.out.println("Default Constructor");
    }

    public Account(int id , String name ,String type, double balance, boolean active) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.active = active;
    }



        void openaccount(){
        System.out.println("Account opened");
    }
    void closeaccount(){
        System.out.println("Account closed");
}
   void deposit(double amount){
    this.balance+=amount;
    }

    void withdraw(double amount){
        this.balance-=amount;
    }
    double checkBalance() {
     return balance;


    }
}
