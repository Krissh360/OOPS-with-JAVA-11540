package com.bank;

import com.bank.accounts.Account;
import com.bank.accounts.SavingsAccount;
import com.bank.customers.Customer;
import com.bank.loans.Loan;

import static com.bank.util.BankUtil.*; // static import for utility methods

public class BankApplication
{
    public static void main(String[] args) {
        // create a customer
        Customer cust = new Customer("C001", "Alice");

        // generate an account number using static utility
        String acctNum = generateAccountNumber();
        Account acct = new Account(acctNum, 5000);
        cust.linkAccount(acct);

        System.out.println("Customer and account created: " + cust);

        // perform deposit and withdrawal
        acct.deposit(1500);
        System.out.println("Balance after deposit: " + acct.getBalance());

        acct.withdraw(2000);
        System.out.println("Balance after withdrawal: " + acct.getBalance());

        // check minimum balance using static import
        boolean ok = validateMinimumBalance(acct.getBalance());
        System.out.println("Meets minimum balance? " + ok);

        // savings account and interest
        SavingsAccount sav = new SavingsAccount(generateAccountNumber(), 10000, 0.03);
        System.out.println("Interest on savings: " + sav.calculateInterest());

        // loan example
        Loan loan = new Loan(100000, 5.5, 15);
        System.out.println("Monthly EMI for loan: " + loan.calculateEMI());

        // demonstrate access control behavior
        // the following lines would not compile because fields are private
        // System.out.println(acct.balance);            // error: balance has private access
        // System.out.println(acct.accountNumber);      // error: accountNumber has private access

        // fields are accessible via public getters only
        System.out.println("Access via getter: " + acct.getBalance());

        // try package access: we cannot access com.bank.accounts.Account from com.bank.loans directly
        // but since both packages are different, only public members are visible across packages.
    }
}
