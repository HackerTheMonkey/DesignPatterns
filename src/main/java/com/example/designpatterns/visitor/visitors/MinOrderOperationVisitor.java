package com.example.designpatterns.visitor.visitors;

import com.example.designpatterns.visitor.orders.Order;
import com.example.designpatterns.visitor.orders.OverseasOrder;
import com.example.designpatterns.visitor.orders.UkOrder;

public class MinOrderOperationVisitor implements VisitorInterface {

    private double minOrder = -1;

    @Override
    public void visit(UkOrder ukOrder) {
        computeMinOrder(ukOrder);
    }

    private void computeMinOrder(Order order) {
        if(minOrder > order.getOrderAmount() || minOrder == -1){
            minOrder = order.getOrderAmount();
        }
    }

    @Override
    public void visit(OverseasOrder overseasOrder) {
        computeMinOrder(overseasOrder);
    }

    @Override
    public double getOperationResult() {
        return minOrder;
    }
}
