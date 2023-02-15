package com.alterra.cleanarchitecturetask.adapters.persistences;

import com.alterra.cleanarchitecturetask.entities.UserEntity;
import com.alterra.cleanarchitecturetask.services.out.CreateUserPort;
import com.alterra.cleanarchitecturetask.services.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPersistence implements GetAllUserPort, CreateUserPort {
    private final UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
