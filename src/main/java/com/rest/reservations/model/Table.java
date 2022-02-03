package com.rest.reservations.model;

import javax.persistence.*;


@Entity
@Table(name = "tables") // created a new table called tables

public class Table {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer numberOfSeats;

    @Column
    private Integer reservationId;

    public Table(Long id, Integer numberOfSeats, Integer reservationId) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.reservationId = reservationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
}
