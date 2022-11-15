package com.example.distributed_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "distributor_skill")
public class DistributorSkill {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "distributor_skill_id_seq"
    )
    @SequenceGenerator(
            name = "distributor_skill_id_seq",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @Column(name = "name")
    private String name;

    @Column(name = "required_screams")
    private Integer requiredScreams;

}