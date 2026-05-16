package com.jleiton.incomeandcost.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jleiton.incomeandcost.model.Cost;

public interface CostRepository extends JpaRepository<Cost, Integer>{
    
}
