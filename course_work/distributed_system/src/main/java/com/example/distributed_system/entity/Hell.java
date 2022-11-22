package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hell_id_seq"
    )
    @SequenceGenerator(
            name = "hell_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "produced_screams")
    private Long producedScreams;

    @OneToMany(mappedBy = "hell", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Human> humans = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hell", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Demon> demons = new LinkedHashSet<>();

    @OneToOne(mappedBy = "hell")
    private World world;

}