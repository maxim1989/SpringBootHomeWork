package pro.sky.mlfedorov.sandbox.departments;

import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    List<Employee> getAllEmployees(Integer departmentId);
}
