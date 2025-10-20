package com.epam.training.dariia_binevych.interfaces_exercise;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Deposit baseDeposit = new BaseDeposit(BigDecimal.valueOf(1000), 3);
        Deposit specialDeposit = new SpecialDeposit(BigDecimal.valueOf(1500), 2);
        Deposit longDeposit = new LongDeposit(BigDecimal.valueOf(2000), 8);

        // Show incomes
        System.out.println("Base Deposit Income: " + baseDeposit.income());
        System.out.println("Special Deposit Income: " + specialDeposit.income());
        System.out.println("Long Deposit Income: " + longDeposit.income());

        // Show totals
        System.out.println("Base Deposit Total: " + baseDeposit.total());
        System.out.println("Special Deposit Total: " + specialDeposit.total());
        System.out.println("Long Deposit Total: " + longDeposit.total());

        // Prolong checks
        if (specialDeposit instanceof Prolongable) {
            System.out.println("Special Deposit can prolong: " + ((Prolongable) specialDeposit).canToProlong());
        }
        if (longDeposit instanceof Prolongable) {
            System.out.println("Long Deposit can prolong: " + ((Prolongable) longDeposit).canToProlong());
        }

        // Create client
        Client client = new Client();
        client.addDeposit(baseDeposit);
        client.addDeposit(specialDeposit);
        client.addDeposit(longDeposit);

        // Client info
        System.out.println("\nClient total income: " + client.totalIncome());
        System.out.println("Client max income: " + client.maxIncome());

        System.out.println("\nIncome by deposit index:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Deposit " + i + ": " + client.getIncomeByNumber(i));
        }

        // Count prolongable deposits
        System.out.println("\nNumber of prolongable deposits: " + client.countPossibleToProlongDeposit());

        // Sort deposits
        client.sortDeposits();
        System.out.println("\nDeposits sorted by total descending:");
        for (Deposit d : client) {
            System.out.println(d.getClass().getSimpleName() + " total: " + d.total());
        }
    }
}


