package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity) {

        return userService.save(userEntity);
    }

    @GetMapping("")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
    public UserEntity findOne(@PathVariable Long id) {
        UserEntity findEntity = userService.findById(id).get();
        return findEntity;
    }

    @GetMapping("/score")
    public List<UserEntity> findScore(@RequestParam Integer score) {
        return userService.findGreaterThanScore(score);
    }

    @GetMapping("/minmax")
    public List<UserEntity> findMinMax(@RequestParam Integer min, @RequestParam Integer max) {
        return userService.findScoreMinMax(min, max);
    }


}
