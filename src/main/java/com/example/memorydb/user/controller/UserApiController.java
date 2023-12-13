package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity) {

        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne(@PathVariable Long id) {
        UserEntity findEntity = userService.findById(id).get();
        return findEntity;
    }

    @GetMapping("/all")
    public List<UserEntity> findOne(@RequestParam Integer score) {
        return userService.findGreaterThanScore(score);
    }


}
