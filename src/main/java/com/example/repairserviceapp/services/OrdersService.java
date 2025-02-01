package com.example.repairserviceapp.services;

import com.example.repairserviceapp.entities.Order;
import com.example.repairserviceapp.exceptions.EntityNotFoundException;
import com.example.repairserviceapp.repos.OrdersRepo;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersService {

    private final OrdersRepo ordersRepo;
    private final EntityManager entityManager;

    public List<Order> readAll() {
        return ordersRepo.findAll();
    }

    public Order read(UUID id) {
        return ordersRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There id no order with this id"));
    }

    @Transactional
    public Order create(Order order) {
        order.setId(UUID.randomUUID());
        return ordersRepo.save(order);
    }

    @Transactional
    public Order update(UUID id, Order order) {
        ordersRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There id no order with this id"));
        order.setId(id);
        Order updatedOrder = ordersRepo.save(order);
        entityManager.refresh(updatedOrder);
        return updatedOrder;
    }

    @Transactional
    public Order delete(UUID id) {
        Order oldOrder = ordersRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("There id no order with this id"));
        ordersRepo.deleteById(id);
        return oldOrder;
    }
}
