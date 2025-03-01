package com.example.repairserviceapp.DTOs.post;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PostDTOResponse(
        @NotNull(message = "Post id must be not null")
        UUID id,
        @NotNull(message = "Post name must be not null")
        @Size(min = 2, max = 30, message = "Post name size must be between 2 and 30 symbols")
        String postName
) {
}
