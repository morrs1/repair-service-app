package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.equipment.EquipmentDTOResponse;
import com.example.repairserviceapp.mappers.EquipmentsMapper;
import com.example.repairserviceapp.services.EquipmentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController {

    private EquipmentsMapper equipmentsMapper;
    private EquipmentsService equipmentsService;

    @GetMapping("")
    public List<EquipmentDTOResponse> readAll() {
        return equipmentsService.readAll()
                .stream()
                .map(equipment -> equipmentsMapper.toDTO(equipment))
                .collect(Collectors.toList());
    }
}
