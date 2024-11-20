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

            //Lab 7
            /*
            System.out.println("\nEmployees Loaded: " + payroll_loaded.numEmployees());
            String employee_job_department = "";

            String employee_name = "";
            while (!employee_name.equals("quit")) {
                System.out.print("Enter first and last name of a State Employee (To exit, enter \"quit\"): ");
                employee_name = input.nextLine();
                if (employee_name.equals("quit")) {
                } else if (employee_name.contains(" ")) {
                    List<Employee> employees = payroll_loaded.getEmployee(employee_name);
                    int employee_num = 1;
                    for ( Employee next_employee : employees ) {
                        if (next_employee == null) {
                            System.out.println(next_employee);
                        } else{
                            System.out.print("\nEMPLOYEE #" + employee_num + "\n" + 
                            "-------------------------------------------------------------------\n");
                            System.out.println(next_employee + "\n" +
                            "-------------------------------------------------------------------\n");
                            employee_num++;
                        }
                    }
                } else {
                    System.out.println("null");
                } 
                */

            while ( !employee_job_department.equals("quit") ) {
                System.out.print("Enter Department, Job Title, or Both to search (Enter \"quit\" to end search): ");
                employee_job_department = input.nextLine().toLowerCase().strip();
                    
                if (employee_job_department.equals("quit")) {
                } else if ( employee_job_department.equals("department") ) {
                    System.out.print("Enter Department Name: ");
                    String department = input.nextLine().toLowerCase().strip();
                    payroll_loaded.search(department);
                    System.out.println(payroll_search);
                } else if ( employee_job_department.equals("job title") ) {
                    System.out.print("Enter Job Title: ");
                    String job_title = input.nextLine().toLowerCase().strip();
                    payroll_loaded.search(job_title)
                    System.out.println(payroll_search);
                } /* else if ( employee_job_department.equals("both") ) {
                    System.out.print("Enter Department: ");
                    String department = input.nextLine().toLowerCase().strip();
                    System.out.print("\nEnter Job Title: ");
                    String job_title = input.nextLine().toLowerCase().strip();
                    search_payroll.findTitleAndDepartment(department, job_title);
                }
                */
            } 
        }
    }
}
