package pro.sky.mlfedorov.sandbox.departments;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.exceptions.EmployeeNotFoundException;
import pro.sky.mlfedorov.sandbox.emploees.Employee;
import pro.sky.mlfedorov.sandbox.emploees.EmployeeService;

import java.util.Comparator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getAllEmployees(Integer departmentId) {
        if (departmentId == null) {
            return employeeService.findAll();
        }

        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .toList();
    }
}
