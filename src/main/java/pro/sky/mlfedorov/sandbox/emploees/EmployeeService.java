package pro.sky.mlfedorov.sandbox.emploees;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    private Employee searchEmployee(String firstName, String lastName) {
        return null;
    }

    List<Employee> findAll();
}
