import java.io.*;
import java.util.*;

//Set.addAll might be useful for turning sets into lists

public class PayrollLoader {
    //ATTRIBUTES
    private List<String[]> employee_list = new ArrayList<>();

    //METHODS
    public PayrollLoader( File payroll_file ) throws FileNotFoundException {

        //EXPERIMENT: MAKE PAYROLL LIST ATTRIBUTE TO USE THROUGHOUT CONSTRUCTOR
        Scanner payroll_reader = new Scanner(payroll_file);
        String header_line = payroll_reader.nextLine(); //<- Skips first line to start employee list

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

        // If there's more than 1 employee with the same name, it's good to keep them in a list
        List<Employee> all_employees = new ArrayList<>();
        String[] first_and_last = person_name.split(" ");
        String first_name = first_and_last[0];
        String last_name = first_and_last[1];

        // use for each loop to find employee (next_employee[3] == first_name, next_employee[2] == last_name)
        // keep consecutive tracks if employee has more than 1 job, then break after we counted all their jobs
        // if different employee was found with same name, print another employee????????
        // if no employee was found, return null

        Employee employee = null;
        boolean employee_found = false;
        for ( String[] next_employee : this.employee_list ) {
            if ( (next_employee[3].equals(first_name) && next_employee[2].equals(last_name)) && !employee_found) {
                employee = new Employee(next_employee[1], next_employee[2], next_employee[3]);
                employee.addJob( next_employee[4], next_employee[5], next_employee[6], Double.parseDouble(next_employee[8]) );
                employee_found = true;
            } else if ( (next_employee[3].equals(first_name) && next_employee[2].equals(last_name)) && employee_found ) {
                employee.addJob( next_employee[4], next_employee[5], next_employee[6], Double.parseDouble(next_employee[8]) );
            } else if ( !(next_employee[3].equals(first_name) && next_employee[2].equals(last_name)) && employee_found ) {
                all_employees.add(employee);
                employee_found = false;
            }
        }
        
       if ( all_employees.isEmpty() ) {
            all_employees.add(employee);
        }
        
        return all_employees;
    }
}
