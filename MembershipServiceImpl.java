package com.seaz.proyectospringboot.service;

import com.seaz.proyectospringboot.entity.Membership;
import com.seaz.proyectospringboot.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("membershipService")
public class MembershipServiceImpl implements MembershipService{

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public List<Membership> getMemberships(Long idcustomer) {
        return this.membershipRepository.getMemberships(idcustomer);
    }

    @Override
    public void save(Membership membership) {
       this.membershipRepository.save(membership);
    }
}
