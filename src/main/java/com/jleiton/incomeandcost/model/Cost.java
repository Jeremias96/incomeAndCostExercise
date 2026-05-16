package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Cost(@Id Integer id, Double costValue, Double additionalCostValue) {
    
}
