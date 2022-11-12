package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "distributor_skill")
public class DistributorSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @Column(name = "name")
    private String name;

    @Column(name = "required_screams")
    private Integer requiredScreams;


}