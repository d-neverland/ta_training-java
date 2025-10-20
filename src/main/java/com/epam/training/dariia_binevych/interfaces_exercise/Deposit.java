package com.epam.training.dariia_binevych.interfaces_exercise;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Deposit implements Comparable<Deposit> {

    protected final BigDecimal amount;
    protected final int period;

    protected Deposit(BigDecimal depositAmount, int depositPeriod) {
        if (depositAmount.compareTo(BigDecimal.ZERO) <= 0 || depositPeriod <= 0) {
            throw new IllegalArgumentException("Amount and period must be positive");
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

    public BigDecimal total() {
        return amount.add(income());
    }

    @Override
    public int compareTo(Deposit other) {
        return this.total().compareTo(other.total());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Deposit other = (Deposit) obj;
        return amount.equals(other.amount) && period == other.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, period);
    }
}
