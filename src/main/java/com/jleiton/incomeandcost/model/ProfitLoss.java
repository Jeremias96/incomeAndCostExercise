package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ProfitLoss{

    @Id 
    private final Integer id; 

    private final Double calculatedProfitOrLoss;
    
    @OneToOne
    @JoinColumn(name = "INCOME_ID")
    private final Income income; 

    @OneToOne
    @JoinColumn(name = "COST_ID")
    private final Cost cost;
}
