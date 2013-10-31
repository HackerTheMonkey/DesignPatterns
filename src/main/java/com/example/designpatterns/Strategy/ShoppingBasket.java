package com.example.designpatterns.Strategy;

import com.example.designpatterns.Strategy.payments.PaymentStrategy;

public class ShoppingBasket {
    private Item item;

    public void addItem(Item item) {
        this.item = item;
    }

    public boolean checkout(PaymentStrategy paymentStrategy) {
        return paymentStrategy.payForItem(item);
    }
}
