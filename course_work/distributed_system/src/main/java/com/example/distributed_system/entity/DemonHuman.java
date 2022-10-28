package com.example.distributed_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "demon_human")
public class DemonHuman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id")
    private Human human;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demon_id")
    private Demon demon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Demon getDemon() {
        return demon;
    }

    public void setDemon(Demon demon) {
        this.demon = demon;
    }

}