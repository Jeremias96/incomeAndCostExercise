package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Cost {

    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private final Integer id;

    private final Double costValue;

    private final Double additionalCostValue;
}
