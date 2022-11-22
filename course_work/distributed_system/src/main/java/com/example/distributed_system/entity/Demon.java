package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "demon")
public class Demon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demon_id_seq")
    @SequenceGenerator(name = "demon_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "hell_id")
    private Hell hell;

    @Column(name = "ages_left_in_hell")
    private Integer agesLeftInHell;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "demon_human", joinColumns = @JoinColumn(name = "demon_id"), inverseJoinColumns = @JoinColumn(name = "human_id"))
    private Set<Human> demonHumen = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "demon_demon_specialisation", joinColumns = @JoinColumn(name = "demon_id"), inverseJoinColumns = @JoinColumn(name = "demon_specialisation"))
    private Set<DemonSpecialisation> demonDemonSpecialisations = new LinkedHashSet<>();

    public Demon(Integer agesLeftInHell, Set<DemonSpecialisation> demonDemonSpecialisations, Hell hell) {
        this.agesLeftInHell = agesLeftInHell;
        this.demonDemonSpecialisations = demonDemonSpecialisations;
        this.hell = hell;
    }

    public Demon(Integer id, Hell hell, Integer agesLeftInHell, Set<Human> demonHumen, Set<DemonSpecialisation> demonDemonSpecialisations) {
        this.id = id;
        this.hell = hell;
        this.agesLeftInHell = agesLeftInHell;
        this.demonHumen = demonHumen;
        this.demonDemonSpecialisations = demonDemonSpecialisations;
    }

    public void clearRelations() {
        setDemonHumen(new HashSet<>());
        setDemonHumen(new HashSet<>());
    }
}