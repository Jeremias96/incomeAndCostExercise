package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income{

    @Id 
    private final Integer id;

    private final Double incomeValue;
}
