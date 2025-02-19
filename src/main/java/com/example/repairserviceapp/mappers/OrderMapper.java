package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.OrderDTO;
import com.example.repairserviceapp.entities.Order;
import com.example.repairserviceapp.services.*;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @Setter(onMethod = @__(@Autowired))
    protected ClientsService clientsService;
    @Setter(onMethod = @__(@Autowired))
    protected EquipmentsService equipmentsService;
    @Setter(onMethod = @__(@Autowired))
    protected MastersService mastersService;
    @Setter(onMethod = @__(@Autowired))
    protected StatusesService statusesService;
    @Setter(onMethod = @__(@Autowired))
    protected OrderOfComponentsService orderOfComponentsService;

    @Mapping(target = "clientId", expression = "java(order.getClient().getId())")
    @Mapping(target = "equipmentId", expression = "java(order.getEquipment().getId())")
    @Mapping(target = "masterId", expression = "java(order.getMaster().getId())")
    @Mapping(target = "statusId", expression = "java(order.getStatus().getId())")
    @Mapping(target = "orderOfComponentsId", expression = "java(order.getOrderOfComponents()==null ? null  : order.getOrderOfComponents().getId())")
    public abstract OrderDTO toDTO(Order order);

    @Mapping(target = "client", expression = "java(clientsService.read(orderDTO.clientId()))")
    @Mapping(target = "equipment", expression = "java(equipmentsService.read(orderDTO.equipmentId()))")
    @Mapping(target = "master", expression = "java(mastersService.read(orderDTO.masterId()))")
    @Mapping(target = "status", expression = "java(statusesService.read(orderDTO.statusId()))")
    @Mapping(target = "orderOfComponents", expression = "java(orderOfComponentsService.read(orderDTO.orderOfComponentsId()))")
    public abstract Order toOrder(OrderDTO orderDTO);


}
