package com.example.distributed_system.dto;

import com.example.distributed_system.dto.HumanDto;
import com.example.distributed_system.entity.RealWorld;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link RealWorld} entity
 */
@Data
@NoArgsConstructor
public class RealWorldDto implements Serializable {
    private  Set<HumanDto> humans;
}