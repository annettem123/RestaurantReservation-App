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

    public Table(Long id, Integer number_of_seats, Integer reservation_Id) {
        this.id = id;
        this.number_of_seats = number_of_seats;
        this.reservation_Id = reservation_Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Integer getReservation_Id() {
        return reservation_Id;
    }

    public void setReservation_Id(Integer reservation_Id) {
        this.reservation_Id = reservation_Id;
    }
}
