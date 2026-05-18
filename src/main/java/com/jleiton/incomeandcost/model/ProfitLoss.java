package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProfitLoss{

    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id; 

    private Double calculatedProfitOrLoss;
    
    @OneToOne
    @JoinColumn(name = "INCOME_ID")
    private Income income; 

    @OneToOne
    @JoinColumn(name = "COST_ID")
    private Cost cost;
}
