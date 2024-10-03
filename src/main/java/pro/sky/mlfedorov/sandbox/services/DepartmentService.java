package pro.sky.mlfedorov.sandbox.services;

import pro.sky.mlfedorov.sandbox.entities.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    List<Employee> getAllEmployees(Integer departmentId);
}
