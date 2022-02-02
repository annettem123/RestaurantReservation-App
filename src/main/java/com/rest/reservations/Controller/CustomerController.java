package com.rest.reservations.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    @GetMapping(path = "/customers/")
    public String getCustomers() {
        return "get all customers";
    }

    @GetMapping(path = "/customers/{customerID}")
    public String getCustomer(@PathVariable Long customerID) {
        return "getting the customer with the id of " + customerID;
    }

    @PostMapping("/customers/")
    public String createCustomer(@RequestBody String body) {
        return "creating a customer " + body;
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