package com.example.distributed_system.dto;

import com.example.distributed_system.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link com.example.distributed_system.entity.Human} entity
 */
@Data
@NoArgsConstructor
public class HumanDto implements Serializable {

    private String name;

    private String lastName;

    private Integer age;

    private Sex sex;

    private String nationality;

    private Integer numberOfGoodDeeds = 0;

    private Integer numberOfRighteousDeeds = 0;
}