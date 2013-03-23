package com.example.designpatterns.visitor.orders;

import com.example.designpatterns.visitor.visitors.VisitorInterface;

public class OverseasOrder implements Order
{
    private double orderAmount;
    private double shippingCost;
    private static double maxOverseasOrder;
    private static double minOverseasOrder = -1;
    private static double totalOverseasOrder;
    private static double totalShippingCost;

    public OverseasOrder(double orderAmount, double shippingCost)
    {
        this.orderAmount = orderAmount;
        this.shippingCost = shippingCost;
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getShippingCost() {
        return shippingCost;
    }
}
