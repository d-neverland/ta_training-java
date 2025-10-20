package com.epam.training.dariia_binevych.inheritance_exercise;

import java.math.BigDecimal;

public class Employee {
    private final String name;
    private final BigDecimal salary;
    private BigDecimal bonus;

    public Employee(String name, BigDecimal salary, BigDecimal bonus) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (salary == null || salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salary must not be empty");
        }
        this.name = name;
        this.salary = salary;
        this.bonus = bonus == null ? BigDecimal.ZERO : bonus;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee(String name, BigDecimal salary) {
        this(name, salary, BigDecimal.ZERO);
    }

    public void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bonus must be positive");
        }
        this.bonus = bonus;
    }

    public BigDecimal toPay() {
        return salary.add(bonus);
    }
}