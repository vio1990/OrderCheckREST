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
            Thread.currentThread().sleep(30000);
            order.setStatus(Status.DONE);
            order.setTime(new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
