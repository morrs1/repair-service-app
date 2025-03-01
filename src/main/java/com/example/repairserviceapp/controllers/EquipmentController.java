package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.equipment.EquipmentDTORequest;
import com.example.repairserviceapp.DTOs.equipment.EquipmentDTOResponse;
import com.example.repairserviceapp.mappers.EquipmentsMapper;
import com.example.repairserviceapp.services.EquipmentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController extends BaseController {

    private EquipmentsMapper equipmentsMapper;
    private EquipmentsService equipmentsService;

    @GetMapping("")
    public List<EquipmentDTOResponse> readAll() {
        return equipmentsService.readAll()
                .stream()
                .map(equipment -> equipmentsMapper.toDTO(equipment))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EquipmentDTOResponse read(@PathVariable UUID id) {
        return equipmentsMapper.toDTO(equipmentsService.read(id));
    }

    @PostMapping("")
    public EquipmentDTOResponse create(@RequestBody @Valid EquipmentDTORequest equipmentDTO, BindingResult bindingResult) {
        validate(bindingResult, "Create equipment failed");
        return equipmentsMapper.toDTO(equipmentsService.create(equipmentsMapper.toEquipment(equipmentDTO)));
    }

    @PatchMapping("/{id}")
    public EquipmentDTOResponse update(@PathVariable UUID id, @RequestBody @Valid EquipmentDTORequest equipmentDTO, BindingResult bindingResult) {
        validate(bindingResult, "Update equipment failed");
        return equipmentsMapper.toDTO(equipmentsService.update(id, equipmentsMapper.toEquipment(equipmentDTO)));
    }

    @DeleteMapping("/{id}")
    public EquipmentDTOResponse delete(@PathVariable UUID id) {
        return equipmentsMapper.toDTO(equipmentsService.delete(id));
    }
}
