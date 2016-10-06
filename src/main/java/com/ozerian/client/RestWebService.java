package com.ozerian.client;

import com.ozerian.model.entity.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RestWebService {

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
        new Thread(new OrderHandler(order)).start();
        return order;
    }
}