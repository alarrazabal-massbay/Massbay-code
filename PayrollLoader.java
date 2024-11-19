import java.io.*;
import java.util.*;

public class PayrollLoader {
    //ATTRIBUTES
    private List<String[]> employee_list;

    //METHODS
    public PayrollLoader( File payroll_file ) throws FileNotFoundException {

        this.employee_list = new ArrayList<>();
        Scanner payroll_reader = new Scanner(payroll_file);
        String header_line = payroll_reader.nextLine(); //<- Skips header line to start employee list

        while ( payroll_reader.hasNext() ) {
            String[] payroll_line = payroll_reader.nextLine().split(",");
            this.employee_list.add( payroll_line );
        }
    } 

    //NOTES FOR numEmployees(): 
    //There's only 1 transaction ID number associated to 1 person, so if one person has multiple jobs when going down the list, their Trans ID will be the same until there's a different person
    //  ^ This is useful when a person has the same exact name as another person even though they're different people, so use Trans ID to differentiate employees.

    public int numEmployees() {

        Set<String> trans_id_set = new HashSet<>();

        for ( String[] next_employee : this.employee_list ) {
            trans_id_set.add(next_employee[1]);
        }

        int num_of_employees = trans_id_set.size();
        return num_of_employees;
    }

    public List<Employee> getEmployee( String person_name ) {

        // If there's more than 1 employee with the same name, it's good to keep them in a list and return it

        List<Employee> all_employees = new ArrayList<>();
        String[] first_and_last = person_name.split(" ");
        String first_name = first_and_last[0];
        String last_name = first_and_last[1];

        // use for each loop to find employee (next_employee[3] == first_name, next_employee[2] == last_name, next_employee[1] == trans_id)
        // keep consecutive track of employee if they have more than 1 job (use Trans ID to keep track)
        // if different employee was found with the same name, construct another employee and append
        // if no employee was found, return null

        Employee employee = null;
        String trans_id = "";
        for ( String[] next_employee : this.employee_list ) {
            if ( (next_employee[3].equals(first_name) && next_employee[2].equals(last_name)) && !next_employee[1].equals(trans_id) ) {
                employee = new Employee(next_employee[1], next_employee[2], next_employee[3]);
                all_employees.add(employee);
                trans_id = next_employee[1];
                employee.addJob( next_employee[4], next_employee[5], next_employee[6], Double.parseDouble(next_employee[8]) );
            } else if ( (next_employee[3].equals(first_name) && next_employee[2].equals(last_name)) && next_employee[1].equals(trans_id) ) {
                employee.addJob( next_employee[4], next_employee[5], next_employee[6], Double.parseDouble(next_employee[8]) );
            }
        }
        
       if ( all_employees.isEmpty() ) {
            all_employees.add(employee);
        }
        
        return all_employees;
    }

    //lab 8
    public List<String> search(String job_department) {
        Scanner input = new Scanner(System.in);
        PayrollSearcher search_employees = new PayrollSearcher(this.employee_list);
        List<String> employee_list = new ArrayList<>();

        if ( job_department.equals("department") ) {
            System.out.print("Enter Department: ");
            String department = input.nextLine();
            employee_list = search_employees.findDepartment(department);
        } else if ( job_department.equals("job title") ) {
            System.out.print("Enter Job Title: ");
            String job_title = input.nextLine();
            employee_list = search_employees.findJobTitle(job_title);
        } else if ( job_department.equals("both") ) {
            employee_list = search_employees.findTitleAndDepartment();
        }

        return employee_list;
    }
}
