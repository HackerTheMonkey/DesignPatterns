package com.example.designpatterns.visitor;

import com.example.designpatterns.visitor.orders.OrderManager;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VisitorTest
{

    private OrderManager orderManager;

    @Before
    public void setup()
    {
        orderManager = new OrderManager();
    }

    @Test
    public void should_return_max_order_amount_for_overseas_orders()
    {
        createOverseasOrders();
        assertThat(orderManager.getMaxOverseasOrder(), is(equalTo(17.0)));
    }

    @Test
    public void should_return_max_order_amount_for_uk_orders()
    {
        createUkOrders();
        assertThat(orderManager.getMaxUkOrder(), is(equalTo(134.0)));
    }

    @Test
    public void should_return_min_order_amount_for_overseas_orders()
    {
        createOverseasOrders();
        assertThat(orderManager.getMinOverseasOrder(), is(equalTo(10.0)));
    }

    @Test
    public void should_return_min_order_amount_on_uk_orders()
    {
        createUkOrders();
        assertThat(orderManager.getMinUkOrder(), is(equalTo(1.0)));
    }

    @Test
    public void should_return_total_order_amount_for_overseas_order()
    {
        createOverseasOrders();
        assertThat(orderManager.getTotalOverseasOrder(), is(equalTo(57.0)));
    }

    @Test
    public void should_return_total_order_amount_for_uk_order()
    {
        createUkOrders();
        assertThat(orderManager.getTotalUkOrder(), is(equalTo(145.0)));
    }

    @Test
    public void should_return_total_overseas_order_shipping_cost()
    {
        createOverseasOrders();
        assertThat(orderManager.getTotalOverseasShippingCost(), is(equalTo(25.0)));
    }
    
    @Test
    public void should_return_total_uk_shipping_costs()
    {
        createUkOrders();
        assertThat(orderManager.getTotalUkShippingCost(), is(equalTo(0.0)));
    }

    private void createOverseasOrders() {
        orderManager.createOverseasOrder(10.00, 15.00);
        orderManager.createOverseasOrder(15.00, 2.00);
        orderManager.createOverseasOrder(17.00, 5.00);
            orderManager.createOverseasOrder(15.00, 3.00);
    }

    private void createUkOrders() {
        orderManager.createUkOrder(1.0);
        orderManager.createUkOrder(4.0);
        orderManager.createUkOrder(6.0);
        orderManager.createUkOrder(134.0);
    }
}
