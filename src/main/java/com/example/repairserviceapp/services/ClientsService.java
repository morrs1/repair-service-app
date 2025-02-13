package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.Client;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.ClientsRepo;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
public class ClientsService {

    private final ClientsRepo clientsRepo;
    private final EntityManager entityManager;

    public List<Client> readAll() {
        return clientsRepo.findAll();
    }

    public Client read(UUID id) {
        return clientsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));
    }

    @Transactional
    public Client create(Client client) {
        client.setId(UUID.randomUUID());
        return clientsRepo.save(client);
    }

    @Transactional
    public Client delete(UUID id) {
        Client client = clientsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));
        clientsRepo.delete(client);
        return client;
    }

    @Transactional
    public Client update(UUID id, Client client) {
        clientsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));
        client.setId(id);
        Client updatedClient = clientsRepo.save(client);
        entityManager.refresh(updatedClient);
        return updatedClient;
    }
}
