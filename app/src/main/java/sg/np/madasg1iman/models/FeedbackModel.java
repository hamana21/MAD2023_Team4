package sg.np.madasg1iman.models;

public class FeedbackModel {

    String name,email,remarks;

    public FeedbackModel(String name, String email, String remarks) {
        this.name = name;
        this.email = email;
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
