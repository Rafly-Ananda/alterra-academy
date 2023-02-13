package com.alterra.springdatajpa.repositories;

import com.alterra.springdatajpa.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
}
