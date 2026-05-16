package com.jleiton.incomeandcost.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.jleiton.incomeandcost.dto.IncomeDTO;
import com.jleiton.incomeandcost.model.Income;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeMapper {
    IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class); 
    
    Income map(IncomeDTO incomeDTO);
}
