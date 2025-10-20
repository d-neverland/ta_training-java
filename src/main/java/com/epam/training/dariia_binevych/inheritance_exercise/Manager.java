package com.epam.training.dariia_binevych.inheritance_exercise;

import java.math.BigDecimal;

public class Manager extends Employee {
    private final int clientAmount;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        if (clientAmount < 0) {
            throw new IllegalArgumentException("The number of clients should be positive");
        }
        this.clientAmount = clientAmount;
    }

    public void setBonus(BigDecimal bonus) {
        if (clientAmount > 150) {
            super.setBonus(bonus.add(BigDecimal.valueOf(1000)));
        } else if (clientAmount > 100) {
            super.setBonus(bonus.add(BigDecimal.valueOf(500)));
        } else {
            super.setBonus(bonus);
        }
    }
}
