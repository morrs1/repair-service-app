package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.MasterDTO;
import com.example.repairserviceapp.entities.Master;
import com.example.repairserviceapp.exceptions.ValidationException;
import com.example.repairserviceapp.mappers.MasterMapper;
import com.example.repairserviceapp.services.MastersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/master")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MastersController extends BaseController {

    private final MastersService mastersService;
    private final MasterMapper masterMapper;

    @GetMapping("")
    public List<MasterDTO> readAll() {
        return mastersService.readAll().stream().map(masterMapper::toMasterDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MasterDTO read(@PathVariable UUID id) {
        return masterMapper.toMasterDTO(mastersService.read(id));
    }

    @PostMapping("")
    public MasterDTO create(@RequestBody @Valid MasterDTO masterDTO, BindingResult bindingResult) {
        validate(bindingResult, "Create master failed");
        Master master = masterMapper.toMaster(masterDTO);
        return masterMapper.toMasterDTO(mastersService.create(master));
    }

    @PatchMapping("/{id}")
    public MasterDTO update(@PathVariable UUID id, @RequestBody @Valid MasterDTO masterDTO, BindingResult bindingResult) {
        validate(bindingResult, "Update master failed");
        return masterMapper.toMasterDTO(mastersService.update(id, masterMapper.toMaster(masterDTO)));
    }

    @DeleteMapping("/{id}")
    public MasterDTO delete(@PathVariable UUID id) {
        return masterMapper.toMasterDTO(mastersService.delete(id));
    }

}
