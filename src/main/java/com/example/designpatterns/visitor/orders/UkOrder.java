package com.example.designpatterns.visitor.orders;

import com.example.designpatterns.visitor.visitors.VisitorInterface;

public class UkOrder implements Order
{
    private double orderAmount;

    public UkOrder(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
