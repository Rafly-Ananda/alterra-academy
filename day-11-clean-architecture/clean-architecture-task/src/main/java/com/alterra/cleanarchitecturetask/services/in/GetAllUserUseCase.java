package com.alterra.cleanarchitecturetask.services.in;

import com.alterra.cleanarchitecturetask.entities.UserEntity;

import java.util.List;

public interface GetAllUserUseCase {
    List<UserEntity> getAllUser();
}
