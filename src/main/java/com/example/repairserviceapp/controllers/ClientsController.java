package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.ClientDTO;
import com.example.repairserviceapp.mappers.ClientsMapper;
import com.example.repairserviceapp.services.ClientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Контроллер для управления клиентами", description = "Здесь есть все операции CRUD для клиента")
@RestController
@RequestMapping("/api/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsController extends BaseController {

    private ClientsService clientsService;
    private ClientsMapper clientsMapper;

    @Operation(
            summary = "Просмотр данных всех пользователей",
            description = "Позволяет просмотреть всех пользователей."
    )
    @GetMapping("")
    public List<ClientDTO> readAll() {
        return clientsService
                .readAll()
                .stream()
                .map(client -> clientsMapper.toDTO(client))
                .collect(Collectors.toList());
    }

    @Operation(
            summary = "Просмотр данных об одном пользователя",
            description = "Позволяет посмотреть данные об одном пользователе, зная его уникальный идентификатор. "
    )
    @GetMapping("/{id}")
    public ClientDTO read(@PathVariable("id") UUID id) {
        return clientsMapper.toDTO(clientsService.read(id));
    }

    @Operation(
            summary = "Создание одного пользователя",
            description = "Позволяет создать одного отдельного пользователя"
    )
    @PostMapping("")
    public ClientDTO create(@RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) {
        validate(bindingResult, "Create client failed");
        return clientsMapper.toDTO(clientsService.create(clientsMapper.toClient(clientDTO)));
    }

    @Operation(
            summary = "Обновление данных отдельного пользователя",
            description = "Позволяет обновлять данные об отдельном пользователе, зная его id. "
    )
    @PatchMapping("/{id}")
    public ClientDTO update(@PathVariable("id") UUID id, @RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) {
        validate(bindingResult, "Update client failed");
        return clientsMapper.toDTO(clientsService.update(id, clientsMapper.toClient(clientDTO)));
    }

    @Operation(
            summary = "Удаление данных об отдельном пользователе",
            description = "Позволяет удалять данные об отдельном пользователе, зная его id"
    )
    @DeleteMapping("/{id}")
    public ClientDTO delete(@PathVariable("id") UUID id) {
      return clientsMapper.toDTO(clientsService.delete(id));
    }


}
