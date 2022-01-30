package com.seaz.proyectospringboot.service;

import com.seaz.proyectospringboot.entity.Customer;
import com.seaz.proyectospringboot.entity.User;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> getAll();
     void delete(long id);
     Customer getById(long id);
}
