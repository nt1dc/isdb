package com.example.distributed_system.dto;

import com.example.distributed_system.entity.DistributorSkill;
import com.example.distributed_system.entity.Mood;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;
import java.util.Set;

@Data
@NoArgsConstructor
public class DistributorDto {
    private Integer age;
    private Mood mood;
    private Set<DistributorSkillDto> distributorSkills;
}
