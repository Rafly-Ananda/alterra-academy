package com.alterra.springsecurityjwt.repositories;

import com.alterra.springsecurityjwt.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

    Optional<UserEntity> findByPhone(String phone);

}
