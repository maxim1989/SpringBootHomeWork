package pro.sky.mlfedorov.sandbox.emploees;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.exceptions.EmployeeAlreadyAddedException;
import pro.sky.mlfedorov.exceptions.EmployeeNotFoundException;
import pro.sky.mlfedorov.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final Map<String, Employee> employees;
    final int MAX_EMPLOYEES_AMOUNT = 3;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() == MAX_EMPLOYEES_AMOUNT) {
            throw new EmployeeStorageIsFullException("EmployeeServiceImpl.addEmployee: storage limit exceeded");
        }

        if (searchEmployee(firstName, lastName) != null) {
            throw new EmployeeAlreadyAddedException("EmployeeServiceImpl.addEmployee: employee exists");
        }

        final Employee employee = new Employee(firstName, lastName);
        employees.put(firstName + "_" + lastName, employee);

        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        final Employee employee = searchEmployee(firstName, lastName);

        if (employee != null) {
            employees.remove(firstName + "_" + lastName);
        } else {
            throw new EmployeeNotFoundException("EmployeeServiceImpl.removeEmployee: employee not found");
        }

        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        final Employee employee = searchEmployee(firstName, lastName);

        if (employee != null) {
            return employee;
        }

        throw new EmployeeNotFoundException("EmployeeServiceImpl.findEmployee: employee not found");
    }

    public List<Employee> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    private Employee searchEmployee(String firstName, String lastName) {
        return employees.getOrDefault(firstName + "_" + lastName, null);
    }
}
