package com.leetcode.java.algorithm.ATM;

public interface CardHandler {
    Account getAccount(String cardNumber) throws Exception;

    boolean returnCard();
}
