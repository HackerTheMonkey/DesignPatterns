package com.example.designpatterns.Strategy.payments;

import com.example.designpatterns.Strategy.Item;

public interface PaymentStrategy {
    boolean payForItem(Item item);
}
