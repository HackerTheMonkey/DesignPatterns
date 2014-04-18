package com.example.designpatterns.strategy.payments;

import com.example.designpatterns.strategy.Item;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean payForItem(Item item) {
        System.out.println("Payment using a Credit Card are not allowed!");
        return false;
    }
}
