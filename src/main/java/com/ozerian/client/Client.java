package com.ozerian.client;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class represents client entity (f.e. car) with id and e-email fields.
 */
public class Client {

    private long id;
    private String email;
    private BigDecimal moneyToPay;
    private boolean isInPaidZone;
    private Date entryTime;
    private Date exitTime;


    public Client() {
    }

    public Client(long id, String email, BigDecimal moneyToPay, boolean isInPaidZone, Date entryTime, Date exitTime) {
        this.id = id;
        this.email = email;
        this.moneyToPay = moneyToPay;
        this.isInPaidZone = isInPaidZone;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
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
     * Get client's email.
     *
     * @return String client's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email adress
     *
     * @param email String client's address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the amount of money for payment.
     *
     * @return BigDecimal money amount for Payment.
     */
    public BigDecimal getMoneyToPay() {
        return moneyToPay;
    }

    /**
     * Set money for payment.
     *
     * @param moneyToPay BigDecimal money for payment.
     */
    public void setMoneyToPay(BigDecimal moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    /**
     * Get clients status (is in zone or not).
     *
     * @return boolean is client in paid zone.
     */
    public boolean isInPaidZone() {
        return isInPaidZone;
    }

    /**
     * Set clients status.
     *
     * @param inPaidZone boolean status of teh client.
     */
    public void setInPaidZone(boolean inPaidZone) {
        isInPaidZone = inPaidZone;
    }


    /**
     * Get client's entry time.
     *
     * @return Date time of the clients entry.
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * Set client's entry time.
     *
     * @param entryTime Date client's entry time
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * Get client's exit time.
     *
     * @return Date time of the clients exit.
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * Set client's exit time.
     *
     * @param exitTime Date time of the clients exit.
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
