package ObserverPark;

import Model.ParkModel.Park;
import Model.ParkModel.ParkImplement;

import java.sql.SQLException;
import java.util.ArrayList;

public  interface Observer{
    public void update ( ParkImplement park) throws SQLException, ClassNotFoundException;
}