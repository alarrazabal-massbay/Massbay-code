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

    public void addJob( String department, String title, String type, double total_pay ) {
        jobs_list.add( new Jobs(department, title, type, total_pay) );
    }

    private double totalPay() {
        double total_pay = 0;

        for ( Jobs next_job : this.jobs_list ) {
            total_pay = total_pay + next_job.getPay();
        }
         
        return total_pay;
    }

    private String highestTitle() {

        double highest_salary = 0;
        String highest_title = "";
        String department = "";
        for ( Jobs nextJob : this.jobs_list ) {
            highest_salary = nextJob.getPay();
            highest_title = nextJob.getTitle();
            department = nextJob.getDepartment();
        }

        return highest_title;
    }
    

    @Override
    public String toString() {
        String representation = 
        "NAME (#ID): " + this.first_name + " " + this.last_name + " (#" + this.transaction_id + ")\n";
        
        int job_count = 1;
        for ( Jobs nextJob : this.jobs_list ) {
            representation = representation +
            "\nJOB " + job_count + ":" +
            "\nDepartment: " + nextJob.getDepartment() +
            "\nTitle: " + nextJob.getTitle() +
            "\nType: " + nextJob.getType() +
            "\nTotal Salary: $" + String.format("%.2f", nextJob.getPay()) + "\n";
            job_count++;
        }

        representation = representation + 
        "\nJOB SUMMERY:" +
        "\nTotal Jobs: " + this.jobs_list.size() +
        "\nTotal Salary (All Jobs): $" + String.format("%.2f", totalPay()) +
        "\nHighest Earning Job: " + highestTitle();

        return representation;
    }
}
