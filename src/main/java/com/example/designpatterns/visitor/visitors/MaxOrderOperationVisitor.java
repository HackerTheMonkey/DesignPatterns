package com.example.designpatterns.visitor.visitors;

import com.example.designpatterns.visitor.orders.Order;
import com.example.designpatterns.visitor.orders.OverseasOrder;
import com.example.designpatterns.visitor.orders.UkOrder;

public class MaxOrderOperationVisitor implements VisitorInterface
{
    private double maxOrder;


    public void visit(UkOrder ukOrder) {
        computeMaxOrder(ukOrder);
    }

    @Override
    public void visit(OverseasOrder order) {
        computeMaxOrder(order);
    }

    @Override
    public double getOperationResult() {
        return maxOrder;
    }

    private void computeMaxOrder(Order order) {
        if(maxOrder < order.getOrderAmount()){
            maxOrder = order.getOrderAmount();
        }
    }

}
