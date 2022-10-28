package com.example.distributed_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "distribution_committee")
public class DistributionCommittee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribution_layer_id")
    private DistributionLayer distributionLayer;

    @Column(name = "estimation_error")
    private BigDecimal estimationError;

    @OneToMany(mappedBy = "distributionCommittee")
    private Set<Distributor> distributors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DistributionLayer getDistributionLayer() {
        return distributionLayer;
    }

    public void setDistributionLayer(DistributionLayer distributionLayer) {
        this.distributionLayer = distributionLayer;
    }

    public BigDecimal getEstimationError() {
        return estimationError;
    }

    public void setEstimationError(BigDecimal estimationError) {
        this.estimationError = estimationError;
    }

    public Set<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(Set<Distributor> distributors) {
        this.distributors = distributors;
    }

}