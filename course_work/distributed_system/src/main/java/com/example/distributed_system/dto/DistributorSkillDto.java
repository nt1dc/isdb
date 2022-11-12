package com.example.distributed_system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class DistributorSkillDto {
    private String name;
    private Integer requiredScreams;
}
