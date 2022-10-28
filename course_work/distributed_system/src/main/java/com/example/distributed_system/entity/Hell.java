package com.example.distributed_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hell")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getProducedScreams() {
        return producedScreams;
    }

    public void setProducedScreams(BigDecimal producedScreams) {
        this.producedScreams = producedScreams;
    }

    public Set<Human> getHumans() {
        return humans;
    }

    public void setHumans(Set<Human> humans) {
        this.humans = humans;
    }

    public Set<Demon> getDemons() {
        return demons;
    }

    public void setDemons(Set<Demon> demons) {
        this.demons = demons;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}