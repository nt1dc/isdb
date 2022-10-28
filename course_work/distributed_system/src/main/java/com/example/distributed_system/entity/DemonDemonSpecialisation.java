package com.example.distributed_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "demon_demon_specialisation")
public class DemonDemonSpecialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demon_specialisation")
    private DemonSpecialisation demonSpecialisation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demon_id")
    private Demon demon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DemonSpecialisation getDemonSpecialisation() {
        return demonSpecialisation;
    }

    public void setDemonSpecialisation(DemonSpecialisation demonSpecialisation) {
        this.demonSpecialisation = demonSpecialisation;
    }

    public Demon getDemon() {
        return demon;
    }

    public void setDemon(Demon demon) {
        this.demon = demon;
    }

}