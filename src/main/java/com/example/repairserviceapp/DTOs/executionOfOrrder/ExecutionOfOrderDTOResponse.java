package com.example.repairserviceapp.DTOs.executionOfOrrder;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExecutionOfOrderDTOResponse(
        @NotNull(message = "Id must be not null")
        UUID id,
        @NotNull(message = "Type of work must be not null")
        @Size(min = 2, max = 50, message = "Type of work must be between 2 and 50 symbols")
        String typeOfWork,
        @NotNull(message = "Cost of execution must be not null")
        @Min(value = 0, message = "Cost of execution must be greater than 0")
        BigDecimal exCost,
        @NotNull(message = "Components cost must be not null")
        @Min(value = 0, message = "Components cost must be greater than 0")
        BigDecimal componentsCost,
        @NotNull(message = "Execution date must be not null")
        LocalDate executionDate,
        @NotNull(message = "Total cost must be not null")
        @Min(value = 0, message = "Total cost of execution must be greater than 0")
        BigDecimal totalCost
) {
}
