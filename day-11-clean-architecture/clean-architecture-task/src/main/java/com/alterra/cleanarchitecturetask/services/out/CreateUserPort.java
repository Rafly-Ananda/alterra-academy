package com.alterra.cleanarchitecturetask.services.out;

import com.alterra.cleanarchitecturetask.entities.UserEntity;

public interface CreateUserPort {
    UserEntity createUser(UserEntity userEntity);
}
