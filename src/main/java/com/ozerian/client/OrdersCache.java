package com.ozerian.client;

import com.ozerian.model.entity.Order;
import com.ozerian.model.entity.Status;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class OrdersCache {

    private static Map<String, Order> orders = new ConcurrentHashMap<>();
    private volatile static long ordersCounter = 0;

    public static Order addOrder() {
        Order order = new Order();

        if (orders.containsKey(String.valueOf(ordersCounter)) && (new Date().getTime() - orders.get(String.valueOf(ordersCounter)).getTime().getTime()) < 30000 ) {
            order.setStatus(Status.PENDING);
        } else {
            order.setStatus(Status.DONE);
        }

        order.setId(++ordersCounter);
        order.setTime(new Date());
        orders.put(String.valueOf(order.getId()), order);
        return order;
    }

    public static Map<String, Order> getOrders() {
        return orders;
    }
}
