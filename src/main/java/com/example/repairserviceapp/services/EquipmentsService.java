package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.Equipment;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.EquipmentsRepo;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentsService {

    private final EquipmentsRepo equipmentsRepo;
    private final EntityManager entityManager;

    public List<Equipment> readAll() {
        return equipmentsRepo.findAll();
    }

    public Equipment read(UUID id) {
        return equipmentsRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no equipment with this id")
        );
    }

    @Transactional
    public Equipment create(Equipment equipment) {
        equipment.setId(UUID.randomUUID());
        return equipmentsRepo.save(equipment);
    }

    @Transactional
    public Equipment update(UUID id, Equipment equipment) {
        equipment.setId(id);
        equipmentsRepo.findById(equipment.getId()).orElseThrow(() -> new EntityNotFoundException("There is no equipment with this id"));
        Equipment updatedEquipment = equipmentsRepo.save(equipment);
        entityManager.refresh(updatedEquipment);
        return updatedEquipment;
    }

    @Transactional
    public Equipment delete(UUID id) {
        Equipment equipment = equipmentsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no equipment with this id"));
        equipmentsRepo.deleteById(id);
        return equipment;
    }
}
