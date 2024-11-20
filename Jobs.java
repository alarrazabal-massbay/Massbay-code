public class Jobs {
    //ATTRIBUTES
    private String department;
    private String title;
    private String type; // <- "Part Time", "Full Time", or "Contracted"/"N/A"
    private double pay;

    //METHODS
    public Jobs(String department, String title, String type, double pay) {
        this.department = department;
        this.title = title;
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
