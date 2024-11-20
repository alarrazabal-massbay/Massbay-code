import java.io.*;
import java.util.*;

public class PayrollSearcher {
    // USE WEEK 6 CLASSES OF CLASS TO SOLVE
    
    //ATTRIBUTES
    private List<String[]> payroll_list = new ArrayList<>();

    //METHODS
    public PayrollSearcher( List<String> payroll_list ) throws FileNotFoundException {
        this.payroll_list = payroll_list;
    }

    public int findDepartment(String department_search) {
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

        return set_employee_departments.size();

    }

    public int findJobTitle(String job_title_search) {
        List<String> list_job_titles = new ArrayList<>();
        String job_title_employee;
        
        for ( String[] next_employee : this.payroll_list ) {
            job_title_employee = next_employee[5].toLowerCase();
            if ( job_title_employee.contains(job_title_search) ) {
                list_job_titles.add(next_employee[5]);
            }
        }

        return list_job_titles.size();
    }

    /*
    public void findTitleAndDepartment(String department_search, String job_title_search) {
        String department;
        String job_title;

        for ( String[] next_employee : this.payroll_list ) {
            department = next_employee[4];
            job_title = next_employee[5];
            if ( department.equals(department_search) && job_title.contains(job_title_search) ) {

            }
        } */

        
    }
    // LOOP THROUGH LIST TO ADD TOTAL SALARY
    public double totalSalary(String job_title) {
        double total_salary = 0;

        return total_salary;
    }

    public double averageSalary(String job_title) {
        double average = 0;

        return average;
    }

    }
}
