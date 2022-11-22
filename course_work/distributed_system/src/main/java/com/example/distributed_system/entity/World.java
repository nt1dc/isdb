package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "world")
public class World {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "world_id_seq"
    )
    @SequenceGenerator(
            name = "world_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(optional = false)
    @JoinColumn(name = "real_world_id", nullable = false)
    private RealWorld realWorld;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "hell_id", nullable = false)
    private Hell hell;

    @OneToOne(optional = false)
    @JoinColumn(name = "distribution_layer_id", nullable = false)
    private DistributionLayer distributionLayer;

    @Column(name = "year", nullable = false)
    private Integer year;
}