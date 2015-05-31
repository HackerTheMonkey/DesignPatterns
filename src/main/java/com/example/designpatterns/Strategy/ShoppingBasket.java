package com.example.designpatterns.strategy;

import com.example.designpatterns.strategy.payments.PaymentStrategy;

public class ShoppingBasket {
    private com.example.designpatterns.strategy.Item item;

    public void addItem(com.example.designpatterns.strategy.Item item) {
        this.item = item;
    }

    public boolean checkout(PaymentStrategy paymentStrategy) {
        return paymentStrategy.payForItem(item);
    }
}
