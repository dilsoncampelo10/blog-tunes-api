package com.dilson.blogtunesapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilson.blogtunesapi.models.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
