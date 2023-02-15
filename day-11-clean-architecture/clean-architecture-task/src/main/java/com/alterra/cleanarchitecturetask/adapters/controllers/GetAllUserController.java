package com.alterra.cleanarchitecturetask.adapters.controllers;

import com.alterra.cleanarchitecturetask.entities.UserEntity;
import com.alterra.cleanarchitecturetask.services.in.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class GetAllUserController {
    private final GetAllUserUseCase getAllUserUseCase;

    @GetMapping
    public List<UserEntity> getAllUser() {
        return getAllUserUseCase.getAllUser();
    }

}
