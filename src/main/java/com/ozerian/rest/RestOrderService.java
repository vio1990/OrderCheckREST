package com.ozerian.rest;

import com.ozerian.util.OrderHandler;
import com.ozerian.util.OrdersCache;
import com.ozerian.model.entity.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is a RESTful web-service with appropriate methods for
 * check of order status and creation and handling of new orders.
 * Orders are being handled by ExecutorService.
 */
@Path("/")
public class RestOrderService {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * This method is for check od order status and getting of it's
     * JSON representation.
     *
     * @param orderId String order's io for check of it's status.
     * @return Order JSON representation of the order.
     */
    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("orderId") String orderId) {
        Order order = OrdersCache.getOrders().get(orderId);
        return order;
    }

    /**
     * This method is for creation of new order and handling it
     * through Executor service. After that method returns JSON
     * representation of new order.
     *
     * @return Order JSON representation of new order.
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Order makeNewOrder() {
        Order order = OrdersCache.addOrder();
        executorService.submit(new OrderHandler(order));
        return order;
    }
}