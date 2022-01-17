package com.sg.bank.kata.account;

import java.math.BigDecimal;

public interface Account {
    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    void printHistory();
}
