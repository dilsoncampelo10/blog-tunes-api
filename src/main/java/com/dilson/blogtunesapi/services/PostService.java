package com.dilson.blogtunesapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dilson.blogtunesapi.models.Post;
import com.dilson.blogtunesapi.repositories.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    public Post findById(UUID id) {
        Optional<Post> post = this.postRepository.findById(id);

        return post.orElseThrow(() -> new RuntimeException("post not found"));
    }

    @Transactional
    public Post create(Post post) {
        post.setId(null);
        return this.postRepository.save(post);
    }

    @Transactional
    public Post update(Post post) {
        return this.postRepository.save(post);
    }

    public void delete(UUID id) {
        this.postRepository.deleteById(id);
    }

}
