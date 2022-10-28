package com.example.distributed_system.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "distribution_layer")
public class DistributionLayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "screams_count")
    private Integer screamsCount;

    @OneToMany(mappedBy = "distributionLayer")
    private Set<Human> humans = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "distributionLayer")
    private World world;

    @OneToMany(mappedBy = "distributionLayer")
    private Set<DistributionCommittee> distributionCommittees = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScreamsCount() {
        return screamsCount;
    }

    public void setScreamsCount(Integer screamsCount) {
        this.screamsCount = screamsCount;
    }

    public Set<Human> getHumans() {
        return humans;
    }

    public void setHumans(Set<Human> humans) {
        this.humans = humans;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Set<DistributionCommittee> getDistributionCommittees() {
        return distributionCommittees;
    }

    public void setDistributionCommittees(Set<DistributionCommittee> distributionCommittees) {
        this.distributionCommittees = distributionCommittees;
    }

}