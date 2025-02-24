package com.example.repairserviceapp.mappers;

import com.example.repairserviceapp.DTOs.master.HistoryMasterDTOResponse;
import com.example.repairserviceapp.entities.Master;
import com.example.repairserviceapp.entities.MasterHistory;
import io.hypersistence.utils.hibernate.type.range.Range;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
@Slf4j
public abstract class MasterHistoryMapper {

    @Mapping(target = "postId", expression = "java(master.getPost().getId())")
    @Mapping(target = "offsetDateTime", expression = "java(convertTime(master.getLocalDateRange()))")
    public abstract HistoryMasterDTOResponse toDTO(Master master);

    @Mapping(target = "postId", expression = "java(master.getPostCode())")
    @Mapping(target = "offsetDateTime", expression = "java(convertTime(master.getLocalDateRange()))")
    public abstract HistoryMasterDTOResponse toDTO(MasterHistory master);

    protected OffsetDateTime convertTime(Range<ZonedDateTime> zonedDateTimeRange) {
        return zonedDateTimeRange != null ? zonedDateTimeRange.lower().toOffsetDateTime().withOffsetSameInstant(ZoneOffset.UTC) : null;
    }
}