public class Card {
    //ATTRIBUTES
    private String title;
    private String type;
    private String subtype;
    private String body;
    
    //METHODS
    public Card(String title, String type, String body) {
        this.title = title;
        this.type = type;
        this.body = body;
    }

    public String getTitle()  {
        return this.title;
    }
    
    public String getType() {
        return this.type;
    }

    public String getBody() {
        return this.body;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
