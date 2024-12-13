package employee.dao.impl;

import employee.dao.EmployeeDao;
import employee.models.DataBase;
import employee.models.Employee;

import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void saveEmployee(Employee employee) {
        DataBase.employees.add(employee);
    }

    @Override
    public ArrayList<Employee> getAll() {
        return DataBase.employees;
    }
}
