package com.bank.loans;

public class Loan
{
    private double loanAmount;
    private double annualInterestRate; // e.g. 5.5 for 5.5%
    private int termInYears;

    public Loan(double loanAmount, double annualInterestRate, int termInYears) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.termInYears = termInYears;
    }

    public double calculateEMI() {
        // EMI formula: E = P * r * (1+r)^n / ((1+r)^n - 1)
        double monthlyRate = annualInterestRate / 12 / 100;
        int months = termInYears * 12;
        if (monthlyRate <= 0) {
            return loanAmount / months;
        }
        double factor = Math.pow(1 + monthlyRate, months);
        return loanAmount * monthlyRate * factor / (factor - 1);
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
}
