package com.example.designpatterns.visitor.visitors;


import com.example.designpatterns.visitor.orders.OverseasOrder;
import com.example.designpatterns.visitor.orders.UkOrder;

public interface VisitorInterface
{
    public void visit(UkOrder ukOrder);

    public void visit(OverseasOrder overseasOrder);

    double getOperationResult();

}
