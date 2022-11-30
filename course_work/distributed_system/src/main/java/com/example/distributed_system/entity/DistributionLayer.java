package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "distribution_layer")
public class DistributionLayer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "distribution_layer_id_seq"
    )
    @SequenceGenerator(
            name = "distribution_layer_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "screams_count")
    private Integer screamsCount;

    @OneToMany(mappedBy = "distributionLayer")
    private Set<Human> humans = new LinkedHashSet<>();

    @OneToOne(mappedBy = "distributionLayer")
    private World world;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "distribution_layer_id")
    private Set<DistributionCommittee> distributionCommittees = new LinkedHashSet<>();

}