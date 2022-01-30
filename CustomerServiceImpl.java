package com.seaz.proyectospringboot.service;

import com.seaz.proyectospringboot.entity.Customer;
import com.seaz.proyectospringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void delete(long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer getById(long id) {
        return this.customerRepository.findById(id).get();
    }
}
