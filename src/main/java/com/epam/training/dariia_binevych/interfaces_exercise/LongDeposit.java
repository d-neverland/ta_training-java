package com.epam.training.dariia_binevych.interfaces_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable {

    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal sum = amount;
        for (int i = 1; i <= period; i++) {
            if (i > 6) {
                sum = sum.add(sum.multiply(BigDecimal.valueOf(0.15))).setScale(2, RoundingMode.HALF_EVEN);
            }
        }
        return sum.subtract(amount);
    }

    @Override
    public boolean canToProlong() {
        return getPeriod() < 36;
    }

}
