package com.bank.util;

import java.util.UUID;

public class BankUtil
{
    private static final double MINIMUM_BALANCE = 1000.0;

    public static String generateAccountNumber() {
        // simple UUID-based account number
        return "ACC" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    public static boolean validateMinimumBalance(double balance) {
        return balance >= MINIMUM_BALANCE;
    }

    public static double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }
}
