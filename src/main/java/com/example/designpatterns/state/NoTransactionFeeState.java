package com.example.designpatterns.state;

public class NoTransactionFeeState extends State {
    public static final int ZERO_TRANSACTION_FEE = 0;
    public NoTransactionFeeState(BusinessAccount businessAccount) {
        super(businessAccount);
    }

    protected void transitionContextState() {
        if(getContext().getBalance() >= 0 && getContext().getBalance() <= BusinessAccount.MINIMUM_BALANCE){
            getContext().setState(new TransactionFeeState(getContext()));
            return;
        }

        if(getContext().getBalance() < 0){
            getContext().setState(new OverDrawnState(getContext()));
        }
    }

}
