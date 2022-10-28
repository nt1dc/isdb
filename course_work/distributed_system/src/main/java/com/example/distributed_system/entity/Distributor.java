package com.example.distributed_system.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribution_committee_id")
    private DistributionCommittee distributionCommittee;

    @Column(name = "age")
    private Integer age;

    @Column(name = "mood")
    private Integer mood;

    @OneToMany(mappedBy = "distributor")
    private Set<DistributorSkill> distributorSkills = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DistributionCommittee getDistributionCommittee() {
        return distributionCommittee;
    }

    public void setDistributionCommittee(DistributionCommittee distributionCommittee) {
        this.distributionCommittee = distributionCommittee;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    public Set<DistributorSkill> getDistributorSkills() {
        return distributorSkills;
    }

    public void setDistributorSkills(Set<DistributorSkill> distributorSkills) {
        this.distributorSkills = distributorSkills;
    }

}