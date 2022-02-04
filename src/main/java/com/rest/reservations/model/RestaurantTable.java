package com.rest.reservations.model;

import javax.persistence.*;

@Entity
@Table(name = "tables")// created a new table called tables

public class RestaurantTable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer numberOfSeats;

    @Column    private Integer tableNumber;

    public RestaurantTable() {
    }
    public RestaurantTable(Long id, Integer numberOfSeats, Integer tableNumber) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.tableNumber = tableNumber;
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

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }
}
