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

    public Customer(Long id, String first_name, String last_name, String mobile_number, String email, Integer reservation_Id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile_number = mobile_number;
        this.email = email;
        this.reservation_Id = reservation_Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getReservation_Id() {
        return reservation_Id;
    }

    public void setReservation_Id(Integer reservation_Id) {
        this.reservation_Id = reservation_Id;
    }
}