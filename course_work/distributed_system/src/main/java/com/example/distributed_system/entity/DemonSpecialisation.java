package com.example.distributed_system.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "demon_specialisation")
public class DemonSpecialisation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "demon_specialisation_id_seq"
    )
    @SequenceGenerator(
            name = "demon_specialisation_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "power")
    private Integer power;

    @ManyToMany(mappedBy = "demonDemonSpecialisations")
    private Set<Demon> demons = new LinkedHashSet<>();

    public DemonSpecialisation(Integer id, String name, Integer power, Set<Demon> demons) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.demons = demons;
    }

    public DemonSpecialisation(String name, Integer power) {
        this.name = name;
        this.power = power;
    }
}