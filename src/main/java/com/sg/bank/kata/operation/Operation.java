package com.sg.bank.kata.operation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Operation {

    private final OperationType operationType;
    private final LocalDateTime date;
    private final BigDecimal amount;
}
