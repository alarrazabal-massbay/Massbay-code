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
            System.out.println("\nEmployees Loaded: " + payroll_loaded.numEmployees());
            String employee_name = "";

            //lab 7
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

                //lab 8
                while ( !employee_job_department.equals("quit") ) {
                System.out.print("Search by Department, Job Title, or Both? (Enter \"quit\" to end search): ");
                employee_job_department = input.nextLine().toLowerCase();
                
                if (employee_job_department.equals("quit")){
                } else {
                    payroll_loaded.search(employee_job_department);
                }
            }
        }
    }
}

/*
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{

    public static void main(args []) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);


        //Ask for the payroll file location
        System.out.println(" Enter the path to the state payroll file: ");

        String filePath = scanner.nextLine();

        File payrollFile = new File(filePath);

        boolean doesFileActuallyExist = payrollFile.exists();

        //Check if the file exist
        if (doesFileActuallyExist){

            PayrollLoader fileLoaded = new PayrollLoader(payrollFile);

            while (true) {

                System.out.println("Enter first name (or 'quit' to exit): ");
                String firstName = scanner.nextLine();
                System.out.println("Enter last name: ");
                String lastName = scanner.nextLine();
            }

            List<Employee> matchingEmployee = new ArrayList<>();
            
            matchingEmployee.add( searchEmployee(employee, firstName, lastName) );

            if (matchingEmployee.isEmpty()){

                System.out.println("No matching Employee found ");
            }

            fileLoaded.close();
        }else{

            System.out.println("Matching Employee ");

            for (Employee employee : matchingEmployee){

                System.out.println(employee);
            }
        }

    }  
}
*/
