package com.rest.reservations.model;

import javax.persistence.*;


public class Reservation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer tableId;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private Integer partyOf;

    @Column
    private Integer customerId;

    public Reservation(Long id, Integer tableId, String date, String time, Integer partyOf, Integer customerId) {
        this.id = id;
        this.tableId = tableId;
        this.date = date;
        this.time = time;
        this.partyOf = partyOf;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getCustomerId(Integer customerId) {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDate(String date) {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime(String time) {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPartyOf(Integer partyOf) {
        return partyOf;
    }

    public void setPartyOf(Integer partyOf) {
        this.partyOf = partyOf;
    }
}


