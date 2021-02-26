package Model.UserModel;



import java.sql.SQLException;

public class Client extends User {
    private String name;
    private String surname;
    private String email;
    private String personalId;
    private String telephoneNumber;
    private static final String category = "Client";

    public Client() {

    }

    public Client(String id, String password) {
        super(id, password);
    }

    public Client(String id, String password, String name, String email, String surname, String personalId,
                  String telephoneNumber) {
        super(id, password);
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.personalId = personalId;
        this.telephoneNumber = telephoneNumber;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
