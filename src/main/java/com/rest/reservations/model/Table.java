package com.rest.reservations.model;

public class Table {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer number_of_seats;

    @Column
    private Integer reservation_Id;
}
