package com.example.designpatterns.state;

public class TransactionFeeState extends State {
    public static final int NORMAL_TRANSACTION_FEE = 2;

    public TransactionFeeState(BusinessAccount businessAccount) {
        super(businessAccount);
    }

    protected void transitionContextState() {
        if(getContext().getBalance() > BusinessAccount.MINIMUM_BALANCE){
            getContext().setState(new NoTransactionFeeState(getContext()));
            return;
        }

        if(getContext().getBalance() < 0){
            getContext().setState(new OverDrawnState(getContext()));
        }
    }

    @Override
    protected int getTransactionFee() {
        return NORMAL_TRANSACTION_FEE;
    }
}
