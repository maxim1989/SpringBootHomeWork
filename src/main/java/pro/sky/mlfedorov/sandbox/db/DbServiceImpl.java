package pro.sky.mlfedorov.sandbox.db;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.sandbox.emploees.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DbServiceImpl implements DbService {
    public final static Map<String, Employee> employees = new HashMap<>();

    public List<Employee> convertToList(Map<String, Employee> employees) {
        return new ArrayList<>(employees.values());
    }
}
