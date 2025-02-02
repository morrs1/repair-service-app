package com.example.repairserviceapp.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record MasterDTO(
        @NotNull(message = "id must be not empty")
        UUID id,
        @NotNull(message = "id must be not empty")
        @Size(min = 2, max = 30)
        String surname,
        @NotNull(message = "id must be not empty")
        @Size(min = 2, max = 30)
        String name,
        @NotNull(message = "id must be not empty")
        @Size(min = 2, max = 30)
        String patronymic,
        @NotNull(message = "id must be not empty")
        @Size(min = 2, max = 30)
        String address,
        @NotNull(message = "id must be not empty")
        @Pattern(regexp = "^(\\+7|8)[0-9]{10}$", message = "Phone number must be valid")
        String phoneNumber,
        @NotNull(message = "id must be not empty")
        LocalDate dateOfEmployment,
        @NotNull(message = "id must be not empty")
        UUID postId
) {
}
