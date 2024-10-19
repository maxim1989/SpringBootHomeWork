package pro.sky.mlfedorov.sandbox.department;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.exceptions.EmployeeNotFoundException;
import pro.sky.mlfedorov.sandbox.emploees.Employee;
import pro.sky.mlfedorov.sandbox.emploees.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Double getMaxSalaryByDepartment(Integer departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new).getSalary();
    }

    @Override
    public Double getMinSalaryByDepartment(Integer departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new).getSalary() ;
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.findAll().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .toList();
    }

    @Override
    public Double getSumSalariesByDepartment(Integer departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
    }
}
