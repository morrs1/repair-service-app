package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.Client;
import com.example.repairserviceapp.entities.ClientHistory;
import com.example.repairserviceapp.exceptions.EntityAlreadyExistsException;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.ClientsHistoryRepo;
import com.example.repairserviceapp.repos.ClientsRepo;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
@Slf4j
public class ClientsService {

    private final ClientsRepo clientsRepo;
    private final ClientsHistoryRepo clientsHistoryRepo;
    private final EntityManager entityManager;

    public List<Client> readAll() {
        return clientsRepo.findAll();
    }

    public Client read(UUID id) {
        return clientsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));
    }

    @Transactional
    public Client create(Client client) {
        if (exists(client.getName(), client.getSurname(), client.getPatronymic())) {
            throw new EntityAlreadyExistsException("This client already exists");
        }
        client.setId(UUID.randomUUID());
        return clientsRepo.save(client);
    }

    @Transactional
    public Client delete(UUID id) {
        Client client = clientsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));
        clientsRepo.deleteById(id);
        return client;
    }

    @Transactional
    public Client update(UUID id, Client client) {
        clientsRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));
        client.setId(id);
        return clientsRepo.save(client);
    }

    private boolean exists(String name, String surname, String patronymic) {
        return clientsRepo.exists(Example.of(
                Client.builder().name(name).surname(surname).patronymic(patronymic).build()
        ));
    }

    public List<ClientHistory> readAllHistory() {
        return clientsHistoryRepo.findAll();
    }

    @Transactional
    public ClientHistory restore(UUID personId, OffsetDateTime timestamp) {

        ClientHistory historyClient = clientsHistoryRepo
                .findByClientIdAndTimestamp(personId, timestamp)
                .orElseThrow(() -> new EntityNotFoundException("There is no client with this id"));

        return clientsRepo.save(historyClient);
    }
}
