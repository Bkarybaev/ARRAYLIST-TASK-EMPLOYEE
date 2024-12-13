package employee;

import employee.models.DataBase;
import employee.models.Employee;
import employee.service.impl.EmployServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static EmployServiceImpl employService = new EmployServiceImpl();

    public static void main(String[] args) {

        while (true) {
            if (DataBase.employees.isEmpty()) {
                System.out.println("--- add Employee ---");
                save();
            } else {
                System.out.print("""
                        1.add employee
                        2.get All employ
                        0.logout
                        """);
                System.out.print("choice: ");
                String choice = new Scanner(System.in).nextLine();
                switch (choice) {
                    case "1" -> {
                        save();
                    }
                    case "2" -> {
                        employService.getAll();
                    }
                    case "0" -> {
                        System.out.println("Logout...");
                        return;
                    }
                    default -> System.out.println("Error choice!!");
                }
            }
        }


    }

    public static void save() {
        System.out.print("write name: ");
        String name = new Scanner(System.in).nextLine();


            System.out.print("write age: ");
        int age = 0;
        boolean s;

        do {
            try {
                age = new Scanner(System.in).nextInt();
                s = false;
            }catch (InputMismatchException e){
                s = true;
                System.out.print("try again write age:");
            }
        }while (s);

        System.out.print("write job: ");
        String job = new Scanner(System.in).nextLine();

        employService.saveEmployee(new Employee(name, age, job));
    }
}