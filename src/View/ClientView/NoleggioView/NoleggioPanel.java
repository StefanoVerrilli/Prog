package View.ClientView.NoleggioView;

import Database.GenericDb;
import MainFrame.MainFrame;
import Model.ParkModel.Park;
import Model.ParkModel.ParkImplement;
import ObserverPark.Observable;
import ObserverPark.Observer;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class NoleggioPanel extends JPanel implements Observable, Observer {
    private ParkImplement park;
    private ArrayList<ObserverPark.Observer> controllers = new ArrayList<ObserverPark.Observer>();
    private SearchByCarEntry panel;


    public NoleggioPanel() throws SQLException, ClassNotFoundException {
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
        this.panel = new SearchByCarEntry();
        CustomMap map = new CustomMap() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1000, 1000);
            }
        };


        this.panel.setPreferredSize(new Dimension(1000, 50));
        map.setPreferredSize(new Dimension(1000, 600));
        //scroll.setPreferredSize(new Dimension(1000,250));
        this.add(panel, BorderLayout.NORTH);
        this.add(map, BorderLayout.CENTER);
        this.setVisible(true);
        // ArrayList<Park> data = GenericDb.getIstance().GetParkings();
    }

    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void detach(Observer observer) {

    }

    @Override
    public void inform() throws SQLException, ClassNotFoundException {
        for (ObserverPark.Observer observer: controllers) {
            observer.update(this.park);
        }
    }


    @Override
    public void update(ParkImplement park) throws SQLException, ClassNotFoundException {
        String[] columns = {"ParkName", "Indirizzo", ""};
        TableNoleggi scroll = new TableNoleggi(park.getParks(), columns);
        this.add(scroll, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
        MainFrame.getInstance().revalidate();
        MainFrame.getInstance().repaint();
    }
}