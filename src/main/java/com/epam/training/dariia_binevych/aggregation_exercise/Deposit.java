package com.epam.training.dariia_binevych.aggregation_exercise;

import java.math.BigDecimal;

public abstract class Deposit {

    protected final BigDecimal amount;
    protected final int period;

    protected Deposit(BigDecimal depositAmount, int depositPeriod) {
        if (depositAmount == null || depositAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        if (depositPeriod <= 0) {
            throw new IllegalArgumentException("Deposit period must be positive");
        }

        this.amount = depositAmount;
        this.period = depositPeriod;

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();
}