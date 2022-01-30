package com.seaz.proyectospringboot.service;

import com.seaz.proyectospringboot.entity.Membership;

import java.util.List;

public interface MembershipService {
    List<Membership> getMemberships(Long idcustomer);
    void save(Membership membership);
}
