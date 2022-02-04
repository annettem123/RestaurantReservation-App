package com.rest.reservations.repository;

import com.rest.reservations.model.Customer;
import com.rest.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {
//    Customer findByfirstName(String CustomerName);


}


