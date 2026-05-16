package com.jleiton.incomeandcost.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.jleiton.incomeandcost.dto.CostDTO;
import com.jleiton.incomeandcost.model.Cost;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CostMapper {
    CostMapper INSTANCE = Mappers.getMapper(CostMapper.class);

    Cost map(CostDTO costDTO);
}
