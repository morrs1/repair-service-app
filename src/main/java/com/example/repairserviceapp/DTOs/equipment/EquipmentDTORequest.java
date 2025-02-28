package com.example.repairserviceapp.DTOs.equipment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EquipmentDTORequest(
        @NotNull(message = "Name must be not empty")
        @Size(min = 2, max = 30, message = "Name must be longer than 2 and shorter then 30 symbols")
        String name,
        @NotNull
        @Size(min = 2, max = 30, message = "Serial number must be longer than 2 and shorter then 30 symbols")
        String serialNumber,
        @NotNull
        @Size(min = 2, max = 30, message = "Model must be longer than 2 and shorter then 30 symbols")
        String model
) {
}
