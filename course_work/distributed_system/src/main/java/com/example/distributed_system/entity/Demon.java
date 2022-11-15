package com.example.distributed_system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "demon")
public class Demon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hell_id")
    private Hell hell;

    @Column(name = "ages_left_in_hell")
    private BigDecimal agesLeftInHell;

    @OneToMany(mappedBy = "demon")
    private Set<DemonHuman> demonHumen = new LinkedHashSet<>();

    @OneToMany(mappedBy = "demon")
    private Set<DemonDemonSpecialisation> demonDemonSpecialisations = new LinkedHashSet<>();

}