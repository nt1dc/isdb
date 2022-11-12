package com.example.distributed_system.dto;

import com.example.distributed_system.entity.Demon;
import com.example.distributed_system.entity.Human;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class HellDto {
    private BigDecimal producedScreams;

    private Set<HumanDto> humans;
    private Set<DemonDto> demons;
}
