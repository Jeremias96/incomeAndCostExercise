package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record ProfitLoss (@Id Integer id, Double calculatedProfitOrLoss, Integer incomeId, Integer costId) {
    
}
