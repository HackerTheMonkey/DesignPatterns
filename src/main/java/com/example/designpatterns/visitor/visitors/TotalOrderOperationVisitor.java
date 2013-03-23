package com.example.designpatterns.visitor.visitors;

import com.example.designpatterns.visitor.orders.OverseasOrder;
import com.example.designpatterns.visitor.orders.UkOrder;

public class TotalOrderOperationVisitor extends OrderVisitor{

    @Override
    public void visit(UkOrder ukOrder) {
        addToTotal(ukOrder.getOrderAmount());
    }

    @Override
    public void visit(OverseasOrder overseasOrder) {
        addToTotal(overseasOrder.getOrderAmount());
    }

    @Override
    public double getOperationResult() {
        return total;
    }
}
