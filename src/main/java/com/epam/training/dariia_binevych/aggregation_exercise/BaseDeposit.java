package com.epam.training.dariia_binevych.aggregation_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    public BigDecimal income() {
        BigDecimal currentAmount = getAmount();

        for (int month = 1; month <= getPeriod(); month++) {
            BigDecimal interest = currentAmount.multiply(new BigDecimal("0.05"));
            currentAmount = currentAmount.add(interest);
        }
        return currentAmount.subtract(getAmount()).setScale(2, RoundingMode.DOWN);
    }
}