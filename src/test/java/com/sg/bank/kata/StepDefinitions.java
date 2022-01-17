package com.sg.bank.kata;

import com.sg.bank.kata.account.Account;
import com.sg.bank.kata.account.ClientAccount;
import com.sg.bank.kata.operation.history.InMemoryOperationHistory;
import com.sg.bank.kata.operation.history.OperationHistory;
import com.sg.bank.kata.statement.ConsoleStatementPrinter;
import com.sg.bank.kata.statement.StatementPrinter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

public class StepDefinitions {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Account account;

    @Before
    public void setUp() {
        OperationHistory operationsHistory = new InMemoryOperationHistory();
        StatementPrinter statementPrinter = new ConsoleStatementPrinter();
        account = new ClientAccount(operationsHistory, statementPrinter);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Given("^I deposit (\\d+) euros$")
    public void i_deposit(BigDecimal amount) {
        account.deposit(amount);
    }

    @Given("^I withdraw (\\d+) euros$")
    public void i_withdraw(BigDecimal amount) {
        account.withdraw(amount);
    }

    @When("^I get the statement$")
    public void i_ask_the_statement() {
        outContent.reset();
        account.printHistory();
    }

    @Then("^My balance should be (-?\\d+)")
    public void my_balance_should_be(BigDecimal expectedBalance) {
        BigDecimal result = new BigDecimal(outContent.toString().split("\n")[1].split("\\|")[3].trim());
        Assertions.assertEquals(expectedBalance, result);
    }
}
