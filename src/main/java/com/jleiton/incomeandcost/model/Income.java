package com.jleiton.incomeandcost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Income(@Id Integer id, Double incomeValue) {
    
}
