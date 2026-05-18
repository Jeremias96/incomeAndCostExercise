package com.jleiton.incomeandcost.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.jleiton.incomeandcost.dto.ProfitLossDTO;
import com.jleiton.incomeandcost.model.ProfitLoss;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfitLossMapper {
    ProfitLossMapper INSTANCE = Mappers.getMapper(ProfitLossMapper.class);
    
    List<ProfitLossDTO> map(List<ProfitLoss> profitLossList);

    ProfitLossDTO map(ProfitLoss profitLoss);

    ProfitLoss map(ProfitLossDTO profitLossDTO);
}
