package com.example.designpatterns.visitor.orders;

import com.example.designpatterns.visitor.visitors.VisitorInterface;

public interface Order
{
    public void accept(VisitorInterface visitor);

    double getOrderAmount();
}
