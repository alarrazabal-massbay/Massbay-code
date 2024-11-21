import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
                if (employee_name.contains(" ")) {
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

            //Lab 8
            PayrollSearcher payroll_search = new PayrollSearcher( payroll_loaded.getList() );
            String employee_job_department = "";
            while ( !employee_job_department.equals("quit") ) {
                System.out.print("Enter Department, Job Title, or Both to start search (Enter \"quit\" to end search): ");
                employee_job_department = input.nextLine().toLowerCase().strip();
                if ( employee_job_department.equals("department") ) {
                    System.out.print("Enter Department: ");
                    String department = input.nextLine().strip();
                    System.out.println( 
                    "Number of Employees in " + department + ": "+ payroll_search.findDepartments(department) +
                    "\nTotal Salary in Department: $" + String.format("%.2f", payroll_search.totalSalary(department) ));
                } else if ( employee_job_department.equals("job title") ) {
                    System.out.print("Enter Job Title: ");
                    String job_title = input.nextLine().strip();
                    System.out.println(
                    "Job Titles Found (" + job_title + "): " + payroll_search.findJobTitle(job_title) +
                    "\nAverage Salary (" + job_title + "): $" + String.format("%.2f", payroll_search.averageSalary(job_title)) );
                } else if ( employee_job_department.equals("both") ) {
                    System.out.print("Enter Department: ");
                    String department = input.nextLine().strip();
                    System.out.print("Enter Job Title: ");
                    String job_title = input.nextLine().strip();
                    Set<String> employees_in_department = payroll_search.findDepartmentAndTitle(department, job_title);
                    System.out.println(
                    "\nAll Employees (" + job_title + ") in " + department + 
                    "\n--------------------------------------------------------------------------");
                    int counter = 0;
                    for (String next_employee : employees_in_department ) {
                        System.out.println(next_employee);
                        counter++;
                    }
                    System.out.println("Total " + job_title + ": " + counter);
                }
            } 
        }
    }
}
