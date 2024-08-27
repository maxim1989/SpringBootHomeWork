package pro.sky.mlfedorov.sandbox.emploees;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    final List<Employee> employees = new ArrayList<>();
    final int MAX_EMPLOYEES_AMOUNT = 3;

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    private Employee searchEmployee(String firstName, String lastName) {
        return null;
    }

    List<Employee> getList();
}
