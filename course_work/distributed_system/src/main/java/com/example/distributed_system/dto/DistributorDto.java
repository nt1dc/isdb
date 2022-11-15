package com.example.distributed_system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class DistributorDto {
    private Set<DistributorSkillDto> distributorSkills;
}
