package com.epam.training.dariia_binevych.aggregation_exercise;

import java.math.BigDecimal;

interface Executable {
    Deposit execute(BigDecimal amount, int period);
}
