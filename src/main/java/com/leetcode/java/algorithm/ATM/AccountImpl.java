package com.leetcode.java.algorithm.ATM;

public class AccountImpl implements Account {
    private String accountId;
    private String authKey;
    private float mockChecking;
    private float mockSaving;

    public AccountImpl(String accountId) {
        this.accountId = accountId;
        mockChecking = 40050.50f;
        mockSaving = 54064.67f;
    }

    @Override
    public boolean getAuth(char[] password) {
        authKey = mockAuth(accountId, password);
        return authKey != null;
    }

    @Override
    public float query(AccountType type) throws Exception {
        switch (type) {
        case SAVING:
            return mockGetSaving(authKey);
        case CHECKING:
            return mockGetChecking(authKey);
        default:
            throw new Exception("Unknow Type found");
        }
    }

    @Override
    public float deposit(AccountType type, float number) throws Exception {
        switch (type) {
        case SAVING:
            mockSaving += number;
            return mockGetSaving(authKey);
        case CHECKING:
            mockChecking += number;
            return mockGetChecking(authKey);
        default:
            throw new Exception("Unknow Type found");
        }
    }

    @Override
    public float withdraw(AccountType type, float number) throws Exception {
        switch (type) {
        case SAVING:
            if (number > mockGetSaving(authKey)) {
                throw new Exception("Insufficient Amount on Saving");
            }
            mockSaving -= number;
            return mockGetSaving(authKey);
        case CHECKING:
            if (number > mockGetChecking(authKey)) {
                throw new Exception("Insufficient Amount on Checking");
            }
            mockChecking -= number;
            return mockGetChecking(authKey);
        default:
            throw new Exception("Unknow Type found");
        }
    }

    @Override
    public float transfer(AccountType fromType, AccountType toType, float number) throws Exception {
        switch (fromType) {
        case SAVING:
            if (number > mockGetSaving(authKey)) {
                throw new Exception("Insufficient Amount on Saving");
            }
            mockSaving -= number;
            mockChecking += number;
            return mockGetSaving(authKey);
        case CHECKING:
            if (number > mockGetChecking(authKey)) {
                throw new Exception("Insufficient Amount on Checking");
            }
            mockChecking -= number;
            mockSaving += number;
            return mockGetChecking(authKey);
        default:
            throw new Exception("Unknow Type found");
        }
    }

    private String mockAuth(String accountId, char[] password) {
        if ("password".equals(new String(password))) {
            return "mockAuthKey";
        } else {
            return null;
        }
    }

    private float mockGetChecking(String authKey) throws Exception {
        if (authKey.equals("mockAuthKey")) {
            return mockChecking;
        } else {
            throw new Exception("AuthKey Expired");
        }
    }

    private float mockGetSaving(String authKey) throws Exception {
        if (authKey.equals("mockAuthKey")) {
            return mockSaving;
        } else {
            throw new Exception("AuthKey Expired");
        }
    }

    @Override
    public boolean logout() {
        // Invoke API to deactivate authKey
        authKey = null;
        return authKey == null;
    }
}
