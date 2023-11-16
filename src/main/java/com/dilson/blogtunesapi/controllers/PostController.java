package com.dilson.blogtunesapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilson.blogtunesapi.models.Post;
import com.dilson.blogtunesapi.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = this.postService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable UUID id) {
        Post post = this.postService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        Post newPost = this.postService.create(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody Post post, @PathVariable UUID id) {
        post.setId(id);
        this.postService.update(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
