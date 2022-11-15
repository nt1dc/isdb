package com.example.distributed_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "distribution_committee")
public class DistributionCommittee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "distribution_committee_id_seq"
    )
    @SequenceGenerator(
            name = "distribution_committee_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "distribution_layer_id")
    private DistributionLayer distributionLayer;

    @Column(name = "estimation_error")
    private BigDecimal estimationError;

    @OneToMany(mappedBy = "distributionCommittee")
    private Set<Distributor> distributors = new LinkedHashSet<>();

}