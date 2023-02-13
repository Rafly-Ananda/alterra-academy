package com.alterra.springdatajpa.repositories;

import com.alterra.springdatajpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
