package com.example.distributed_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "demon")
public class Demon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hell_id")
    private Hell hell;

    @Column(name = "ages_left_in_hell")
    private BigDecimal agesLeftInHell;

    @OneToMany(mappedBy = "demon")
    private Set<DemonHuman> demonHumen = new LinkedHashSet<>();

    @OneToMany(mappedBy = "demon")
    private Set<DemonDemonSpecialisation> demonDemonSpecialisations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hell getHell() {
        return hell;
    }

    public void setHell(Hell hell) {
        this.hell = hell;
    }

    public BigDecimal getAgesLeftInHell() {
        return agesLeftInHell;
    }

    public void setAgesLeftInHell(BigDecimal agesLeftInHell) {
        this.agesLeftInHell = agesLeftInHell;
    }

    public Set<DemonHuman> getDemonHumen() {
        return demonHumen;
    }

    public void setDemonHumen(Set<DemonHuman> demonHumen) {
        this.demonHumen = demonHumen;
    }

    public Set<DemonDemonSpecialisation> getDemonDemonSpecialisations() {
        return demonDemonSpecialisations;
    }

    public void setDemonDemonSpecialisations(Set<DemonDemonSpecialisation> demonDemonSpecialisations) {
        this.demonDemonSpecialisations = demonDemonSpecialisations;
    }

}