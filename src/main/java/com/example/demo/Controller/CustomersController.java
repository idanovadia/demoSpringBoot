package com.example.demo.Controller;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;



@RestController
@RequestMapping("/")
public class CustomersController {

    CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //adding a new customer
    @RequestMapping(value = "/addCustomer",consumes = "application/json", method = POST)
    @ResponseBody
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(this.customerService.addCustomers(customer), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>("An error has occurred", HttpStatus.BAD_REQUEST);
        }
    }

    //return all the customers
    @RequestMapping(value = "/customers",produces = "application/json; charset=UTF-8", method = GET)
    @ResponseBody
    public ResponseEntity<?> getCustomers() {
        try {
            return new ResponseEntity<>(this.customerService.findAllCustomers(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("An error has occurred",HttpStatus.BAD_REQUEST);
        }
    }

    //update a customer
    @RequestMapping(value = "/updateCustomer",consumes = "application/json", method = PUT)
    @ResponseBody
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(this.customerService.updateCustomers(customer), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("An error has occurred", HttpStatus.BAD_REQUEST);
        }
    }

    //delete a customer
    @RequestMapping(value = "/deleteCustomer",consumes = "application/json", method = DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer) {
        try {
            this.customerService.deleteCustomers(customer);
            return new ResponseEntity<>("customer deleted", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("An error has occurred", HttpStatus.BAD_REQUEST);
        }
    }
}
