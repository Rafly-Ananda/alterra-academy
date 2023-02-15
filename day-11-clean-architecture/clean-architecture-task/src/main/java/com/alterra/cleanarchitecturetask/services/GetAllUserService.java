package com.alterra.cleanarchitecturetask.services;

import com.alterra.cleanarchitecturetask.entities.UserEntity;
import com.alterra.cleanarchitecturetask.services.in.GetAllUserUseCase;
import com.alterra.cleanarchitecturetask.services.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {
    private final GetAllUserPort getAllUserPort;

    @Override
    public List<UserEntity> getAllUser() {
        return getAllUserPort.getAllUser();
    }
}
