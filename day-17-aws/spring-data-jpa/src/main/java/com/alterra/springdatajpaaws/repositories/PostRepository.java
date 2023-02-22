package com.alterra.springdatajpaaws.repositories;

import com.alterra.springdatajpaaws.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
}
