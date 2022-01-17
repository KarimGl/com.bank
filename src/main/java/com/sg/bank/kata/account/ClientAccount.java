package com.sg.bank.kata.account;

import com.sg.bank.kata.operation.OperationType;
import com.sg.bank.kata.operation.history.OperationHistory;
import com.sg.bank.kata.statement.StatementPrinter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ClientAccount implements Account {

    private final OperationHistory operationHistory;
    private final StatementPrinter statementPrinter;

    @Override
    public void deposit(BigDecimal amount) {
        operationHistory.save(OperationType.DEPOSIT, amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        operationHistory.save(OperationType.WITHDRAW, amount);
    }

    @Override
    public void printHistory() {
        statementPrinter.print(operationHistory.getStatements());
    }

}
