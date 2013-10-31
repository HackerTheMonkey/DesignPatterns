package com.example.designpatterns.Strategy.payments;

import com.example.designpatterns.Strategy.Item;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean payForItem(Item item) {
        System.out.println("Payment using a Credit Card are not allowed!");
        return false;
    }
}
