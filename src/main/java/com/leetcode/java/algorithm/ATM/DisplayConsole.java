package com.leetcode.java.algorithm.ATM;

public interface DisplayConsole {

    char[] askForPassword();

    void wrongPassword();

    AccountAction makeSelection();

    AccountType chooseFromAccount();

    AccountType chooseToAccount();

    float enterAmount();

    void insufficientAmount();

    void authExpired();

    void thankYou();
}
