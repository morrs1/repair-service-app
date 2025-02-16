package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.ClientDTO;
import com.example.repairserviceapp.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClientsMapper {

    public abstract Client toClient(ClientDTO clientDTO);

    public abstract ClientDTO toDTO(Client client);
}
