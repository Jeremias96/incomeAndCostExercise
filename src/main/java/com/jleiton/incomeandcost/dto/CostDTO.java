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
public class CostDTO {

    private Integer id;

    private Double costValue;

    private Double additionalCostValue;
}
