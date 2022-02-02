package com.rest.reservations.Controller;

        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    @GetMapping(path = "/customer/")
    public String getCustomer() {
        return "get all customer";
    }

    @GetMapping(path = "/customer/{customerId}")
    public String getCustomer(@PathVariable Long customerId) {
        return "getting the customer with the id of " + customerId;
    }

    @PostMapping("/customer/")
    public String createCustomer(@RequestBody String body) {
        return "creating a customer " + body;
    }

    @PutMapping("/categories/{categoryId}")
    public String updateCustomer(@PathVariable(value = "categoryId") Long categoryId, @RequestBody String body) {
        return "updating the category with the id of " + categoryId + body;
    }

    @DeleteMapping("/categories/{categoryId}")
    public String deleteCustomer(@PathVariable(value = "categoryId") Long categoryId) {
        return "deleting the category with the id of " + categoryId;
    }
}