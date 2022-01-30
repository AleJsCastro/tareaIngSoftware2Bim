package com.seaz.proyectospringboot.repository;

import com.seaz.proyectospringboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
