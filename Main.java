import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in); 
        System.out.print("Enter payroll file path: ");
        String payroll_path = input.nextLine();
        File payroll_file = new File(payroll_path);
        boolean payroll_exists = payroll_file.exists();

        if (payroll_exists) {
            PayrollLoader payroll_loaded = new PayrollLoader(payroll_file);
            System.out.println("Employees Loaded: " + payroll_loaded.numEmployees());
            String employee_name = "";

            while (!employee_name.equals("Quit")) {
                System.out.print("Enter first and last name of an Employee (To exit, enter \"Quit\"): ");
                employee_name = input.nextLine();
                List<Employee> employees = payroll_loaded.getEmployee(employee_name);

                for ( Employee next_employee : employees ) {
                    System.out.println(next_employee);
                }
            }
        }
    }
}
