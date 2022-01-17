package com.sg.bank.kata.statement;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {

    private static final String FIELD_SEPARATOR = " | ";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void print(List<Statement> statements) {
        if (!statements.isEmpty()) {
            printHeaders();
            statements.stream().forEach(this::printStatement);
        }
    }

    private void printHeaders() {
        System.out.println("OPERATION | DATE | AMOUNT | BALANCE");
    }

    private void printStatement(Statement statement) {
        System.out.println(statement.getOperation().getOperationType().name()
                + FIELD_SEPARATOR
                + dateFormatter.format(statement.getOperation().getDate())
                + FIELD_SEPARATOR
                + statement.getOperation().getAmount()
                + FIELD_SEPARATOR
                + statement.getBalance()
        );
    }
}
