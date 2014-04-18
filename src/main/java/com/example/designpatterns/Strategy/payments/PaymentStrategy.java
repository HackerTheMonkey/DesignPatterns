package com.example.designpatterns.strategy.payments;

import com.example.designpatterns.strategy.Item;

public interface PaymentStrategy {
    boolean payForItem(Item item);
}
