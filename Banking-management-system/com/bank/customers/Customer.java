package com.bank.customers;

import com.bank.accounts.Account;

public class Customer
{
    private String customerId;
    private String name;
    private Account account;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void linkAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "customerId='" + customerId + '\'' +
               ", name='" + name + '\'' +
               ", account=" + account +
               '}';
    }
}
