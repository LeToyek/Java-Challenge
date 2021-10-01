
public class Messages {
    private String text;
    private String contactName;
    private int id;

    public Messages(String text, String contactName, int id) {
        this.text = text;
        this.contactName = contactName;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("Contact Name\t: " + contactName +
                "\nMessages\t\t: " + text +
                "\nid\t\t\t: " + id);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
