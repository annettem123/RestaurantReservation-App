package com.rest.reservations.model;

public class Reservation {
    @reservation_Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer table_Id;

    @Column
    private Integer customer_Id;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private Integer party_of;

    @Column
    private Integer customer_Id;

