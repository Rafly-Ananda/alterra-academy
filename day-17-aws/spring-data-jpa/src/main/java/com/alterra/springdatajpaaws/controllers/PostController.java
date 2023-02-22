package com.alterra.springdatajpaaws.controllers;


import com.alterra.springdatajpaaws.entities.PostEntity;
import com.alterra.springdatajpaaws.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostEntity createPost(@RequestBody PostEntity postEntity) {
        return postService.createPost(postEntity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostEntity> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PostEntity> getSinglePost(@PathVariable Integer id) {
        return postService.getSinglePost(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PostEntity updatePost(@RequestBody PostEntity postEntity, @PathVariable Integer id) {
        return postService.updatePost(postEntity, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return "Post deleted.";
    }
}
