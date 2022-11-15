package com.example.distributed_system.dto;

import com.example.distributed_system.entity.DistributionCommittee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class DistributionLayerDto {
    private Integer screamsCount;
    private Set<HumanDto> humans;
    private Set<DistributionCommittee> distributionCommittees;
}
