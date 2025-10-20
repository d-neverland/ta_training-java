package com.epam.training.dariia_binevych.inheritance_exercise;

import java.math.BigDecimal;

public class Company {
    private final Employee[] employees;

    public Company(Employee[] employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employees must not be null");
        }
        this.employees = employees;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus) {
        if (companyBonus == null || companyBonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Company bonus must be greater than zero");
        }
        for (Employee e : employees) {
            e.setBonus(companyBonus);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal total = BigDecimal.ZERO;
        for (Employee e : employees) {
            total = total.add(e.toPay());
        }
        return total;
    }

    public String nameMaxSalary() {
        Employee maxEmp = employees[0];
        for (Employee e : employees) {
            if (e.toPay().compareTo(maxEmp.toPay()) > 0) {
                maxEmp = e;
            }
        }
        return maxEmp.getName();
    }
}
