package com.ozerian.client;

import com.ozerian.model.entity.Order;
import com.ozerian.model.entity.Status;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is for storing of orders in ConcurrentHashMap. There is also
 * a counter of orders' id with it's autoincrement in addOrder() method.
 * There is also check if previous order has been done. If the difference between
 * requests is less then 30 second the next request will be with "PENDING" status.
 */
public final class OrdersCache {

    private static Map<String, Order> orders = new ConcurrentHashMap<>();
    private volatile static long ordersCounter = 0;

    /**
     * This method is for new order creation and addition it to
     * the cash (ConcurrentHasMap). There is check if previous order
     * has been done. Time of creation and status are also set to the
     * order.
     *
     * @return Order new created order.
     */
    public static Order addOrder() {
        Order order = new Order();

        // check if previous order has been done (check if the difference less than 30 seconds).
        if (orders.containsKey(String.valueOf(ordersCounter)) && (new Date().getTime() - orders.get(String.valueOf(ordersCounter)).getTime().getTime()) < 30000 ) {
            order.setStatus(Status.PENDING);
        } else {
            order.setStatus(Status.DONE);
        }

        order.setId(++ordersCounter);
        order.setTime(new Date());
        // put new order to the cache.
        orders.put(String.valueOf(order.getId()), order);
        return order;
    }

    /**
     * Get Map with existing orders.
     *
     * @return Map Map with existing orders.
     */
    public static Map<String, Order> getOrders() {
        return orders;
    }
}
