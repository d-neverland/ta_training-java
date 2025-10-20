package com.epam.training.dariia_binevych.interfaces_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit implements Prolongable {

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    public BigDecimal income() {
        BigDecimal sum = amount;
        for (int i = 1; i <= period; i++) {
            BigDecimal rate = BigDecimal.valueOf(i)
                    .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_EVEN);
            sum = sum.add(sum.multiply(rate)).setScale(2, RoundingMode.HALF_EVEN);
        }
        return sum.subtract(amount);
    }

    @Override
    public boolean canToProlong() {
        return amount.compareTo(BigDecimal.valueOf(1000)) > 0;
    }
}
