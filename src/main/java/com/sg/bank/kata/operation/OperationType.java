package com.sg.bank.kata.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationType {
    DEPOSIT("deposit operation"),
    WITHDRAW("withdraw operation");

    private final String name;
}
