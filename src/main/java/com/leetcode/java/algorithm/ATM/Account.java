package com.leetcode.java.algorithm.ATM;

public interface Account {
    boolean getAuth(char[] password) throws Exception;

    boolean logout();

    float query(AccountType type) throws Exception;

    float deposit(AccountType type, float number) throws Exception;

    float withdraw(AccountType type, float number) throws Exception;

    float transfer(AccountType fromType, AccountType toType, float number) throws Exception;
}
