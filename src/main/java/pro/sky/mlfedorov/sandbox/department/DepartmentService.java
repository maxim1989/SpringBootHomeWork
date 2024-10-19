package pro.sky.mlfedorov.sandbox.department;

import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Double getMaxSalaryByDepartment(Integer departmentId);

    Double getMinSalaryByDepartment(Integer departmentId);

    Map<Integer,List<Employee>> getAllEmployeesGroupedByDepartment();

    List<Employee> getEmployeesByDepartment(Integer departmentId);

    Double getSumSalariesByDepartment(Integer departmentId);
}
