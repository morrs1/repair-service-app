package com.example.repairserviceapp.DTOs.orderOfComponents;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

public record OrderOfComponentsHistoryDTOResponse(
        UUID id,
        @NotNull(message = "Components of warehouse id must be not empty")
        UUID componentsWarehouseId,
        @NotNull(message = "Execution of order id must be not empty")
        UUID executionOfOrderId,
        @NotNull(message = "Offset date time must be not empty")
        OffsetDateTime offsetDateTime
) {
}
