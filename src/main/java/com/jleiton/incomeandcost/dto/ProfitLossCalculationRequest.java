package com.jleiton.incomeandcost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfitLossCalculationRequest {

    private Double incomeValue;
    
    private Double costValue;

    private Double additionalCostValue;
}
