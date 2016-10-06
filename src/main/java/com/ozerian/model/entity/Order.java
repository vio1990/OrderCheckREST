package com.ozerian.model.entity;

import java.util.Date;

/**
 * This class represents client entity (f.e. car) with id and e-email fields.
 */
public class Order {

    private long id;
    private Status status;
    private Date time;


    public Order() {
    }

    public Order(long id, Status status, Date time) {
        this.id = id;
        this.status = status;
        this.time = time;
    }

    /**
     * Get id.
     *
     * @return long unique id of the client.
     */
    public long getId() {
        return id;
    }

    /**
     * Set client's id.
     *
     * @param id long client's id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get order status.
     *
     * @return Status order status.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set order status.
     *
     * @param status Status order status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get order's done time.
     *
     * @return Date order's done time.
     */
    public Date getTime() {
        return time;
    }

    /**
     * Set order's done time.
     *
     * @param time Date order's done time.
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (status != order.status) return false;
        return time != null ? time.equals(order.time) : order.time == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", time=" + time +
                '}';
    }
}