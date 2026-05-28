package com.jleiton.incomeandcost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfitLossCalculationRequest {

    private Double incomeValue;
    
    private Double costValue;

    private Double additionalCostValue;
}
