package pro.sky.mlfedorov.sandbox.departments;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.Comparator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public Employee getEmployeeWithMaxSalary(Integer departmentId, List<Employee> employees) {
        return employees
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary)).orElseThrow();
    }

    public Employee getEmployeeWithMinSalary(Integer departmentId, List<Employee> employees) {
        return employees
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary)).orElseThrow();
    }

    public List<Employee> getAllEmployees(Integer departmentId, List<Employee> employees) {
        if (departmentId == null) {
            return employees;
        }

        return employees
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .toList();
    }
}
