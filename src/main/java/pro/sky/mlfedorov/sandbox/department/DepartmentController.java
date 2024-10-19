package pro.sky.mlfedorov.sandbox.department;

import org.springframework.web.bind.annotation.*;
import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{departmentId}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable Integer departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("{departmentId}/salary/sum")
    public Double getSumSalariesByDepartment(@PathVariable Integer departmentId) {
        return departmentService.getSumSalariesByDepartment(departmentId);
    }
    @GetMapping("{departmentId}/salary/max")
    public Double getEmployeeWithMaxSalary(@PathVariable() Integer departmentId) {
        return departmentService.getMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("{departmentId}/salary/min")
    public Double getEmployeeWithMinSalary(@PathVariable() Integer departmentId) {
        return departmentService.getMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer,List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.getAllEmployeesGroupedByDepartment();
    }
}
