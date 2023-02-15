package com.alterra.cleanarchitecturetask.services;

import com.alterra.cleanarchitecturetask.entities.UserEntity;
import com.alterra.cleanarchitecturetask.services.in.CreateUserUseCase;
import com.alterra.cleanarchitecturetask.services.out.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;


    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return createUserPort.createUser(userEntity);
    }
}
