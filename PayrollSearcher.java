import java.util.*;

public class PayrollSearcher {
    // Make List for every function instead of making an attribute 

    //ATTRIBUTES
    private List<String[]> employee_list = new ArrayList<>();

    //METHODS
    public PayrollSearcher( List<String[]> employee_list) {
        this.employee_list = employee_list;
    }

    public List<String> findDepartment(String department) {
        List<String> list_department = new ArrayList<>();
        for (int i=0; i < this.employee_list.size() - 1; i++) {
        }

        return list_department;
    }

    public List<String> findJobTitle(String job_title) {
        List<String> list_job_title = new ArrayList<>();

        return job_title;
    }

    public List<String> findTitleAndDepartment() {

        return employee;
    }

    private double calculateSalary() {
        double salary = 0;

        return salary;
    }

    private double averageSalary() {
        double average = 0;

        return average;
    }
}
