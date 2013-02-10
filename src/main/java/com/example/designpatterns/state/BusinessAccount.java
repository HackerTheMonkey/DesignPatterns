package com.example.designpatterns.state;

public class BusinessAccount
{
    public static final double OVERDRAFT_LIMIT = -1000.0;
    public static final int MINIMUM_BALANCE = 2000;

    private double balance;
    private double transactionFee;
    private State currentState = State.initialState(this);

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount)
    {
        return currentState.withdraw(amount);
    }

    public void deposit(int amount)
    {
        currentState.deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public boolean isBalanceAboveOverdraftLimit(double withdrawAmount) {
        return (getBalance() - withdrawAmount) >= BusinessAccount.OVERDRAFT_LIMIT;
    }
}
