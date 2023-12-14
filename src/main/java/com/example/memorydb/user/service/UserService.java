package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> findGreaterThanScore(int score) {
        return userRepository.findAllByScoreGreaterThanEqual(score);

    }

    public List<UserEntity> findScoreMinMax(int min, int max) {
        return userRepository.findScoreMinMax(min, max);
    }




}
