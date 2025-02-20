package com.example.repairserviceapp.DTOs.equipment;

import com.example.repairserviceapp.DTOs.OrderDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record HistoryEquipmentDTOResponse(
        @NotEmpty(message = "name field can't be empty, please provide it")
        UUID id,

        @NotEmpty(message = "name field can't be empty, please provide it")
        @Size(min = 2, max = 30, message = "Size must be between 2 and 30")
        String name,

        @NotEmpty(message = "serialNumber field can't be empty, please provide it")
        @Size(min = 2, max = 30, message = "Size must be between 2 and 30")
        String serialNumber,

        @NotEmpty(message = "model field can't be empty, please provide it")
        @Size(min = 2, max = 30, message = "Size must be between 2 and 30")
        String model,

        @NotNull(message = "orders field can't be null, please provide some data")
        List<OrderDTO> orders,

        @NotEmpty(message = "offsetDateTime field can't be empty, please provide it")
        OffsetDateTime offsetDateTime
) {
}
