package com.rest.reservations.Controller;

import com.rest.reservations.model.Customer;
import com.rest.reservations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private CustomerRepository customerRepository;


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
        customer.setLastName(body.getLastName());
        return customerRepository.save(customer);
    }

    @DeleteMapping("/customers/{customerID}")
    public String deleteCustomer(@PathVariable(value = "customerID") Long customerID) {
        customerRepository.deleteById(customerID);
        return "deleting the customer with the id of " + customerID;
    }
}