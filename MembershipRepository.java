package com.seaz.proyectospringboot.repository;

import com.seaz.proyectospringboot.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership,Long> {
    @Query("select m from Membership m where m.customer.id=?1")
    List<Membership> getMemberships(Long idcustomer);
}
