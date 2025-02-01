package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.Master;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.MastersRepo;
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
public class MastersService {

    private final MastersRepo mastersRepo;
    private final EntityManager entityManager;

    public List<Master> readAll() {
        return mastersRepo.findAll();
    }

    public Master read(UUID id) {
        return mastersRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no master with this id"));
    }

    @Transactional
    public Master create(Master master) {
        master.setId(UUID.randomUUID());
        return mastersRepo.save(master);
    }

    @Transactional
    public Master update(UUID id, Master master) {
        mastersRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no master with this id"));
        master.setId(id);
        Master updatedMaster = mastersRepo.save(master);
        entityManager.refresh(updatedMaster);
        return updatedMaster;
    }

    @Transactional
    public Master delete(UUID id) {
        Master oldMaster = mastersRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no master with this id"));
        mastersRepo.deleteById(id);
        return oldMaster;
    }
}
