package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "real_world")
public class RealWorld {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "real_world_id_seq"
    )
    @SequenceGenerator(
            name = "real_world_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "realWorld")
    private Set<Human> humans = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "realWorld")
    private World world;


}