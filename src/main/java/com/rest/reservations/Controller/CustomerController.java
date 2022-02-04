package com.rest.reservations.Controller;

import com.rest.reservations.model.Customer;
import com.rest.reservations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private CustomerRepository customerRepository;
    

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/")
    public String getCustomers() {
        return "get all customers";
    }

    @GetMapping(path = "/customers/{customerID}")
    public String getCustomer(@PathVariable Long customerID) {
        return "getting the customer with the id of " + customerID;
    }

    @PostMapping("/customers/")
    public Customer createCustomer(@RequestBody Customer body) {
        return customerRepository.save(body);
    }

    @PutMapping("/customers/{customerID}")
    public String updateCustomer(@PathVariable(value = "customerID") Long customerID, @RequestBody String body) {
        return "updating the customer with the id of " + customerID + body;
    }

    @DeleteMapping("/customers/{customerID}")
    public String deleteCustomer(@PathVariable(value = "customerID") Long customerID) {
        return "deleting the customer with the id of " + customerID;
    }
}