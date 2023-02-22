package com.alterra.springdatajpaaws.services;

import com.alterra.springdatajpaaws.entities.PostEntity;
import com.alterra.springdatajpaaws.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostEntity createPost(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }

    public Optional<PostEntity> getSinglePost(Integer id) {
        return postRepository.findById(id);
    }

    public PostEntity updatePost(PostEntity postEntity, Integer id) {
        PostEntity selectedPost = postRepository.findById(id).orElseThrow();
        selectedPost.setTitle(postEntity.getTitle());
        selectedPost.setBody(postEntity.getBody());
        selectedPost.setLikes(postEntity.getLikes());
        return postRepository.save(selectedPost);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
