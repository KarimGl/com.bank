package com.sg.bank.kata.operation.history;

import com.sg.bank.kata.operation.OperationType;
import com.sg.bank.kata.statement.Statement;

import java.math.BigDecimal;
import java.util.List;

public interface OperationHistory {

    void save(OperationType operationType, BigDecimal amount);

    List<Statement> getStatements();
}
