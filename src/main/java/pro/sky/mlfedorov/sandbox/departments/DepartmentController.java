package pro.sky.mlfedorov.sandbox.departments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mlfedorov.sandbox.db.DbService;
import pro.sky.mlfedorov.sandbox.db.DbServiceImpl;
import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    final DbService dbService;

    public DepartmentController(DepartmentService departmentService, DbService dbService) {
        this.departmentService = departmentService;
        this.dbService = dbService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam() Integer departmentId) {
        final List<Employee> employees = dbService.convertToList(DbServiceImpl.employees);
        return departmentService.getEmployeeWithMaxSalary(departmentId, employees);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam() Integer departmentId) {
        final List<Employee> employees = dbService.convertToList(DbServiceImpl.employees);
        return departmentService.getEmployeeWithMinSalary(departmentId, employees);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(@RequestParam(required = false) Integer departmentId) {
        final List<Employee> employees = dbService.convertToList(DbServiceImpl.employees);
        return departmentService.getAllEmployees(departmentId, employees);
    }
}
