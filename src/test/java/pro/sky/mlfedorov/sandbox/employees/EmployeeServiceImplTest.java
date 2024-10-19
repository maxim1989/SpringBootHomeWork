package pro.sky.mlfedorov.sandbox.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import pro.sky.mlfedorov.exceptions.EmployeeAlreadyAddedException;
import pro.sky.mlfedorov.exceptions.EmployeeNotFoundException;
import pro.sky.mlfedorov.exceptions.EmployeeStorageIsFullException;
import pro.sky.mlfedorov.exceptions.EmployeeValidationFailed;
import pro.sky.mlfedorov.sandbox.emploees.Employee;
import pro.sky.mlfedorov.sandbox.emploees.EmployeeServiceImpl;

import java.util.HashMap;

public class EmployeeServiceImplTest {
    EmployeeServiceImpl out = null;

    @BeforeEach
    public void initEachTest() {
        out = new EmployeeServiceImpl();
    }

    @AfterEach
    public void closeEachTest() {
        out = null;
        EmployeeServiceImpl.employees = new HashMap<>();
    }

    @Test
    public void addThreeEmployees() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        out.addEmployee("John", "Smith", 2, 2000.0);
        out.addEmployee("Ann", "Rosova", 1, 1450.4);
        assertEquals(3, out.findAll().size());
    }

    @Test
    public void employeesExists() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> out.addEmployee("Ivan", "Ivanov", 2, 1000.0)
        );
    }

    @Test
    public void employeesLimitExceeded() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        out.addEmployee("John", "Smith", 2, 2000.0);
        out.addEmployee("Ann", "Rosova", 1, 1450.4);
        assertThrows(
                EmployeeStorageIsFullException.class,
                () -> out.addEmployee("Gleb", "Kobets", 2, 1000.0)
        );
    }

    @Test
    public void removeEmployee() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        out.removeEmployee("Ivan", "Ivanov");
        assertEquals(0, out.findAll().size());
    }

    @Test
    public void removeUnExistEmployee() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee("Piter", "Ivanov"));
    }

    @Test
    public void findEmployee() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        final Employee employee = out.findEmployee("Ivan", "Ivanov");
        assertEquals(9, employee.getId());
        assertEquals("Ivan", employee.getFirstName());
        assertEquals("Ivanov", employee.getLastName());
        assertEquals(1, employee.getDepartment());
        assertEquals(1500.5, employee.getSalary());
    }

    @Test
    public void findUnExistEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee("Ivan", "Ivanov"));
    }

    @Test
    public void findAllOne() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        assertEquals(1, out.findAll().size());
    }

    @Test
    public void findAllZero() {
        assertEquals(0, out.findAll().size());
    }

    @Test
    public void searchEmployee() {
        out.addEmployee("Ivan", "Ivanov", 1, 1500.5);
        final Employee employee = out.searchEmployee("Ivan", "Ivanov");
        assertEquals(1, employee.getId());
        assertEquals("Ivan", employee.getFirstName());
        assertEquals("Ivanov", employee.getLastName());
        assertEquals(1, employee.getDepartment());
        assertEquals(1500.5, employee.getSalary());
    }

    @Test
    public void searchUnExistEmployee() {
        final Employee employee = out.searchEmployee("Ivan", "Ivanov");
        assertEquals(null, employee);
    }

    @Test
    public void validateFirstNameBlank() {
        assertThrows(EmployeeValidationFailed.class, () -> out.validateFirstName(" "));
    }

    @Test
    public void validateFirstNameEmpty() {
        assertThrows(EmployeeValidationFailed.class, () -> out.validateFirstName(""));
    }

    @Test
    public void validateFirstNameNotAlfa() {
        assertThrows(EmployeeValidationFailed.class, () -> out.validateFirstName("Mike1"));
    }

    @Test
    public void validateLastNameBlank() {
        assertThrows(EmployeeValidationFailed.class, () -> out.validateFirstName(" "));
    }

    @Test
    public void validateLastNameEmpty() {
        assertThrows(EmployeeValidationFailed.class, () -> out.validateFirstName(""));
    }

    @Test
    public void validateLastNameNotAlfa() {
        assertThrows(EmployeeValidationFailed.class, () -> out.validateFirstName("Mike1"));
    }

    @Test
    public void modifyString1() {
        assertEquals("Tom", out.modifyString("Tom"));
    }

    @Test
    public void modifyString2() {
        assertEquals("Tom", out.modifyString(" Tom"));
    }

    @Test
    public void modifyString3() {
        assertEquals("Tom", out.modifyString("tom"));
    }

    @Test
    public void modifyString4() {
        assertEquals("Tom", out.modifyString(" tom  "));
    }
}
