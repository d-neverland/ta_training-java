package com.epam.training.dariia_binevych.interfaces_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {

    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal currentAmount = getAmount();
        for (int month = 1; month <= getPeriod(); month++) {
            BigDecimal currentMonthPercent = new BigDecimal(month)
                    .divide(new BigDecimal("100"), 2, RoundingMode.DOWN);
            currentAmount = currentAmount.multiply(BigDecimal.ONE.add(currentMonthPercent));
        }
        return currentAmount.subtract(getAmount()).setScale(2, RoundingMode.DOWN);
    }

    @Override
    public boolean canToProlong() {
        return getAmount().compareTo(BigDecimal.valueOf(1000)) > 0;
    }


}

