package com.rest.reservations.controller;

import com.rest.reservations.model.Customer;
import com.rest.reservations.model.Reservation;
import com.rest.reservations.repository.CustomerRepository;
import com.rest.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private CustomerRepository customerRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/customers/{customerID}")
    public Optional<Customer> getCustomer(@PathVariable Long customerID) {
        return customerRepository.findById(customerID);
    }

    @PostMapping("/customers/")
    public Customer createCustomer(@RequestBody Customer body) {
        return customerRepository.save(body);
    }


    @PutMapping("/customers/{customerID}")
    public Customer updateCustomer(@PathVariable(value = "customerID") Long customerID, @RequestBody Customer body) {
        Customer customer = customerRepository.findCustomerById(customerID);
        customer.setFirstName(body.getFirstName());
        customer.setLastName(body.getLastName());
        customer.setMobileNumber(body.getMobileNumber());
        customer.setEmail(body.getEmail());
        return customerRepository.save(customer);
    }

    @DeleteMapping("/customers/{customerID}")
    public Customer deleteCustomer(@PathVariable(value = "customerID") Long customerID) {
        Optional<Customer> customer = customerRepository.findById(customerID);
        customerRepository.deleteById(customerID);
        return customer.get();

    }

    @PostMapping("/customers/{customerId}/reservations/")
    public Reservation createCustomerReservation(@PathVariable(value = "customerId") Long customerId, @RequestBody Reservation reservationObject) {
//        System.out.println("calling createCategoryRecipe===>");
        Optional<Customer> customer = customerRepository.findById(customerId);
        reservationObject.setCustomer(customer.get());
        return reservationRepository.save(reservationObject);
    }

    @GetMapping("/customers/{customerId}/reservations/{reservationId}/")
    public Reservation getCustomerReservation(@PathVariable Long customerId, @PathVariable Long reservationId) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            for (Reservation reservation : customer.get().getReservationList()) {
                if (reservation.getId() == reservationId) {
                    return reservation;
                }
            }
        }
    return null;
    }
    @DeleteMapping("/customers/{customerId}/reservations/{reservationId}/")
    public Reservation deleteCustomerReservation(@PathVariable(value = "customerId") Long customerId, @PathVariable(value = "reservationId") Long reservationId){
//        return customerService.deleteCategoryReservation(categoryId, recipeId);

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            for (Reservation reservation : customer.get().getReservationList()) {
                if (reservation.getId() == reservationId) {
                    reservationRepository.deleteById(reservationId);
                    return reservation;
                }
            }
        }
    return null;
    }
    @GetMapping("/customers/{customerId}/reservations/")
    public List<Reservation> getCustomerReservations(@PathVariable(value = "customerId") Long customerId){
//        return customerService.getCategoryRecipes(categoryId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()) {
            return customer.get().getReservationList();
        }
        return null;

    }

    @PutMapping("/customers/{customerId}/reservations/{reservationId}/")
    public Reservation updateCustomerReservation(@PathVariable(value = "customerId") Long customerId,
                                       @PathVariable(value = "reservationId") Long reservationId,
                                       @RequestBody Reservation reservationObject) {

//        return categoryService.updateCategoryRecipe(categoryId, recipeId, recipeObject);
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            for (Reservation reservation : customer.get().getReservationList()) {
                if (reservation.getId() == reservationId) {
                    reservation.setDate(reservationObject.getDate());
                    reservation.setTime(reservationObject.getTime());
                    reservation.setPartyOf(reservationObject.getPartyOf());

                    return reservationRepository.save(reservation);
                }
            }
        }
        return null;
    }
}
