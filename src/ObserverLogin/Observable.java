package ObserverLogin;

import java.sql.SQLException;

public interface Observable {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void inform() throws SQLException, ClassNotFoundException;
}
