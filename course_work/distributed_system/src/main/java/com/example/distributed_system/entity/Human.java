package com.example.distributed_system.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "real_world_id")
    private RealWorld realWorld;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribution_layer_id")
    private DistributionLayer distributionLayer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hell_id")
    private Hell hell;

    @Column(name = "age")
    private Integer age;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "nationality")
    private String nationality;

    @Column(name = "number_of_good_deeds", nullable = false)
    private Integer numberOfGoodDeeds;

    @Column(name = "number_of_righteous_deeds", nullable = false)
    private Integer numberOfRighteousDeeds;

    @OneToMany(mappedBy = "human")
    private Set<DemonHuman> demonHumen = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RealWorld getRealWorld() {
        return realWorld;
    }

    public void setRealWorld(RealWorld realWorld) {
        this.realWorld = realWorld;
    }

    public DistributionLayer getDistributionLayer() {
        return distributionLayer;
    }

    public void setDistributionLayer(DistributionLayer distributionLayer) {
        this.distributionLayer = distributionLayer;
    }

    public Hell getHell() {
        return hell;
    }

    public void setHell(Hell hell) {
        this.hell = hell;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getNumberOfGoodDeeds() {
        return numberOfGoodDeeds;
    }

    public void setNumberOfGoodDeeds(Integer numberOfGoodDeeds) {
        this.numberOfGoodDeeds = numberOfGoodDeeds;
    }

    public Integer getNumberOfRighteousDeeds() {
        return numberOfRighteousDeeds;
    }

    public void setNumberOfRighteousDeeds(Integer numberOfRighteousDeeds) {
        this.numberOfRighteousDeeds = numberOfRighteousDeeds;
    }

    public Set<DemonHuman> getDemonHumen() {
        return demonHumen;
    }

    public void setDemonHumen(Set<DemonHuman> demonHumen) {
        this.demonHumen = demonHumen;
    }

}