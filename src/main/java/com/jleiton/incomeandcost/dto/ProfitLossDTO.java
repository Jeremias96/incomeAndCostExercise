package com.jleiton.incomeandcost.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProfitLossDTO {

    private Integer id; 

    private Double calculatedProfitOrLoss;

    private IncomeDTO income;

    private CostDTO cost;
}
