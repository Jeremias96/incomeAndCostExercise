package com.jleiton.incomeandcost.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jleiton.incomeandcost.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer>{
    
}
