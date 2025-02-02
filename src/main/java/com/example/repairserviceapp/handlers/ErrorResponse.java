package com.example.repairserviceapp.handlers;


import java.time.LocalDateTime;

public record ErrorResponse(String message, LocalDateTime timestamp) {
}
