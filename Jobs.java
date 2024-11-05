public class Jobs {
    //ATTRIBUTES
    private String title;
    private String department;
    private String type; // <- "Part Time", "Full Time", or "Contracted"/"N/A"
    private double pay;

    //METHODS

    public Jobs(String title, String department, String type, double pay) {
        this.title = title;
        this.department = department;
        this.type = type;
        this.pay = pay;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getType() {
        return this.type;
    }
    
    public double getPay() {
        return this.pay;
    }
}
