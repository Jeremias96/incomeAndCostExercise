package com.jleiton.incomeandcost.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jleiton.incomeandcost.dao.CostRepository;
import com.jleiton.incomeandcost.dao.IncomeRepository;
import com.jleiton.incomeandcost.dao.ProfitLossRepository;

import com.jleiton.incomeandcost.dto.ProfitLossCalculationRequest;
import com.jleiton.incomeandcost.dto.ProfitLossDTO;

import com.jleiton.incomeandcost.exception.InvalidValuesRequestException;

import com.jleiton.incomeandcost.model.Cost;
import com.jleiton.incomeandcost.model.Income;
import com.jleiton.incomeandcost.model.ProfitLoss;

@ExtendWith(MockitoExtension.class)
class ProfitOrLossServiceTest {

    @Mock
    private IncomeRepository incomeRepository;

    @Mock
    private CostRepository costRepository;

    @Mock
    private ProfitLossRepository profitLossRepository;

    @InjectMocks
    private ProfitOrLossService profitOrLossService;

    private ProfitLossCalculationRequest request;

    @BeforeEach
    void setup() {
        request = new ProfitLossCalculationRequest();

        request.setIncomeValue(1000.0);
        request.setCostValue(300.0);
        request.setAdditionalCostValue(200.0);
    }

    @Test
    void shouldCalculateProfitOrLossSuccessfully() {
        Income savedIncome = Income.builder()
            .id(1)
            .incomeValue(1000.0)
            .build();

        Cost savedCost = Cost.builder()
            .id(1)
            .costValue(300.0)
            .additionalCostValue(200.0)
            .build();

        when(incomeRepository.save(any(Income.class)))
            .thenReturn(savedIncome);

        when(costRepository.save(any(Cost.class)))
            .thenReturn(savedCost);

        Double result =
            profitOrLossService.calculateProfitOrLoss(request);

        assertEquals(500.0, result);

        verify(incomeRepository, times(1))
            .save(any(Income.class));

        verify(costRepository, times(1))
            .save(any(Cost.class));

        verify(profitLossRepository, times(1))
            .save(any(ProfitLoss.class));
    }

    @Test
    void shouldThrowExceptionWhenIncomeIsNull() {
        request.setIncomeValue(null);

        assertThrows(
            InvalidValuesRequestException.class,
            () -> profitOrLossService
                .calculateProfitOrLoss(request)
        );
    }

    @Test
    void shouldThrowExceptionWhenCostIsNull() {
        request.setCostValue(null);

        assertThrows(
            InvalidValuesRequestException.class,
            () -> profitOrLossService
                .calculateProfitOrLoss(request)
        );
    }

    @Test
    void shouldThrowExceptionWhenAdditionalCostIsNull() {
        request.setAdditionalCostValue(null);

        assertThrows(
            InvalidValuesRequestException.class,
            () -> profitOrLossService
                .calculateProfitOrLoss(request)
        );
    }

    @Test
    void shouldRetrieveAllCalculatedProfits() {
        ProfitLoss profitLoss = ProfitLoss.builder()
            .id(1)
            .calculatedProfitOrLoss(500.0)
            .income(
                Income.builder()
                    .id(1)
                    .incomeValue(1000.0)
                    .build()
            )
            .cost(
                Cost.builder()
                    .id(1)
                    .costValue(300.0)
                    .additionalCostValue(200.0)
                    .build()
            )
            .build();

        when(profitLossRepository.findAll())
            .thenReturn(List.of(profitLoss));

        List<ProfitLossDTO> result =
            profitOrLossService.getAllProfitOrLossCalculated();

        assertEquals(1, result.size());

        verify(profitLossRepository, times(1))
            .findAll();
    }
}