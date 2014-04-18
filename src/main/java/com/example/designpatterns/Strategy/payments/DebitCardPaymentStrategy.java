package com.example.designpatterns.strategy.payments;

import com.example.designpatterns.strategy.Item;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean payForItem(Item item) {
        System.out.printf("%s has been paid via a 'Debit Card' for a %s%n", item.getPrice(), item.getName());
        return true;
    }
}
