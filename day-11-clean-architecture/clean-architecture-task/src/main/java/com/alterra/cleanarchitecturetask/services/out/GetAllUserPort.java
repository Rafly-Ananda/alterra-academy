package com.alterra.cleanarchitecturetask.services.out;

import com.alterra.cleanarchitecturetask.entities.UserEntity;

import java.util.List;

public interface GetAllUserPort {
    List<UserEntity> getAllUser();
}
