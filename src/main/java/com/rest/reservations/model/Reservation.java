package com.rest.reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "reservations") // created a new table called reservations
public class Reservation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Reservation() {
    }

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private Integer partyOf;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Reservation(Long id, String date, String time, Integer partyOf) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.partyOf = partyOf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPartyOf() {
        return partyOf;
    }

    public void setPartyOf(Integer partyOf) {
        this.partyOf = partyOf;
    }
}


