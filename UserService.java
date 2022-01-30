package com.seaz.proyectospringboot.service;

import com.seaz.proyectospringboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
