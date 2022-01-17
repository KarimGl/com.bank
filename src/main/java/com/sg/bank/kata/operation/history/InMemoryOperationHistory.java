package com.sg.bank.kata.operation.history;

import com.sg.bank.kata.operation.OperationType;
import com.sg.bank.kata.statement.Statement;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryOperationHistory implements OperationHistory {

    @Override
    public void save(OperationType operationType, BigDecimal amount) {
    }

    @Override
    public List<Statement> getStatements() {
        return null;
    }
}
