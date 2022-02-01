package com.rest.reservations.model;

@Entity
@Table(name = "reservation") // created a new table called reservation
public class Reservation {
    @Id
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

    public Reservation(Long id, Integer table_Id, Integer customer_Id, String date, String time, String Integer party_of, Integer customer_Id) {
        this.id = id;
        this.table_Id = table_Id;
        this.customer_Id = customer_Id;
        this.date = date;
        this.time = time;
        this.party_of = party_of;
        this.customer_Id = customer_Id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTable_Id() {
        return table_Id;
    }

    public void setTable_Id(Integer table_Id) {
        this.table_Id = table_Id;
    }

    public Integer getCustomer_Id(Integer customer_Id) {
        return customer_Id;
    }

    public void setCustomer_Id(Integer customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getDate(String date){
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

    public Integer getParty_of(Integer party_of) {
        return party_of;
    }

    public void setParty_of(Integer party_of) {
        this.party_of = party_of;
    }


