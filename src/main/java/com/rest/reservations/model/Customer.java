package com.rest.reservations.model;

public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String mobile_number;

    @Column
    private String email;

    @Column
    private Integer reservation_Id;
}
