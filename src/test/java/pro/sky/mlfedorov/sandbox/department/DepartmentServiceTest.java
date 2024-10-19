package pro.sky.mlfedorov.sandbox.department;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.mlfedorov.exceptions.EmployeeNotFoundException;
import pro.sky.mlfedorov.sandbox.emploees.Employee;
import pro.sky.mlfedorov.sandbox.emploees.EmployeeServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private final EmployeeServiceImpl employeeServiceMock = mock(EmployeeServiceImpl.class);

    @InjectMocks
    private DepartmentServiceImpl out;

    final Employee employee1 = new Employee("Ivan", "Ivanov", 1, 1500.5);
    final Employee employee2 = new Employee("John", "Smith", 2, 2000.0);
    final Employee employee3 = new Employee("Ann", "Rosova", 1, 1450.4);
    final List<Employee> employees = new ArrayList<Employee>(Arrays.asList(employee1, employee2, employee3));
    final List<Employee> employees1 = new ArrayList<Employee>(Arrays.asList(employee1, employee3));
    final List<Employee> employees2 = new ArrayList<Employee>(Arrays.asList(employee2));
    final List<Employee> employees3 = new ArrayList<Employee>(Arrays.asList());

    @Test
    public void getMaxSalaryByDepartmentOne() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertEquals(1500.5, out.getMaxSalaryByDepartment(1));
        verify(employeeServiceMock, only()).findAll();
    }

    @Test
    public void getMaxSalaryByDepartmentTwo() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertEquals(2000, out.getMaxSalaryByDepartment(2));
        verify(employeeServiceMock, only()).findAll();
    }

    @Test
    public void getMaxSalaryByDepartmentThree() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryByDepartment(3));
        verify(employeeServiceMock, only()).findAll();
    }

    @Test
    public void getMinSalaryByDepartmentOne() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertEquals(1450.4, out.getMinSalaryByDepartment(1));
        verify(employeeServiceMock, only()).findAll();
    }

    @Test
    public void getMinSalaryByDepartmentTwo() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertEquals(2000, out.getMinSalaryByDepartment(2));
        verify(employeeServiceMock, only()).findAll();
    }

    @Test
    public void getMinSalaryByDepartmentThree() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryByDepartment(3));
        verify(employeeServiceMock, only()).findAll();
    }

    @Test
    public void getAllEmployeesGroupedByDepartment() {
        final List<Employee> department1 = new ArrayList<>(Arrays.asList(employee1, employee3));
        final List<Employee> department2 = new ArrayList<>(Arrays.asList(employee2));
        final Map<Integer, List<Employee>> integerListMap = new HashMap<>();
        integerListMap.put(1, department1);
        integerListMap.put(2, department2);
        when(employeeServiceMock.findAll())
                .thenReturn(employees);
        assertEquals(integerListMap, out.getAllEmployeesGroupedByDepartment());
    }

    @Test
    public void getAllEmployeesGroupedByDepartmentEmpty() {
        final Map<Integer, List<Employee>> integerListMap = new HashMap<>();
        when(employeeServiceMock.findAll())
                .thenReturn(new ArrayList<>());
        assertEquals(integerListMap, out.getAllEmployeesGroupedByDepartment());
    }

    @Test
    public void getEmployeesByDepartmentOne() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees1);
        assertEquals(employees1, out.getEmployeesByDepartment(1));
    }

    @Test
    public void getEmployeesByDepartmentTwo() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees2);
        assertEquals(employees2, out.getEmployeesByDepartment(2));
    }

    @Test
    public void getEmployeesByDepartmentThree() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees3);
        assertEquals(employees3, out.getEmployeesByDepartment(3));
    }

    @Test
    public void getSumSalariesByDepartmentOne() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees1);
        assertEquals(2950.9, out.getSumSalariesByDepartment(1));
    }

    @Test
    public void getSumSalariesByDepartmentTwo() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees2);
        assertEquals(2000.0, out.getSumSalariesByDepartment(2));
    }

    @Test
    public void getSumSalariesByDepartmentThree() {
        when(employeeServiceMock.findAll())
                .thenReturn(employees3);
        assertEquals(0, out.getSumSalariesByDepartment(3));
    }
}
