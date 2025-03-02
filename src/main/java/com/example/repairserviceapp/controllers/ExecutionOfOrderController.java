package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.DTOs.executionOfOrrder.ExecutionOfOrderDTORequest;
import com.example.repairserviceapp.DTOs.executionOfOrrder.ExecutionOfOrderDTOResponse;
import com.example.repairserviceapp.mappers.ExecutionOfOrderMapper;
import com.example.repairserviceapp.services.ExecutionOfOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/execution-of-order")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExecutionOfOrderController extends BaseController {

    private ExecutionOfOrderService executionOfOrderService;
    private ExecutionOfOrderMapper executionOfOrderMapper;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public List<ExecutionOfOrderDTOResponse> readAll() {
        return executionOfOrderService.readAll()
                .stream()
                .map(executionOfOrder -> executionOfOrderMapper.toDTO(executionOfOrder))
                .toList();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ExecutionOfOrderDTOResponse read(@PathVariable UUID id) {
        return executionOfOrderMapper.toDTO(executionOfOrderService.read(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping("")
    public ExecutionOfOrderDTOResponse create(
            @RequestBody @Valid
            ExecutionOfOrderDTORequest executionOfOrderDTORequest,
            BindingResult bindingResult
    ) {
        validate(bindingResult, "Create execution of order failed");
        log.info("Create execution of order: {}", executionOfOrderDTORequest);
        var executionOfOrder = executionOfOrderMapper.toExecutionOfOrder(executionOfOrderDTORequest);
        log.info("Create execution of order: {}", executionOfOrder);
        var executionOfOrderDTOResponse = executionOfOrderService.create(executionOfOrder);
        return executionOfOrderMapper.toDTO(executionOfOrderDTOResponse);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ExecutionOfOrderDTOResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid
            ExecutionOfOrderDTORequest executionOfOrderDTORequest,
            BindingResult bindingResult
    ) {
        validate(bindingResult, "Update execution of order failed");
        var executionOfOrder = executionOfOrderMapper.toExecutionOfOrder(executionOfOrderDTORequest);
        var executionOfOrderDTOResponse = executionOfOrderService.update(id, executionOfOrder);
        return executionOfOrderMapper.toDTO(executionOfOrderDTOResponse);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ExecutionOfOrderDTOResponse delete(@PathVariable UUID id) {
        var executionOfOrder = executionOfOrderService.delete(id);
        return executionOfOrderMapper.toDTO(executionOfOrder);
    }
}
