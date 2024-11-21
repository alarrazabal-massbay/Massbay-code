import java.io.*;
import java.util.*;

public class PayrollSearcher {
    // USE WEEK 6 CLASSES OF CLASS TO SOLVE
    
    //ATTRIBUTES
    private List<String[]> payroll_list = new ArrayList<>();
    private int num_departments;

    //METHODS
    public PayrollSearcher( List<String[]> payroll_list ) throws FileNotFoundException {
        this.payroll_list = payroll_list;
        this.num_departments = 0;
    }

    public int findDepartments(String department_search) {
        Set<String> set_employee_departments = new HashSet<>();
        String trans_id;
        String department_employee;

        for ( String[] next_employee : this.payroll_list ) {
            department_employee = next_employee[4];
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
            job_title_employee = next_employee[5];
            if ( job_title_employee.contains(job_title_search) ) {
                list_job_titles.add(next_employee[5]);
            }
        }

        return list_job_titles.size();
    }

    public Set<String> findDepartmentAndTitle(String department_search, String job_title_search) {
        Set<String> all_employees = new HashSet<>();
        String department;
        String job_title;
        String name_first;
        String name_last;
        String trans_id;
        
        for ( String[] next_employee : this.payroll_list ) {
            department = next_employee[4];
            job_title = next_employee[5];
            if ( department.equals(department_search) && job_title.contains(job_title_search) ) {
                name_first = next_employee[3];
                name_last = next_employee[2];
                trans_id = next_employee[1];
                all_employees.add(name_first + " " + name_last + " (ID: #" + trans_id + ")" + " - " + job_title);
            }
        } 
        
        return all_employees;
    }

    public double totalSalary(String department_search) {
        double total_salary = 0;
        double pay_double;
        String department;
        

        // ERROR IN LINE 9536 IN payroll.csv FILE: EXTRA COMMA WAS ADDED IN POSITION TITLE
        for ( String[] next_employee : this.payroll_list ) {
            department = next_employee[4];
            if ( department.contains(department_search) ) {
                pay_double = Double.parseDouble(next_employee[8]);
                total_salary = total_salary + pay_double;
            }
        }

        return total_salary;
    }

    public double averageSalary(String job_title_search) {
        double pay_average = 0;
        double pay;
        String job_title;

        double num_job_titles = 0;
        for ( String[] next_employee : this.payroll_list ) {
            job_title = next_employee[5];
            if ( job_title.contains(job_title_search) ) {
                pay = Double.parseDouble(next_employee[8]);
                pay_average = pay_average + pay;
                num_job_titles++;
            }
        }

        pay_average = pay_average / num_job_titles;

        return pay_average;
    }

}
