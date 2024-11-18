package org.example.employeemanagementsystem;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, String position, double annualSalary) {
        super(name, position);
        this.monthlySalary = annualSalary;
    }
    @Override
    public double calculateSalary() {
        return monthlySalary*12;    }
}
