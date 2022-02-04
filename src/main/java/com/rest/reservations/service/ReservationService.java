import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ReservationService:

        package com.rest.reservations.service;

        import com.rest.reservations.exceptions.InformationExistException;
        import com.rest.reservations.exceptions.InformationNotFoundException;
        import com.rest.reservations.model.Reservation;
        import com.rest.reservations.repository.ReservationRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;

        import java.util.List;
        import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public Reservation createCustomerReservation(Long customerId, Reservation reservationObject) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        ReservationObject.setCustomer(Customer.get());
        return reservationRepository.save(reservationObject);
    }

    public List<Reservation> getCustomerReservations(Long customerId) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get().getReservationList();
        } else {
            throw new InformationNotFoundException("customer with id " + CustomerId + " not found");
        }

    }


    public Reservation getCustomerReservation(Long customerId, Long ReservationId) {


        Optional<Customer> customer = CustomerRepository.findById(customerId);
        if (customer.isPresent()) {
            for (Reservation reservation : customer.get().getReservationList()) {
                if (reservation.getId() == reservationId) {
                    return reservation;
                }
            }
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        } else {
            throw new InformationNotFoundException("customer with id " + customerId + " not found");
        }
    }


    public Reservation updateCustomerReservation(Long customerId, Long reservationId, Reservation reservationObject) {
        //getting the Customer: potentially the customer might not exist; and we also want to ensure we get the reservation in the right location
        Optional<Customer> customer = customerRepository.findById(customerId);//possibility of a Customer. If it does exit, it'll be an object. If not null.
        if (customer.isPresent()) {//Customer has to exist
            /*
             * If the customer does exist this for loop runs.
             * this loop iterates over List<Item>
             * Reservations = { Reservation, Reservation, Reservation, Reservation }
             * items[i]; i = 0, i = 1, i = 2 ...
             *
             * This special loop below. Skips over it
             * so you could imagine it as a shorter for loop
             * where reservation is kind of like what would've been reservations.get(i);
             */
            for (Reservation reservation : customer.get().getReservationList()) {
                // {id, id, date, time, party_of}
                if (reservation.getId() == reservationId) {// compare id of reservation at current iteration and id given by the customer that they want to update
                    // if the id customer gave and id of current iteration is same. Do this below.
                    reservation.setDate(ReservationObject.getDate());//this stays the same
                    reservation.setTime(ReservationObject.getTime());//this stays the same
                    reservation.setParty_of(ReservationObject.getParty_of());//this stays the same
//Reservation.setPublic(ReservationObject.isPublic()); this is the only thing that changed.//
                    return reservationRepository.save(reservation);
                }
            }
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        } else {
            throw new InformationNotFoundException("customer with id " + customerId + " not found");
        }
    }

    public Reservation deleteCustomerReservation(Long customerId, Long reservationId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            for (Reservation reservation : customer.get().getReservationList()) {
                if (reservation.getId() == reservationId) {
                    ReservationRepository.deleteById(ReservationId);
                    return reservation;
                }
            }
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        } else {
            throw new InformationNotFoundException("customer with id " + customerId + " not found");
        }
    }
}
