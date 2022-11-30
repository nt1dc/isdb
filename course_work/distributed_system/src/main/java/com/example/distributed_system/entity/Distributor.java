package com.example.distributed_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "distributor_id_seq"
    )
    @SequenceGenerator(
            name = "distributor_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "distribution_committee_id")
    private DistributionCommittee distributionCommittee;

    @Column(name = "age")
    private Integer age;

    @Enumerated
    private Mood mood;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "distributor_id")
    private Set<DistributorSkill> distributorSkills = new LinkedHashSet<>();

}