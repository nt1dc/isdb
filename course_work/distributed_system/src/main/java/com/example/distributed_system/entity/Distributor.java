package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity

@Table(name = "distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribution_committee_id")
    private DistributionCommittee distributionCommittee;

    @Column(name = "age")
    private Integer age;

    @Enumerated
    private Mood mood;

    @OneToMany(mappedBy = "distributor")
    private Set<DistributorSkill> distributorSkills = new LinkedHashSet<>();


}