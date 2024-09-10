package pro.sky.mlfedorov.sandbox.db;

import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.List;
import java.util.Map;

public interface DbService {
    List<Employee> convertToList(Map<String, Employee> employees);
}
