package com.rest.reservations.repository;

import com.rest.reservations.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Customer findByfirstName(String CustomerName);

}
