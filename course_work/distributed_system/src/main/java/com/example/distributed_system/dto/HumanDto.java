package com.example.distributed_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.distributed_system.entity.Human} entity
 */
@Data
@NoArgsConstructor
public class HumanDto implements Serializable {
    private  Integer age;
    private String name;
    private String lastName;
    private String nationality;
    private Integer numberOfGoodDeeds;
    private Integer numberOfRighteousDeeds;
}