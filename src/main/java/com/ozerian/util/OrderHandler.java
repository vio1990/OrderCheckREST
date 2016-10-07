package com.ozerian.util;

import com.ozerian.model.entity.Order;
import com.ozerian.model.Status;

import java.util.Date;

/**
 * This class implements Runnable interface with override run() method.
 * This class should contain a logic regrading order's handling.
 */
public class OrderHandler implements Runnable {

    private Order order;

    public OrderHandler(Order order) {
        this.order = order;
    }

    /**
     * Method with logic of order's handling.
     */
    @Override
    public void run() {
        try {
            // order's handling logic.
            Thread.currentThread().sleep(30000);
            //after logic's execution, status makes done and time fixes.
            order.setStatus(Status.DONE);
            order.setOrderTime(new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
