package pro.sky.mlfedorov.sandbox.emploees;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.exceptions.EmployeeAlreadyAddedException;
import pro.sky.mlfedorov.exceptions.EmployeeNotFoundException;
import pro.sky.mlfedorov.exceptions.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import pro.sky.mlfedorov.exceptions.EmployeeValidationFailed;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static Map<String, Employee> employees = new HashMap<>();
    final int MAX_EMPLOYEES_AMOUNT = 3;

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Double salary) {
        validateFirstName(firstName);
        validateLastName(lastName);
        String newFirstName = modifyString(firstName);
        String newLastName = modifyString(lastName);
        if (employees.size() == MAX_EMPLOYEES_AMOUNT) {
            throw new EmployeeStorageIsFullException("EmployeeServiceImpl.addEmployee: storage limit exceeded");
        }

        if (searchEmployee(newFirstName, newLastName) != null) {
            throw new EmployeeAlreadyAddedException("EmployeeServiceImpl.addEmployee: employee exists");
        }

        final Employee employee = new Employee(newFirstName, newLastName, department, salary);
        employees.put(newFirstName + "_" + newLastName, employee);

        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        validateFirstName(firstName);
        validateLastName(lastName);
        String newFirstName = modifyString(firstName);
        String newLastName = modifyString(lastName);
        final Employee employee = searchEmployee(newFirstName, newLastName);

        if (employee != null) {
            employees.remove(newFirstName + "_" + newLastName);
        } else {
            throw new EmployeeNotFoundException("EmployeeServiceImpl.removeEmployee: employee not found");
        }

        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        validateFirstName(firstName);
        validateLastName(lastName);
        String newFirstName = modifyString(firstName);
        String newLastName = modifyString(lastName);
        final Employee employee = searchEmployee(newFirstName, newLastName);

        if (employee != null) {
            return employee;
        }

        throw new EmployeeNotFoundException("EmployeeServiceImpl.findEmployee: employee not found");
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees.values());
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        return employees.getOrDefault(firstName + "_" + lastName, null);
    }

    @Override
    public void validateFirstName(String name) {
        if (StringUtils.isBlank(name) | StringUtils.isEmpty(name)) {
            throw new EmployeeValidationFailed("EmployeeServiceImpl.validateFirstName: name is blank");
        }

        if (!StringUtils.isAlpha(name)) {
            throw new EmployeeValidationFailed("EmployeeServiceImpl.validateFirstName: name is not alpha");
        }
    }

    @Override
    public void validateLastName(String name) {
        if (StringUtils.isBlank(name) | StringUtils.isEmpty(name)) {
            throw new EmployeeValidationFailed("EmployeeServiceImpl.validateLastName: last name is blank");
        }

        if (!StringUtils.isAlpha(name)) {
            throw new EmployeeValidationFailed("EmployeeServiceImpl.validateLastName: name is not alpha");
        }
    }

    @Override
    public String modifyString(String value) {
        String newValue = StringUtils.trim(value);
        newValue = StringUtils.strip(newValue);
        String firstLetter = StringUtils.substring(newValue, 0, 1);

        if (StringUtils.isAllUpperCase(firstLetter)) {
            return newValue;
        } else {
            return StringUtils.capitalize(newValue);
        }
    }
}
