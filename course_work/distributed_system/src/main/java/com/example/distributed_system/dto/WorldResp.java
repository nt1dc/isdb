package com.example.distributed_system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.distributed_system.entity.World} entity
 */
@Data
@NoArgsConstructor
public class WorldResp implements Serializable {
    private String name;
    private Integer year;
    private RealWorldDto realWorld;
    private DistributionLayerDto distributionLayer;
    private HellDto hell;
}