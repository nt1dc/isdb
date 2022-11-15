package com.example.distributed_system.dto;

import com.example.distributed_system.entity.Distributor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class DistributionCommitteeDto {
    private BigDecimal estimationError;
    private Set<Distributor> distributors;
}
