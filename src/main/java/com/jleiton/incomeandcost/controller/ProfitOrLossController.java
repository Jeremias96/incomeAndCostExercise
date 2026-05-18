package com.jleiton.incomeandcost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jleiton.incomeandcost.dto.ProfitLossCalculationRequest;
import com.jleiton.incomeandcost.dto.ProfitLossDTO;
import com.jleiton.incomeandcost.service.ProfitOrLossService;

@RestController
@RequestMapping("/profit")
public class ProfitOrLossController {

    @Autowired
    private ProfitOrLossService profitOrLossService;

    @PostMapping()
    public ResponseEntity<?> calculateProfitOrLoss(@RequestBody ProfitLossCalculationRequest request){
        try {
            return new ResponseEntity<Double>(profitOrLossService.calculateProfitOrLoss(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllProfitOrLossCalculated(){
        try {
            return new ResponseEntity<List<ProfitLossDTO>>(profitOrLossService.getAllProfitOrLossCalculated(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
