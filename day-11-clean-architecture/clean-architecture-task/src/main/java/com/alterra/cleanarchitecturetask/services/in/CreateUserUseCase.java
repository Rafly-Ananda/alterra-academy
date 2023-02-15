package com.alterra.cleanarchitecturetask.services.in;

import com.alterra.cleanarchitecturetask.entities.UserEntity;

public interface CreateUserUseCase {
    UserEntity createUser(UserEntity userEntity);
}
