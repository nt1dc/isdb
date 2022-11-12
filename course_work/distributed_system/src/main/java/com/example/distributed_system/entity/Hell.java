package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hell")
@Getter
@Setter
public class Hell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "produced_screams")
    private BigDecimal producedScreams;

    @OneToMany(mappedBy = "hell")
    private Set<Human> humans = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hell")
    private Set<Demon> demons = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "hell")
    private World world;


}