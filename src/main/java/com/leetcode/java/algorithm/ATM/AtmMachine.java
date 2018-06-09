package com.leetcode.java.algorithm.ATM;

public class AtmMachine {
    private Account account;
    private CardHandler cardHandler;
    private DisplayConsole displayConsole;
    private CashEnvelopHandler cashEnvelopHandler;
    private CashExpenserHandler cashExpenserHandler;

    public AtmMachine() {
        cardHandler = new CardHandlerImpl();
        displayConsole = new DisplayConsoleImpl();
        cashEnvelopHandler = new CashEnvelopHandlerImpl();
        cashExpenserHandler = new CashExpenserHandlerImpl();
    }

    public void login(String cardNumber) throws Exception {
        account = cardHandler.getAccount(cardNumber);
        if (account.getAuth(displayConsole.askForPassword())) {
            menu();
        } else {
            displayConsole.wrongPassword();
        }

    }

    public void menu() throws Exception {
        AccountType fromType;
        AccountType toType;
        float amount;
        try {
            switch (displayConsole.makeSelection()) {
            case QUERY:
                fromType = displayConsole.chooseFromAccount();
                account.query(fromType);
                break;
            case TRANSFER:
                fromType = displayConsole.chooseFromAccount();
                toType = displayConsole.chooseToAccount();
                amount = displayConsole.enterAmount();
                account.transfer(fromType, toType, amount);
                break;
            case WITHDRAWL:
                fromType = displayConsole.chooseFromAccount();
                amount = displayConsole.enterAmount();
                account.withdraw(fromType, amount);
                cashExpenserHandler.popCash(amount);
                break;
            case DEPOSIT:
                fromType = displayConsole.chooseFromAccount();
                amount = displayConsole.enterAmount();
                cashEnvelopHandler.countCash(amount);
                account.deposit(fromType, amount);
                break;
            default:
                break;
            }
        } catch (Exception e) {
            if (e.getMessage().startsWith("Insufficient Amount")) {
                displayConsole.insufficientAmount();
            }
        } finally {
            cardHandler.returnCard();
            displayConsole.thankYou();
        }
    }

}
