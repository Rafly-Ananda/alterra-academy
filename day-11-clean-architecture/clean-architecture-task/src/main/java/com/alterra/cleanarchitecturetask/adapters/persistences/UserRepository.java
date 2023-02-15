package com.alterra.cleanarchitecturetask.adapters.persistences;

import com.alterra.cleanarchitecturetask.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
