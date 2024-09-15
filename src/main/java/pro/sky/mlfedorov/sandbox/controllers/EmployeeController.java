package pro.sky.mlfedorov.sandbox.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mlfedorov.sandbox.services.EmployeeService;
import pro.sky.mlfedorov.sandbox.entities.Employee;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(
            @RequestParam() String firstName,
            @RequestParam() String lastName,
            @RequestParam() Integer department,
            @RequestParam() Double salary
    ) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(
            @RequestParam() String firstName,
            @RequestParam() String lastName
    ) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(
            @RequestParam() String firstName,
            @RequestParam() String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/list")
    public List<Employee> list() {
        return employeeService.findAll();
    }
}
