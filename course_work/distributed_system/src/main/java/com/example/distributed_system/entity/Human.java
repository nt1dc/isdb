package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "human")
@NoArgsConstructor
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
    private Integer numberOfGoodDeeds = 0;

    @Column(name = "number_of_righteous_deeds", nullable = false)
    private Integer numberOfRighteousDeeds = 0;

    @ManyToMany()
    @JoinTable(
            name = "demon_human",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "demon_id"))
    private Set<Demon> demonHumen = new LinkedHashSet<>();
    @Enumerated
    private Sex sex;

    public Human(Integer age, String name, String lastName, String nationality, Sex sex, RealWorld realWorld) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
        this.nationality = nationality;
        this.sex = sex;
        this.realWorld = realWorld;
    }
}