package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.componentsWarehouse.ComponentsWarehouseDTORequest;
import com.example.repairserviceapp.DTOs.componentsWarehouse.ComponentsWarehouseDTOResponse;
import com.example.repairserviceapp.entities.ComponentsWarehouse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ComponentsWarehouseMapper {

    public abstract ComponentsWarehouseDTOResponse toDTO(ComponentsWarehouse componentsWarehouse);

    public abstract ComponentsWarehouse toEntity(ComponentsWarehouseDTORequest dto);
}
