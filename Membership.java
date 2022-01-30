package com.seaz.proyectospringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "membership")
@Getter
@Setter
public class Membership {
    @Id
    @Column(name = "id_menbership", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer dayspaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id", nullable=true)
    private Customer customer;
}
