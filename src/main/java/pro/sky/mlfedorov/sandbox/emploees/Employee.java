package pro.sky.mlfedorov.sandbox.emploees;

import java.util.Objects;

public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private static int idCounter;

    public Employee(
            String firstName,
            String lastName
    ) {
        this.id = ++idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
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
        return "{\"firstName\":" + "\"" + firstName + "\"" + "\"lastName\":" + "\"" + lastName + "\"" + "}";
    }
}
