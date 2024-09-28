package pro.sky.mlfedorov.sandbox.emploees;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer department, Double salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    private Employee searchEmployee(String firstName, String lastName) {
        return null;
    }

    List<Employee> findAll();

    private void validateFirstName(String name) {}

    private void validateLastName(String name) {}

    private String modifyString(String value) {
        return null;
    }
}
