package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.executionOfOrrder.ExecutionOfOrderDTORequest;
import com.example.repairserviceapp.DTOs.executionOfOrrder.ExecutionOfOrderDTOResponse;
import com.example.repairserviceapp.entities.ExecutionOfOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExecutionOfOrderMapper {

    ExecutionOfOrderDTOResponse toDTO(ExecutionOfOrder executionOfOrder);

    ExecutionOfOrder toExecutionOfOrder(ExecutionOfOrderDTORequest executionOfOrderDTORequest);
}
