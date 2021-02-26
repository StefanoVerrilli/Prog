package Controller;

import Model.ParkModel.Auto;
import Model.ParkModel.Park;
import Model.ParkModel.ParkImplement;
import View.ClientView.HomeView;
import View.ClientView.NoleggioView.NoleggioPanel;
import Model.UserModel.Client;
import ObserverPark.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParkController implements Observer {


    private ParkImplement park;
    private NoleggioPanel noleggioView;

    public ParkController(NoleggioPanel noleggioView) throws SQLException, ClassNotFoundException {

        this.noleggioView = noleggioView;
        this.noleggioView.attach(this);
        this.park = new ParkImplement();
        this.park.getParksQuery();
        this.park.attach(noleggioView);
        this.park.inform();
    }

    @Override
    public void update(ParkImplement park) {

    }
}
