package com.labs.java.oops;

public class AccountMain {
    public static void main(String[] args) {
        Account acc1 = new Account();
        acc1.id=100;
        acc1.name="Anil";
        acc1.type="savings";
        acc1.balance=1000;
        acc1.active=true;

        acc1.openaccount();
        acc1.deposit(5000);
        acc1.withdraw(3000);
        System.out.println("current savings is " + acc1.checkBalance());
        acc1.closeaccount();


        Account acc2 = new Account();
        acc2.id=1000;
        acc2.name="Abrith";
        acc2.type="savings";
        acc2.balance=10000;
        acc2.active=true;

        acc2.openaccount();
        acc2.deposit(50000);
        acc2.withdraw(30000);
        System.out.println("current savings is " + acc2.checkBalance());
        acc2.closeaccount();

        Account acc3 = new Account(183,"kumar","savings",20000,true);
        acc3.openaccount();
        acc3.deposit(6000);
        acc3.withdraw(2000);
        System.out.println("current balance" + acc3.checkBalance());
        acc3.closeaccount();

    }
}
