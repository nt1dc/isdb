package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "real_world_id")
    private RealWorld realWorld;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribution_layer_id")
    private DistributionLayer distributionLayer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hell_id")
    private Hell hell;

    @Column(name = "age")
    private Integer age;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "nationality")
    private String nationality;

    @Column(name = "number_of_good_deeds", nullable = false)
    private Integer numberOfGoodDeeds;

    @Column(name = "number_of_righteous_deeds", nullable = false)
    private Integer numberOfRighteousDeeds;

    @OneToMany(mappedBy = "human")
    private Set<DemonHuman> demonHumen = new LinkedHashSet<>();
    @Enumerated
    private Sex sex;

}