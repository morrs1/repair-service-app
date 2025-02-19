package com.example.repairserviceapp.DTOs;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderOfComponentsDTO(
        UUID id,
        @NotNull(message = "Components of warehouse id must be not empty")
        UUID componentsWarehouseId,
        @NotNull(message = "Execution of order id must be not empty")
        UUID executionOfOrderId
) {
}
