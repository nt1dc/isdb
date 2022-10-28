package com.example.distributed_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "demon_specialisation")
public class DemonSpecialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "power")
    private BigDecimal power;

    @OneToMany(mappedBy = "demonSpecialisation")
    private Set<DemonDemonSpecialisation> demonDemonSpecialisations = new LinkedHashSet<>();

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

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public Set<DemonDemonSpecialisation> getDemonDemonSpecialisations() {
        return demonDemonSpecialisations;
    }

    public void setDemonDemonSpecialisations(Set<DemonDemonSpecialisation> demonDemonSpecialisations) {
        this.demonDemonSpecialisations = demonDemonSpecialisations;
    }

}