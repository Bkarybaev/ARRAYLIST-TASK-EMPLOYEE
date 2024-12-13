package employee.service.impl;

import employee.dao.impl.EmployeeDaoImpl;
import employee.exceptions.AgeException;
import employee.exceptions.JobException;
import employee.exceptions.NameException;
import employee.models.Employee;
import employee.service.EmployeeService;

public class EmployServiceImpl implements EmployeeService {
    private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    @Override
    public void saveEmployee(Employee employee) {
        try {
            try {
                //age exceptions
                if (employee.getAge() < 1) {
                    throw new AgeException("small to 0 > " + employee.getAge());
                } else if (employee.getAge() == 0) {
                    throw new AgeException("error age 0 = " + employee.getAge());
                } else if (employee.getAge() < 18) {
                    throw new AgeException("18 жаштан кичине балдар иштоого болбойт!!");
                } else if (employee.getAge() > 60 - 1) {
                    throw new AgeException("кары адамдар иштоого болбойт!!");
                }
            } catch (AgeException e) {
                throw new RuntimeException(e.getMessage());
            }

            try {
                //name exceptions
                if (employee.getName() == null || employee.getName() == "" || employee.getName().equals(" ")) {
                    throw new NameException("аты бош болуп калды!!");
                } else if (employee.getName().length() <= 3) {
                    throw new NameException("Name ото еле аз тамга болуп калды!!");
                }
            } catch (NameException e) {
                throw new RuntimeException(e.getMessage());
            }

            try {
                //job exceptions
                if (employee.getJob().equals(" ") || employee.getJob() == null || employee.getJob() == "") {
                    throw new JobException("job бош болуп калды!!");
                }
            } catch (JobException e) {
                throw new RuntimeException(e.getMessage());
            }
            employeeDao.saveEmployee(employee);
            System.out.println("Successfully");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        System.out.println(employeeDao.getAll());
    }
}
