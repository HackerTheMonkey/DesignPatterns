package com.example.designpatterns.state;

public class OverDrawnState extends State {
    public static final int OVERDRAWN_TRANSACTION_FEE = 5;

    public OverDrawnState(BusinessAccount businessAccount) {
        super(businessAccount);
    }

    protected void transitionContextState() {
        if(getContext().getBalance() >= 0 && getContext().getBalance() <= BusinessAccount.MINIMUM_BALANCE){
            getContext().setState(new TransactionFeeState(getContext()));
            return;
        }

        if(getContext().getBalance() > BusinessAccount.MINIMUM_BALANCE)
        {
            getContext().setState(new NoTransactionFeeState(getContext()));
        }
    }

    @Override
    protected int getTransactionFee() {
        return OVERDRAWN_TRANSACTION_FEE;
    }
}
