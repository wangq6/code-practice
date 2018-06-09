package com.leetcode.java.algorithm.ATM;

public class CardHandlerImpl implements CardHandler {

    public CardHandlerImpl() {
    }

    @Override
    public Account getAccount(String cardNumber) throws Exception {
        // API to get accountId from cardNumber
        if (cardNumber.equals("mockCardNumber")) {
            return new AccountImpl("mockId");
        } else {
            throw new Exception("Invalid card");
        }
    }

    @Override
    public boolean returnCard() {
        // TODO Auto-generated method stub
        return true;
    }

}
