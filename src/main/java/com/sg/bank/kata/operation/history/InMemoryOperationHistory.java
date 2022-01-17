package com.sg.bank.kata.operation.history;

import com.sg.bank.kata.operation.Operation;
import com.sg.bank.kata.operation.OperationType;
import com.sg.bank.kata.statement.Statement;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class InMemoryOperationHistory implements OperationHistory {
    private final List<Operation> operations = new LinkedList();

    @Override
    public void save(OperationType operationType, BigDecimal amount) {
        if (operationType == OperationType.WITHDRAW) {
            amount = amount.negate();
        }
        this.operations.add(new Operation(operationType, LocalDateTime.now(), amount));
    }

    @Override
    public List<Statement> getStatements() {
        List<Statement> statements = new LinkedList();
        AtomicReference<BigDecimal> balance = new AtomicReference<>(BigDecimal.valueOf(0));
        operations.stream()
                .forEach(operation -> {
                    balance.accumulateAndGet(balance.get().add(operation.getAmount()), (a, b) -> a.add(b));
                    statements.add(new Statement(operation, balance.get()));
                });
        return statements;
    }
}
