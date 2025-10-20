package com.epam.training.dariia_binevych.inheritance_exercise;

import java.math.BigDecimal;

public class SalesPerson extends Employee {
    private final int percent;

    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);
        if (percent <= 0) {
            throw new IllegalArgumentException("Percent must be positive");
        }
        this.percent = percent;
    }

    public void setBonus(BigDecimal bonus) {
        if (percent > 200) {
            super.setBonus(bonus.multiply(BigDecimal.valueOf(3)));
        } else if (percent > 100) {
            super.setBonus(bonus.multiply(BigDecimal.valueOf(2)));

        } else {
            super.setBonus(bonus);
        }
    }
}
