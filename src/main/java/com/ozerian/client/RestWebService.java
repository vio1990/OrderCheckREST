package com.ozerian.client;

import com.ozerian.model.entity.Order;
import com.ozerian.model.entity.Status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Path("/")
public class RestWebService {

    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("orderId") String orderId) {
        Order order = OrdersCache.getOrders().get(orderId);
        return order;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Order makeNewOrder() {
        Order order = OrdersCache.addOrder();
        executorService.scheduleWithFixedDelay(new OrderHandler(order), 0, 5, TimeUnit.SECONDS);
        return order;
    }
}