package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class ProfitLoss{

    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private final Integer id; 

    private final Double calculatedProfitOrLoss;
    
    @OneToOne
    @JoinColumn(name = "INCOME_ID")
    private final Income income; 

    @OneToOne
    @JoinColumn(name = "COST_ID")
    private final Cost cost;
}
