package com.seaz.proyectospringboot.repository;

import com.seaz.proyectospringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
