package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.order.OrderDTORequest;
import com.example.repairserviceapp.DTOs.order.OrderDTOResponse;
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

    // protected final ZoneOffset offset = ZoneOffset.UTC;

    @Mapping(target = "clientId", expression = "java(order.getClient().getId())")
    @Mapping(target = "equipmentId", expression = "java(order.getEquipment().getId())")
    @Mapping(target = "masterId", expression = "java(order.getMaster().getId())")
    @Mapping(target = "statusId", expression = "java(order.getStatus().getId())")
    @Mapping(target = "orderOfComponentsId", expression = "java(order.getOrderOfComponents()==null ? null  : order.getOrderOfComponents().getId())")
    public abstract OrderDTOResponse toDTO(Order order);

    @Mapping(target = "client", expression = "java(clientsService.read(orderDTORequest.clientId()))")
    @Mapping(target = "equipment", expression = "java(equipmentsService.read(orderDTORequest.equipmentId()))")
    @Mapping(target = "master", expression = "java(mastersService.read(orderDTORequest.masterId()))")
    @Mapping(target = "status", expression = "java(statusesService.read(orderDTORequest.statusId()))")
    @Mapping(target = "orderOfComponents", expression = "java(orderOfComponentsService.read(orderDTORequest.orderOfComponentsId()))")
    public abstract Order toOrder(OrderDTORequest orderDTORequest);

//    @Mapping(target = "clientId", expression = "java(orderHistory.getClient().getId())")
//    @Mapping(target = "equipmentId", expression = "java(orderHistory.getEquipment().getId())")
//    @Mapping(target = "masterId", expression = "java(orderHistory.getMaster().getId())")
//    @Mapping(target = "statusId", expression = "java(orderHistory.getStatus().getId())")
//    @Mapping(target = "orderOfComponentsId", expression = "java(orderHistory.getOrderOfComponents()==null ? null  : order.getOrderOfComponents().getId())")
//    @Mapping(target = "offsetDateTime", expression = "java(orderHistory.getLocalDateRange().lower().toOffsetDateTime().withOffsetSameInstant(offset))")
//    public abstract OrderHistoryDTOResponse toDTO(OrderHistory orderHistory);
}
