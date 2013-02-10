package com.example.designpatterns.state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BusinessAccountTest
{
    private BusinessAccount businessAccount;

    @Before
    public void setup()
    {
        businessAccount = new BusinessAccount();
    }

    @Test
    public void should_prevent_any_withdraw_transaction_that_exceeds_the_overdraft_limit()
    {
        businessAccount.setBalance(3000.0);
        assertThat(businessAccount.withdraw(5000.0), is(false));
    }

    @Test
    public void should_allow_any_withdraw_transaction_if_balance_greater_than_withdraw_limit()
    {
        businessAccount.setBalance(3000);
        assertThat(businessAccount.withdraw(3500), is(true));
    }

    @Test
    public void a_newly_created_business_account_should_not_charge_a_fee_for_deposit_transaction() {
        businessAccount.setBalance(5000);
        businessAccount.deposit(200);
        assertThat(businessAccount.getBalance(), is(equalTo(5200.0)));
    }

    @Test
    public void a_newly_created_business_account_should_not_charge_a_fee_for_withdraw_transaction() {
        businessAccount.setBalance(5000);
        businessAccount.withdraw(200);
        assertThat(businessAccount.getBalance(), is(equalTo(4800.0)));
    }

    @Test
    public void should_transition_to_TransactionFeeState_from_NoTransactionFeeState_when_balance_drops_below_minimum()
    {
        businessAccount.setBalance(3000);

        withdrawShouldBePermittedFor(2000);

        shouldNotChargeAnyFee(1000.0);

        withdrawShouldBePermittedFor(100);

        shouldChargeExpectedTransactionFee(898.0);
    }


    @Test
    public void should_transition_to_OverDrawnState_from_NoTransactionFeeState_when_balance_becomes_negative()
    {
        businessAccount.setBalance(3000);

        withdrawShouldBePermittedFor(3500);

        shouldNotChargeAnyFee(-500.0);

        withdrawShouldBePermittedFor(100);

        shouldChargeExpectedTransactionFee(-605.0);
    }

    @Test
    public void should_transition_to_OverDrawnState_from_TransactionFeeState_when_balance_becomes_negative()
    {
        businessAccount.setState(new TransactionFeeState(businessAccount));

        businessAccount.setBalance(1000);

        withdrawShouldBePermittedFor(1500);

        shouldChargeExpectedTransactionFee(-502.0);

        withdrawShouldBePermittedFor(100);

        shouldChargeExpectedTransactionFee(-607.0);
    }

    @Test
    public void should_transition_to_NoTransactionFeeState_from_TransactionFeeState_when_balance_goes_above_minimum()
    {
        businessAccount.setState(new TransactionFeeState(businessAccount));
        businessAccount.setBalance(1000);

        businessAccount.deposit(1500);

        shouldChargeExpectedTransactionFee(2498.0);

        withdrawShouldBePermittedFor(100);

        shouldNotChargeAnyFee(2398);
    }

    @Test
    public void should_transition_to_NoTransactionFeeState_from_OverDrawnState_when_balance_goes_above_minimum()
    {
        businessAccount.setState(new OverDrawnState(businessAccount));

        businessAccount.setBalance(-750);

        businessAccount.deposit(3000);

        shouldChargeExpectedTransactionFee(2245.0);

        withdrawShouldBePermittedFor(100);

        shouldNotChargeAnyFee(2145);
    }

    @Test
    public void should_transition_to_TransactionFeeState_from_OverDrawnState_when_balance_jumps_to_below_minimum()
    {
        businessAccount.setState(new OverDrawnState(businessAccount));

        businessAccount.setBalance(-750);

        businessAccount.deposit(1000);

        shouldChargeExpectedTransactionFee(245.0);

        withdrawShouldBePermittedFor(100);

        shouldChargeExpectedTransactionFee(143);
    }

    private void shouldChargeExpectedTransactionFee(double expectedBalance) {
        assertThat(businessAccount.getBalance(), is(expectedBalance));
    }

    private void shouldNotChargeAnyFee(double expectedBalance) {
        assertThat(businessAccount.getBalance(), is(equalTo(expectedBalance)));
    }

    private void withdrawShouldBePermittedFor(int amount) {
        assertThat(businessAccount.withdraw(amount), is(true));
    }
}
