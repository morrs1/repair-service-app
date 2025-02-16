package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.MasterDTO;
import com.example.repairserviceapp.entities.Master;
import com.example.repairserviceapp.services.PostsService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class MasterMapper {

    @Setter(onMethod = @__(@Autowired))
    protected PostsService postsService;

    @Mapping(target = "post", expression = "java(postsService.read(masterDTO.postId()))")
    public abstract Master toMaster(MasterDTO masterDTO);

    @Mapping(target = "postId", expression = "java(master.getPost().getId())")
    public abstract MasterDTO toMasterDTO(Master master);
}

