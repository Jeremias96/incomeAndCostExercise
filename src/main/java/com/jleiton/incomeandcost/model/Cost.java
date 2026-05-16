package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cost {

    @Id 
    private final Integer id;

    private final Double costValue;

    private final Double additionalCostValue;
}
