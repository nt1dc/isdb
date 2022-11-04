package com.example.distributed_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "world")
public class World {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "real_world_id", nullable = false)
    private RealWorld realWorld;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hell_id", nullable = false)
    private Hell hell;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "distribution_layer_id", nullable = false)
    private DistributionLayer distributionLayer;

    @Column(name = "year", nullable = false)
    private Integer year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealWorld getRealWorld() {
        return realWorld;
    }

    public void setRealWorld(RealWorld realWorld) {
        this.realWorld = realWorld;
    }

    public Hell getHell() {
        return hell;
    }

    public void setHell(Hell hell) {
        this.hell = hell;
    }

    public DistributionLayer getDistributionLayer() {
        return distributionLayer;
    }

    public void setDistributionLayer(DistributionLayer distributionLayer) {
        this.distributionLayer = distributionLayer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}