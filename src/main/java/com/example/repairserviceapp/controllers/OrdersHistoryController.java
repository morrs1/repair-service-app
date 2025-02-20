package com.example.repairserviceapp.controllers;


import com.example.repairserviceapp.DTOs.order.OrderHistoryDTOResponse;
import com.example.repairserviceapp.mappers.OrderMapper;
import com.example.repairserviceapp.services.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/history/order")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersHistoryController extends BaseController {
    private OrdersService ordersService;
    private OrderMapper orderMapper;

    @Operation(
            summary = "Вернуть старые данные заказа компонента",
            description = "Позволяет возвращать старые данные, которые были проделаны в результате работы БД. "
    )
    @PatchMapping("/{id}")
    public OrderHistoryDTOResponse restore(@PathVariable("id") UUID id, @RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime timestamp) {
        return orderMapper.toDTO(ordersService.restore(id, timestamp));
    }

    @Operation(
            summary = "Показывает все заказы в темпоральной таблице со временем",
            description = "Позволяет показывать все заказы компонентов со временем изменений данных"
    )
    @GetMapping("")
    public List<OrderHistoryDTOResponse> readAllTemporal() {
        return ordersService
                .readAllHistory()
                .stream()
                .map(clientHistory -> orderMapper.toDTO(clientHistory))
                .collect(Collectors.toList());
    }
}
