package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.OrderOfComponentsDTO;
import com.example.repairserviceapp.entities.OrderOfComponents;
import com.example.repairserviceapp.services.ComponentsWarehouseService;
import com.example.repairserviceapp.services.ExecutionOfOrderService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderOfComponentsMapper {

    @Setter(onMethod = @__(@Autowired))
    protected ComponentsWarehouseService componentsWarehouseService;

    @Setter(onMethod = @__(@Autowired))
    protected ExecutionOfOrderService executionOfOrderService;


    @Mapping(target = "componentsWarehouse", expression = "java(componentsWarehouseService.read(orderOfComponentsDTO.componentsWarehouseId()))")
    @Mapping(target = "executionOfOrder", expression = "java(executionOfOrderService.read(orderOfComponentsDTO.executionOfOrderId()))")
    public abstract OrderOfComponents toOrderOfComponents(OrderOfComponentsDTO orderOfComponentsDTO);

    @Mapping(target = "componentsWarehouseId", expression = "java(orderOfComponents.getComponentsWarehouse().getId())")
    @Mapping(target = "executionOfOrderId", expression = "java(orderOfComponents.getExecutionOfOrder().getId())")
    public abstract OrderOfComponentsDTO toDTO(OrderOfComponents orderOfComponents);
}
