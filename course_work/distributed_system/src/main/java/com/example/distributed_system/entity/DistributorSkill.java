package com.example.distributed_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "distributor_skill")
public class DistributorSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "required_screams")
    private Integer requiredScreams;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequiredScreams() {
        return requiredScreams;
    }

    public void setRequiredScreams(Integer requiredScreams) {
        this.requiredScreams = requiredScreams;
    }

}