package com.sg.bank.kata.statement;

import com.sg.bank.kata.operation.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Statement {
    private final Operation operation;
    private final BigDecimal balance;
}
