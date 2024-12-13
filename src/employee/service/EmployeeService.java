package employee.service;

import employee.models.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    void getAll();
}
