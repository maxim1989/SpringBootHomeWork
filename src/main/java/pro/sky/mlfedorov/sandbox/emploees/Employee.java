package pro.sky.mlfedorov.sandbox.emploees;

import java.util.Objects;

public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;
    private static int idCounter;

    public Employee(
            String firstName,
            String lastName,
            int department,
            double salary
    ) {
        this.id = ++idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{\"firstName\":"
                + "\""
                + firstName
                + "\""
                + "\"lastName\":"
                + "\""
                + lastName
                + "\""
                + "\"department\":"
                + "\""
                + department
                + "\""
                + "\"salary\":"
                + "\""
                + salary
                + "\""
                + "}";
    }
}
