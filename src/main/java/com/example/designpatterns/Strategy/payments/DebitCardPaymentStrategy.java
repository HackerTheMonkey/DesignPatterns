package com.example.designpatterns.Strategy.payments;

import com.example.designpatterns.Strategy.Item;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean payForItem(Item item) {
        System.out.printf("%s has been paid via a 'Debit Card' for a %s%n", item.getPrice(), item.getName());
        return true;
    }
}
