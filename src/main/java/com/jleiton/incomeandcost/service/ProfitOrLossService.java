package com.jleiton.incomeandcost.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jleiton.incomeandcost.dao.CostRepository;
import com.jleiton.incomeandcost.dao.IncomeRepository;
import com.jleiton.incomeandcost.dao.ProfitLossRepository;
import com.jleiton.incomeandcost.dto.ProfitLossCalculationRequest;
import com.jleiton.incomeandcost.dto.ProfitLossDTO;
import com.jleiton.incomeandcost.mapper.ProfitLossMapper;
import com.jleiton.incomeandcost.model.Cost;
import com.jleiton.incomeandcost.model.Income;
import com.jleiton.incomeandcost.model.ProfitLoss;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfitOrLossService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private CostRepository costRepository;

    @Autowired
    private ProfitLossRepository profitLossRepository;
    
    public Double calculateProfitOrLoss(ProfitLossCalculationRequest req){
        log.trace("Profit or loss service - Calculating profit or loss for income: {} and costs {}, {}",
            Optional.of(req.getIncomeValue()).orElse(null),
            Optional.of(req.getCostValue()).orElse(null),
            Optional.of(req.getAdditionalCostValue()).orElse(null)
        );

        Income savedIncome = saveIncome(req.getIncomeValue());
        Cost savedCost = saveCost(req.getCostValue(), req.getAdditionalCostValue());

        Double calculatedProfitOrLoss = savedIncome.getIncomeValue() - (savedCost.getCostValue() + savedCost.getAdditionalCostValue());

        log.debug("Profit or loss service - Calculated profit or loss for income: {} and costs {}, {}, equals: {}",
            Optional.of(savedIncome.getIncomeValue()).orElse(null),
            Optional.of(savedCost.getCostValue()).orElse(null),
            Optional.of(savedCost.getAdditionalCostValue()).orElse(null),
            calculatedProfitOrLoss
        );

        profitLossRepository.save(ProfitLoss.builder().calculatedProfitOrLoss(calculatedProfitOrLoss)
            .income(savedIncome).cost(savedCost).build());

        return calculatedProfitOrLoss;
    }

    private Income saveIncome(Double incomeValue){
        return incomeRepository.save(Income.builder().incomeValue(incomeValue).build());
    }

    private Cost saveCost(Double costValue, Double additionalCostValue){
        return costRepository.save(Cost.builder().costValue(costValue)
            .additionalCostValue(additionalCostValue).build());
    }

    public List<ProfitLossDTO> getAllProfitOrLossCalculated() {
        log.info("Profit or loss service - Attempting to retrieve all profit or loss calculated");
        List<ProfitLoss> profitLossList = profitLossRepository.findAll();
        return ProfitLossMapper.INSTANCE.map(profitLossList);
    }
}
