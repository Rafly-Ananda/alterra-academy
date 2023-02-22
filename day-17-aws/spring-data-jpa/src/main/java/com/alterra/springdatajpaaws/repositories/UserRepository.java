package com.alterra.springdatajpaaws.repositories;

import com.alterra.springdatajpaaws.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
