package com.rest.reservations.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations") // created a new table called reservations
public class Reservation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private Integer partyOf;

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


