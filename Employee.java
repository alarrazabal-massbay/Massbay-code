import java.util.*;

public class Employee {
    //ATTRIBUTES
    private String transaction_id;
    private String last_name;
    private String first_name;
    private List<Jobs> jobs_list = new ArrayList<>(); //<- an employee might have 1 or more jobs

    //METHODS
    public Employee( String id, String last, String first ) {
        this.transaction_id = id;
        this.last_name = last;
        this.first_name = first;
    }

    public void addJob( String department, String position, String type, double total_pay ) {
        jobs_list.add( new Jobs(department, position, type, total_pay) );
    }

    private double totalPay() {
        double total_pay = 0;

        for ( Jobs next_job : this.jobs_list ) {
            total_pay = total_pay + next_job.getPay();
        }

        return total_pay;
    }

    @Override
    public String toString() {
        String representation = 
        "Employee: " + this.first_name + " " + this.last_name;

        /*
        "\nTotal Jobs: " + jobs_list.size() +
        "\nTotal Salary: " + totalPay();
        
        String highest_title = "";
        */

        for (int i=0; i < this.jobs_list.size(); i++) {
            representation = representation +
            "\nJob " + (i + 1) + ":" +
            "\nTitle: " + jobs_list.get(i).getTitle() +
            "\nDepartment: " + jobs_list.get(i).getDepartment() +
            "\nType: " + jobs_list.get(i).getType() +
            "\nAnnual Pay: " + jobs_list.get(i).getPay();

            /* 
            if ( this.jobs_list.get(i).getPay() > highest_salary ) {
                highest_salary = this.jobs_list.get(i).getPay();
                highest_title = this.jobs_list.get(i).getTitle();
            }
            */
        }

        /*
        "\nHighest Earning Job: " + highest_title;
        */
        
        return representation;
    }
}