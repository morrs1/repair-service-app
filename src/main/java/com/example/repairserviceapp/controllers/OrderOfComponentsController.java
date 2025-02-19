package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.OrderOfComponentsDTO;
import com.example.repairserviceapp.mappers.OrderOfComponentsMapper;
import com.example.repairserviceapp.services.OrderOfComponentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order-of-components")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderOfComponentsController extends BaseController {

    private OrderOfComponentsService orderOfComponentsService;
    private OrderOfComponentsMapper orderOfComponentsMapper;

    @GetMapping("")
    public List<OrderOfComponentsDTO> readAll() {
        return orderOfComponentsService
                .readAll()
                .stream()
                .map(elem -> orderOfComponentsMapper.toDTO(elem))
                .toList();
    }

    @GetMapping("/{id}")
    public OrderOfComponentsDTO read(@PathVariable UUID id) {
        return orderOfComponentsMapper.toDTO(orderOfComponentsService.read(id));
    }

    @PostMapping("")
    public OrderOfComponentsDTO create(@RequestBody @Valid OrderOfComponentsDTO dto, BindingResult bindingResult) {
        validate(bindingResult, "Create OrderOfComponents failed");
        return orderOfComponentsMapper.toDTO(orderOfComponentsService.create(orderOfComponentsMapper.toOrderOfComponents(dto)));
    }

    @PatchMapping("/{id}")
    public OrderOfComponentsDTO update(@PathVariable UUID id, @RequestBody @Valid OrderOfComponentsDTO dto, BindingResult bindingResult) {
        validate(bindingResult, "Update OrderOfComponents failed");
        return orderOfComponentsMapper.toDTO(orderOfComponentsService.update(id, orderOfComponentsMapper.toOrderOfComponents(dto)));
    }

    @DeleteMapping("/{id}")
    public OrderOfComponentsDTO delete(@PathVariable UUID id) {
        return orderOfComponentsMapper.toDTO(orderOfComponentsService.delete(id));
    }

}
