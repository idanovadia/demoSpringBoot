package com.example.demo.Service;


import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /*CRUD*/

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer addCustomers(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomers(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomers(Customer customer){
        customerRepository.delete(customer);
    }


}
