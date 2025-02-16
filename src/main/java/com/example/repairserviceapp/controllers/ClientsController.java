package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.ClientDTO;
import com.example.repairserviceapp.mappers.ClientsMapper;
import com.example.repairserviceapp.services.ClientsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsController extends BaseController {

    private ClientsService clientsService;
    private ClientsMapper clientsMapper;

    @GetMapping("")
    public List<ClientDTO> readAll() {
        return clientsService.readAll().stream().map(
                client -> clientsMapper.toDTO(client)
        ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientDTO read(@PathVariable("id") UUID id) {
        return clientsMapper.toDTO(clientsService.read(id));
    }

    @PostMapping("")
    public ClientDTO create(@RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) {
        validate(bindingResult, "Create client failed");
        return clientsMapper.toDTO(clientsService.create(clientsMapper.toClient(clientDTO)));
    }

    @PatchMapping("/{id}")
    public ClientDTO update(@PathVariable("id") UUID id, @RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) {
        validate(bindingResult, "Update client failed");
        return clientsMapper.toDTO(clientsService.update(id, clientsMapper.toClient(clientDTO)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        clientsService.delete(id);
    }


}
