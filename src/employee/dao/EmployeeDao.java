package employee.dao;

import employee.models.Employee;

import java.util.ArrayList;

public interface EmployeeDao {
    void saveEmployee(Employee employee);

    ArrayList<Employee> getAll();
}
