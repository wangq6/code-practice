package com.leetcode.java.algorithm.ATM;

import java.io.Console;

public class DisplayConsoleImpl implements DisplayConsole {

    Console console;

    public DisplayConsoleImpl() {
        console = System.console();
    }

    @Override  
    public char[] askForPassword() {
        System.out.println("Please Enter Password: ");
        return console.readPassword();
    }

    @Override
    public void wrongPassword() {
        System.out.println("Wrong Password");
    }

    @Override
    public AccountAction makeSelection() {
        System.out.println("Please Make Selection: ");
        String selection = console.readLine();
        switch (selection.toLowerCase()) {
        case "transfer":
            return AccountAction.TRANSFER;
        case "query":
            return AccountAction.QUERY;
        case "withdraw":
            return AccountAction.WITHDRAWL;
        case "deposit":
            return AccountAction.DEPOSIT;
        default:
            return AccountAction.ERROR;
        }
    }

    @Override
    public AccountType chooseFromAccount() {
        System.out.println("Please Enter Account you want to transfer amount from: ");
        String type = console.readLine();
        switch (type.toLowerCase()) {
        case "saving":
            return AccountType.SAVING;
        case "checking":
            return AccountType.CHECKING;
        default:
            return AccountType.ERROR;
        }
    }

    @Override
    public AccountType chooseToAccount() {
        // TODO Auto-generated method stub
        System.out.println("Please Enter Account you want to transfer amount to: ");
        String type = console.readLine();
        switch (type.toLowerCase()) {
        case "Saving":
            return AccountType.SAVING;
        case "Checking":
            return AccountType.CHECKING;
        default:
            return AccountType.ERROR;
        }
    }

    @Override
    public float enterAmount() {
        System.out.println("Please Enter Amount");
        String amount = console.readLine();
        return Float.parseFloat(amount);
    }

    @Override
    public void insufficientAmount() {
        System.out.println("Insufficient Amount");
    }

    @Override
    public void authExpired() {
        System.out.println("AuthKey Expired");
    }

    @Override
    public void thankYou() {
        System.out.println("Thank you");
    }

}
