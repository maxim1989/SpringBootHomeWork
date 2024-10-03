package pro.sky.mlfedorov.sandbox.services;

import pro.sky.mlfedorov.sandbox.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer department, Double salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    private Employee searchEmployee(String firstName, String lastName) {
        return null;
    }

    List<Employee> findAll();
}
