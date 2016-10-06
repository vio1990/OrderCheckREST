package com.ozerian.client;

import com.ozerian.model.entity.Order;
import com.ozerian.model.entity.Status;

import java.util.Date;

public class OrderHandler implements Runnable {

    private Order order;

    public OrderHandler(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            order.setStatus(Status.PENDING);
            Thread.currentThread().sleep(5000);
            order.setStatus(Status.DONE);
            order.setTime(new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
