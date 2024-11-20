import java.io.*;
import java.util.*;

public class PayrollSearcher {
    // Make List for every function instead of making an attribute 

    //ATTRIBUTES
    private List<String[]> payroll_list = new ArrayList<>();
    private int departments_found;
    private int job_titles_found;
    private List<Employee> employee_list = new ArrayList<>();

    //METHODS
    public PayrollSearcher( File payroll_file ) throws FileNotFoundException {
        Scanner payroll_reader = new Scanner(payroll_file);
        String header_line = payroll_reader.nextLine(); //<- Skips header line to start employee list

        while ( payroll_reader.hasNext() ) {
            String[] payroll_line = payroll_reader.nextLine().split(",");
            this.payroll_list.add( payroll_line );
        }

        this.departments_found = 0;
        this.job_titles_found = 0;
    }

    public void findDepartment(String department_search) {
        Set<String> set_employee_departments = new HashSet<>();
        String trans_id;
        String department_employee;

        for ( String[] next_employee : this.payroll_list ) {
            department_employee = next_employee[4].toLowerCase();
            if ( department_employee.equals(department_search) ) {
                trans_id = next_employee[1];
                set_employee_departments.add(trans_id);
            }
        }

        this.departments_found = set_employee_departments.size();

    }

    public void findJobTitle(String job_title_search) {
        List<String> list_job_titles = new ArrayList<>();
        String job_title_employee;
        
        for ( String[] next_employee : this.payroll_list ) {
            job_title_employee = next_employee[5].toLowerCase();
            if ( job_title_employee.contains(job_title_search) ) {
                list_job_titles.add(next_employee[5]);
            }
        }

        this.job_titles_found = list_job_titles.size();
    }

    public void findTitleAndDepartment(String department_search, String job_title_search) {
        String department;
        String job_title;

        for ( String[] next_employee : this.payroll_list ) {
            department = next_employee[4];
            job_title = next_employee[5];
            if ( department.equals(department_search) && job_title.contains(job_title_search) ) {
                /*
                make employee
                add employee to the list
                 */

                Employee employee = new Employee(next_employee[1], next_employee[2], next_employee[3]);
                employee.addJob(department, job_title, next_employee[6], Double.parseDouble(next_employee[8]));
                this.employee_list.add(employee);
            }
        }

        
    }

    public double totalSalary(double pay) {
        double total_salary = 0;

        return total_salary;
    }

    public double averageSalary() {
        double average = 0;

        return average;
    }

    @Override
    public String toString() {
        String representation = "";

        if ( this.departments_found > 0 && this.job_titles_found == 0 ) {
            representation = representation +
            "Number of Employees in Department: " + this.departments_found;
        } else if ( this.departments_found == 0 && this.job_titles_found > 0 ) {
            representation = representation +
            "Number of Employees with Job Title: " + this.job_titles_found;
        } else if ( !employee_list.isEmpty() ) {
            representation = representation + 
            "List of All Employees in Department";
            for ( Employee next_employee : this.employee_list ) {
                // representation = representation + 
                // #. "\n" get employee name - get employee job titles
            }
        }

        return representation;
    }
}
