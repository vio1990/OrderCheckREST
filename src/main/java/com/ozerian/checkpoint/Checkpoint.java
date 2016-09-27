package com.ozerian.checkpoint;

import java.math.BigDecimal;

public class Checkpoint {

    private int id;
    private BigDecimal price;

    public Checkpoint() {
    }

    public Checkpoint(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
