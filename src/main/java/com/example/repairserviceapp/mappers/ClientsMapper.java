package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.client.ClientDTORequest;
import com.example.repairserviceapp.DTOs.client.ClientDTOResponse;
import com.example.repairserviceapp.DTOs.client.HistoryClientDTOResponse;
import com.example.repairserviceapp.entities.BaseClient;
import com.example.repairserviceapp.entities.Client;
import com.example.repairserviceapp.entities.ClientHistory;
import org.mapstruct.Mapper;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class ClientsMapper {

    public abstract Client toClient(ClientDTORequest clientDTORequest);

    public abstract ClientDTOResponse toDTO(Client client);

    public abstract ClientHistory toClientHistory(Client clientHistory);
    public abstract Client toClient(ClientHistory clientHistory);
}
