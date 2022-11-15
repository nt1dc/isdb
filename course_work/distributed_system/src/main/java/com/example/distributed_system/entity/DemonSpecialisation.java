package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "power")
    private Long power;

    @ManyToMany(mappedBy = "demonDemonSpecialisations")
    private Set<Demon> demons = new LinkedHashSet<>();

    public DemonSpecialisation(String name, Long power) {
        this.name = name;
        this.power = power;
    }
}