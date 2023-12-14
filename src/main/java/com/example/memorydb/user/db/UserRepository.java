package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    @Query(
            value = "select * from user as u where u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> findScoreMinMax(
            @Param(value = "min") int min,
            @Param(value = "max") int max);
}
