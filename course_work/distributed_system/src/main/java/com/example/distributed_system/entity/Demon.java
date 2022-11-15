package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "demon")
public class Demon {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "demon_id_seq"
    )
    @SequenceGenerator(
            name = "demon_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hell_id")
    private Hell hell;

    @Column(name = "ages_left_in_hell")
    private Integer agesLeftInHell;

    @ManyToMany(mappedBy = "demonHumen")
    private Set<Human> demonHumen = new LinkedHashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "demon_demon_specialisation",
            joinColumns = @JoinColumn(name = "demon_id"),
            inverseJoinColumns = @JoinColumn(name = "demon_specialisation"))
    private Set<DemonSpecialisation> demonDemonSpecialisations = new LinkedHashSet<>();

    public Demon(Integer agesLeftInHell, Set<DemonSpecialisation> demonDemonSpecialisations) {
        this.agesLeftInHell = agesLeftInHell;
        this.demonDemonSpecialisations = demonDemonSpecialisations;
    }
}