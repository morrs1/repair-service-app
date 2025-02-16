package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.Post;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.PostsRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostsService {

    private final PostsRepo postsRepo;

    public List<Post> readAll() {
        return postsRepo.findAll();
    }

    public Post read(UUID id) {
        return postsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no post with this id"));
    }

    @Transactional
    public Post create(Post post) {
        post.setId(UUID.randomUUID());
        return postsRepo.save(post);
    }

    @Transactional
    public Post update(UUID id, Post post) {
        postsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no post with this id"));
        post.setId(id);
        return postsRepo.save(post);
    }

    @Transactional
    public Post delete(UUID id) {
        Post oldPost = postsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no post with this id"));
        postsRepo.delete(oldPost);
        return oldPost;
    }
}
