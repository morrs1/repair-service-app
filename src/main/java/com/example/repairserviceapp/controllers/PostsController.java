package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.post.PostDTORequest;
import com.example.repairserviceapp.DTOs.post.PostDTOResponse;
import com.example.repairserviceapp.mappers.PostsMapper;
import com.example.repairserviceapp.services.PostsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/post")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostsController extends BaseController {

    private PostsService postsService;
    private PostsMapper postsMapper;

    @GetMapping("")
    public List<PostDTOResponse> readAll() {
        return postsService.readAll().stream().map(post -> postsMapper.toDTO(post)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostDTOResponse read(@PathVariable UUID id) {
        return postsMapper.toDTO(postsService.read(id));
    }

    @PostMapping("")
    public PostDTOResponse create(@RequestBody @Valid PostDTORequest postDTORequest, BindingResult bindingResult) {
        validate(bindingResult, "Create post failed");
        log.info("Create post: {}", postDTORequest);
        var post = postsMapper.toPost(postDTORequest);
        log.info("Create post: {}", post.getPostName());
        return postsMapper.toDTO(postsService.create(post));
    }

    @PatchMapping("/{id}")
    public PostDTOResponse update(@PathVariable UUID id, @RequestBody @Valid PostDTORequest postDTO, BindingResult bindingResult) {
        validate(bindingResult, "Update post failed");
        return postsMapper.toDTO(postsService.update(id, postsMapper.toPost(postDTO)));
    }

    @DeleteMapping("/{id}")
    public PostDTOResponse delete(@PathVariable UUID id) {
        return postsMapper.toDTO(postsService.delete(id));
    }

}
