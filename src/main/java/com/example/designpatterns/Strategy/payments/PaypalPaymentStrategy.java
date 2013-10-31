package com.example.designpatterns.Strategy.payments;

import com.example.designpatterns.Strategy.Item;

public class PaypalPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean payForItem(Item item) {
        System.out.printf("%s has been paid via PayPal for a %s%n", item.getPrice(), item.getName());
        return true;
    }
}
