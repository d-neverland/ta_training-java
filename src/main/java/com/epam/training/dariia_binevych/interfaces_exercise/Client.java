package com.epam.training.dariia_binevych.interfaces_exercise;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Client implements Iterable<Deposit> {

    private final Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10];
    }

    public Client(Deposit[] deposits) {
        if (deposits == null || deposits.length == 0) {
            throw new IllegalArgumentException("Deposits cannot be null or empty");
        }
        this.deposits = deposits;
    }

    public boolean addDeposit(Deposit deposit) {
        if (deposit == null) {
            throw new IllegalArgumentException("Deposit cannot be null");
        }
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal total = BigDecimal.ZERO;
        for (Deposit d : deposits) {
            if (d != null) {
                total = total.add(d.income());
            }
        }
        return total;
    }

    public BigDecimal maxIncome() {
        BigDecimal max = BigDecimal.ZERO;
        for (Deposit d : deposits) {
            if (d != null) {
                BigDecimal income = d.income();
                if (income.compareTo(max) > 0) {
                    max = income;
                }
            }
        }
        return max;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (number < 0 || number >= deposits.length || deposits[number] == null) {
            return BigDecimal.ZERO;
        }
        return deposits[number].income();
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new DepositIterator();
    }

    private class DepositIterator implements Iterator<Deposit> {
        int index = 0;

        @Override
        public boolean hasNext() {
            while (index < deposits.length && deposits[index] == null) {
                index++;
            }
            return index < deposits.length;
        }

        @Override
        public Deposit next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return deposits[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void sortDeposits() {
        Arrays.sort(deposits, (d1, d2) -> {
            if (d1 == null && d2 == null) return 0;
            if (d1 == null) return 1; // nulls go last
            if (d2 == null) return -1;
            return d2.total().compareTo(d1.total());
        });
    }

    public int countPossibleToProlongDeposit() {
        int count = 0;
        for (Deposit d : deposits) {
            if (d instanceof Prolongable && ((Prolongable) d).canToProlong()) {
                count++;
            }
        }
        return count;
    }
}