package com.example.memorydb.user.model;

import com.example.memorydb.entity.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@jakarta.persistence.Entity(name = "user")
public class UserEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer score;

}
