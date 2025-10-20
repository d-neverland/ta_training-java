package com.epam.training.dariia_binevych.aggregation_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {

    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal currentAmount = getAmount();
        BigDecimal interest = new BigDecimal("0.15");
        for (int month = 1; month <= getPeriod(); month++) {
            if (month >= 7) {
                currentAmount = currentAmount.multiply(BigDecimal.ONE.add(interest));
            }
        }
        return currentAmount.subtract(getAmount()).setScale(2, RoundingMode.DOWN);
    }
}