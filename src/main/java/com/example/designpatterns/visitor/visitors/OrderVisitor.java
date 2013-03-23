package com.example.designpatterns.visitor.visitors;

public abstract class OrderVisitor implements VisitorInterface{
    protected double total;

    protected void addToTotal(double orderAmount) {
        total += orderAmount;
    }
}
