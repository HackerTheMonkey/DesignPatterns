package com.example.designpatterns.state;

public abstract class State
{
    private BusinessAccount context;

    public State(BusinessAccount businessAccount) {
        context = businessAccount;
    }

    public boolean withdraw(double amount) {

        getContext().setTransactionFee(getTransactionFee());

        amount += getContext().getTransactionFee();

        if(getContext().isBalanceAboveOverdraftLimit(amount)){
            getContext().setBalance(getContext().getBalance() - amount);
            transitionContextState();
            return true;
        }

        return false;
    }

    public void deposit(double amount){
        amount -= getTransactionFee();
        getContext().setBalance(getContext().getBalance() + amount);
        transitionContextState();
    }

    protected abstract void transitionContextState();

    protected int getTransactionFee(){
        return NoTransactionFeeState.ZERO_TRANSACTION_FEE;
    };

    public static State initialState(BusinessAccount businessAccount) {
        return new NoTransactionFeeState(businessAccount);
    }

    public BusinessAccount getContext() {
        return context;
    }
}
