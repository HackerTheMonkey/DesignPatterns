package com.example.designpatterns.visitor.orders;

import com.example.designpatterns.visitor.visitors.*;

public class OrderManager {

    private VisitorInterface maxOverseasOrderVisitor = new MaxOrderOperationVisitor();
    private VisitorInterface maxUkOrderVisitor = new MaxOrderOperationVisitor();

    private VisitorInterface minOverseasOrderVisitor = new MinOrderOperationVisitor();
    private VisitorInterface minUkOrderVisitor = new MinOrderOperationVisitor();

    private VisitorInterface totalOverseasOrderVisitor = new TotalOrderOperationVisitor();
    private VisitorInterface totalUkOrderVisitor = new TotalOrderOperationVisitor();

    private VisitorInterface totalOverseasShippingCostVisitor = new TotalShippingCostOperationVisitor();
    private VisitorInterface totalUkShippingCostVisitor = new TotalShippingCostOperationVisitor();

    public OverseasOrder createOverseasOrder(double orderAmount, double shippingCost)
    {
        OverseasOrder overseasOrder = new OverseasOrder(orderAmount, shippingCost);

        overseasOrder.accept(maxOverseasOrderVisitor);
        overseasOrder.accept(minOverseasOrderVisitor);
        overseasOrder.accept(totalOverseasOrderVisitor);
        overseasOrder.accept(totalOverseasShippingCostVisitor);

        return overseasOrder;
    }

    public UkOrder createUkOrder(double orderAmount)
    {
        UkOrder ukOrder = new UkOrder(orderAmount);

        ukOrder.accept(maxUkOrderVisitor);
        ukOrder.accept(minUkOrderVisitor);
        ukOrder.accept(totalUkOrderVisitor);
        ukOrder.accept(totalOverseasShippingCostVisitor);

        return ukOrder;
    }

    public double getMaxOverseasOrder()
    {
        return maxOverseasOrderVisitor.getOperationResult();
    }

    public double getMaxUkOrder() {
        return maxUkOrderVisitor.getOperationResult();
    }

    public double getMinOverseasOrder() {
        return minOverseasOrderVisitor.getOperationResult();
    }

    public double getMinUkOrder() {
        return minUkOrderVisitor.getOperationResult();
    }

    public double getTotalOverseasOrder() {
        return totalOverseasOrderVisitor.getOperationResult();
    }

    public double getTotalUkOrder() {
        return totalUkOrderVisitor.getOperationResult();
    }

    public double getTotalOverseasShippingCost() {
        return totalOverseasShippingCostVisitor.getOperationResult();
    }

    public double getTotalUkShippingCost() {
        return totalUkShippingCostVisitor.getOperationResult();
    }
}
