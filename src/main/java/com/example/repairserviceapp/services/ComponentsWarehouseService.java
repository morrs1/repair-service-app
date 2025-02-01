package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.ComponentsWarehouse;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.ComponentsWarehouseRepo;
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
public class ComponentsWarehouseService {

    private final ComponentsWarehouseRepo componentsWarehouseRepo;
    private final EntityManager entityManager;

    public List<ComponentsWarehouse> readAll() {
        return componentsWarehouseRepo.findAll();
    }

    public ComponentsWarehouse read(UUID id) {
        return componentsWarehouseRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no components warehouse with this id")
        );
    }

    @Transactional
    public ComponentsWarehouse create(ComponentsWarehouse componentsWarehouse) {
        componentsWarehouse.setId(UUID.randomUUID());
        return componentsWarehouseRepo.save(componentsWarehouse);
    }

    @Transactional
    public ComponentsWarehouse update(UUID id, ComponentsWarehouse componentsWarehouse) {
        componentsWarehouseRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There is no components warehouse with this id")
        );
        componentsWarehouse.setId(id);
        ComponentsWarehouse updatedComponents = componentsWarehouseRepo.save(componentsWarehouse);
        entityManager.refresh(updatedComponents);
        return updatedComponents;
    }

    @Transactional
    public ComponentsWarehouse delete(UUID id) {
        ComponentsWarehouse componentsWarehouse = componentsWarehouseRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no components warehouse with this id"));
        componentsWarehouseRepo.deleteById(id);
        return componentsWarehouse;
    }

}
