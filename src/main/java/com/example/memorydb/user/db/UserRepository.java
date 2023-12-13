package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    @Override
    public List<UserEntity> findGreaterThanScore(int score) {
        List<UserEntity> dataList = findAll();

        return dataList.stream().filter(
                userEntity -> userEntity.getScore() >= score
        ).collect(Collectors.toList());
    }
}
