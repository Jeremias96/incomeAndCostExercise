package com.jleiton.incomeandcost.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jleiton.incomeandcost.model.ProfitLoss;

public interface ProfitLossRepository extends JpaRepository<ProfitLoss, Integer>{
    
}
