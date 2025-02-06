package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.MasterDTO;
import com.example.repairserviceapp.entities.Master;
import com.example.repairserviceapp.mappers.MasterMapper;
import com.example.repairserviceapp.services.MastersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/master")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MastersController {

    //TODO добавить валидацию на дто и валидацию из бд

    private final MastersService mastersService;
    private final MasterMapper masterMapper;

    @GetMapping("")
    public List<Master> readAll() {
        return mastersService.readAll();
    }

    @GetMapping("/{id}")
    public Master read(@PathVariable UUID id) {
        return mastersService.read(id);
    }

    @PostMapping("")
    public MasterDTO create(@RequestBody MasterDTO masterDTO) {
        Master master = masterMapper.toMaster(masterDTO);
        System.out.println(master);
        return masterMapper.toMasterDTO(mastersService.create(master));
    }

    @PatchMapping("/{id}")
    public Master update(@PathVariable UUID id, @RequestBody Master master) {
        return mastersService.update(id, master);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mastersService.delete(id);
    }
}
