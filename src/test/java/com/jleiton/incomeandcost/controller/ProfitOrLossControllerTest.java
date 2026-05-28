package com.jleiton.incomeandcost.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.jleiton.incomeandcost.dto.ProfitLossCalculationRequest;
import com.jleiton.incomeandcost.dto.ProfitLossDTO;
import com.jleiton.incomeandcost.exception.InvalidValuesRequestException;
import com.jleiton.incomeandcost.service.ProfitOrLossService;

@WebMvcTest(ProfitOrLossController.class)
class ProfitOrLossControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProfitOrLossService profitOrLossService;

    @Test
    void shouldCalculateProfitOrLossSuccessfully()
    throws Exception {

        ProfitLossCalculationRequest request =
            new ProfitLossCalculationRequest();

        request.setIncomeValue(1000.0);
        request.setCostValue(300.0);
        request.setAdditionalCostValue(200.0);

        when(
            profitOrLossService
                .calculateProfitOrLoss(
                    any(ProfitLossCalculationRequest.class)
                )
        ).thenReturn(500.0);

        mockMvc.perform(
            post("/profit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(request)
                )
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").value(500.0));
    }

    @Test
    void shouldReturnBadRequestWhenExceptionOccurs()
    throws Exception {

        ProfitLossCalculationRequest request =
            new ProfitLossCalculationRequest();

        request.setIncomeValue(null);

        when(
            profitOrLossService
                .calculateProfitOrLoss(
                    any(ProfitLossCalculationRequest.class)
                )
        ).thenThrow(
            new InvalidValuesRequestException("Invalid values")
        );

        mockMvc.perform(
            post("/profit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(request)
                )
        )
        .andExpect(status().isBadRequest());
    }

    @Test
    void shouldRetrieveAllCalculatedProfits()
    throws Exception {

        ProfitLossDTO dto = new ProfitLossDTO();

        when(
            profitOrLossService
                .getAllProfitOrLossCalculated()
        ).thenReturn(List.of(dto));

        mockMvc.perform(
            get("/profit")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1));
    }
}