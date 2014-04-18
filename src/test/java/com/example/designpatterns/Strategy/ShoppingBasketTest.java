package com.example.designpatterns.strategy;

import com.example.designpatterns.strategy.payments.CreditCardPaymentStrategy;
import com.example.designpatterns.strategy.payments.DebitCardPaymentStrategy;
import com.example.designpatterns.strategy.payments.PaypalPaymentStrategy;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingBasketTest {
    @Test
    public void should_be_able_to_checkout_via_paypal()
    {
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        shoppingBasket.addItem(new Item("Bannana", 1.0));

        assertThat(shoppingBasket.checkout(new PaypalPaymentStrategy()), is(true));
    }

    @Test
    public void should_prevent_customers_from_paying_via_credit_card()
    {
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        shoppingBasket.addItem(new Item("Bannana", 1.0));

        assertThat(shoppingBasket.checkout(new CreditCardPaymentStrategy()), is(false));
    }

    @Test
    public void should_be_able_to_checkout_via_debit_card()
    {
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        shoppingBasket.addItem(new Item("Orange", 1.0));

        assertThat(shoppingBasket.checkout(new DebitCardPaymentStrategy()), is(true));
    }
}
