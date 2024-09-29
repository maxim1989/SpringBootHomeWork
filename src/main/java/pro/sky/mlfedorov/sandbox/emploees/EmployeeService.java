package pro.sky.mlfedorov.sandbox.emploees;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer department, Double salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> findAll();

    Employee searchEmployee(String firstName, String lastName);

    void validateFirstName(String name);

    void validateLastName(String name);

    String modifyString(String value);
}
