package com.alterra.springdatajpa.services;

import com.alterra.springdatajpa.entities.UserEntity;
import com.alterra.springdatajpa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getSingleUser(Integer id) {
        return userRepository.findById(id);
    }

    public UserEntity updateUser(UserEntity userEntity, Integer id) {
        UserEntity selectedUser = userRepository.findById(id).orElseThrow();
        selectedUser.setName(userEntity.getName());
        selectedUser.setEmail(userEntity.getEmail());
        selectedUser.setAge(userEntity.getAge());
        return userRepository.save(selectedUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
