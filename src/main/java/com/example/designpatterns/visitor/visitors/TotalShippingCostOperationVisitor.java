package com.example.designpatterns.visitor.visitors;

import com.example.designpatterns.visitor.orders.OverseasOrder;
import com.example.designpatterns.visitor.orders.UkOrder;

public class TotalShippingCostOperationVisitor extends OrderVisitor{

    @Override
    public void visit(UkOrder ukOrder) {
        addToTotal(0);
    }

    @Override
    public void visit(OverseasOrder overseasOrder) {
        addToTotal(overseasOrder.getShippingCost());
    }


    @Override
    public double getOperationResult() {
        return total;
    }
}
