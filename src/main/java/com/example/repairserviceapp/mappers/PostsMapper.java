package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.post.PostDTORequest;
import com.example.repairserviceapp.DTOs.post.PostDTOResponse;
import com.example.repairserviceapp.entities.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostsMapper {

    PostDTOResponse toDTO(Post post);

    Post toPost(PostDTORequest postDTORequest);
}
