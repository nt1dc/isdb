package com.example.distributed_system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
public class HellDto {
    private BigDecimal producedScreams;
    private Set<HumanDto> humans;
    private Set<DemonDto> demons;
}
