package com.pluralsight;


public class Employee {
    // private: other classes read the values through the getters below
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    // Parameterized constructor: an Employee is created with all four values at once
    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // The id and the name never change, so they have getters only (no setters)
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // Gross pay is calculated each time it is asked for, not stored:
    // if the hours or the rate change, the pay is always up to date
    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}




