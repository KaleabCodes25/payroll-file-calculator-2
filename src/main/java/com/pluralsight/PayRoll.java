package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "employees.csv";

        // Reading a file can throw an IOException, so the work happens inside try
        try {


            // FileReader opens the file; BufferedReader wraps it so we can read whole lines
            System.out.println("Whats the name of the file you want to read: ");
            String txtinput = scanner.nextLine();

            System.out.println("What's the name of pay-roll file you want to create:");
            String txtoutput = scanner.nextLine();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(txtoutput));
            BufferedReader reader = new BufferedReader(new FileReader(txtinput));
            String line;
            String text;

            // Skip the header line: "id" is not a number and parseInt would fail on it
            reader.readLine();

            // readLine() returns null at the end of the file, which ends the loop
            while ((line = reader.readLine()) != null) {


                    ///has a special meaning in split (it takes a pattern),so it is escaped as \\|
                String[] tokens = line.split("\\|");
                // Everything read from a file is text: convert each value to its real type
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                for (int i = 1; i < tokens.length; i++) {
                    text = String.format("Id: %d, name: %s, grossPay: %.2f,\n",
                            employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                    bufferedWriter.write(text);


                    System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                            employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                }
            }


            reader.close();
        } catch (Exception e) {
            // Most likely cause: employees.csv is not in the project folder
            System.err.println("Error reading file: " + fileName);
            e.getCause();
        }
    }

}
