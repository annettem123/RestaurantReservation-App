package com.rest.reservations.model;

import javax.persistence.Entity;


public class Server {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private Integer table_Id;

    public Server(Long id, String first_name, String last_name, Integer table_Id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.table_Id = table_Id;
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

    public Integer getTable_Id() {
        return table_Id;
    }

    public void setTable_Id(Integer table_Id) {
        this.table_Id = table_Id;
    }
}
