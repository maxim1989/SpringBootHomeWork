package pro.sky.mlfedorov.sandbox.departments;

import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId, List<Employee> employees);

    Employee getEmployeeWithMinSalary(Integer departmentId, List<Employee> employees);

    List<Employee> getAllEmployees(Integer departmentId, List<Employee> employees);
}
