package View.ClientView.NoleggioView;

import Database.GenericDb;
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

public class NoleggioPanel extends JPanel {

    public NoleggioPanel() throws SQLException {
    	
        this.setLayout(new BorderLayout());

        this.setOpaque(true);
        SearchByCarEntry panel = new SearchByCarEntry();
        String[] columns = {"ParkName","Indirizzo","Prova"};

        ArrayList<Park> data = GenericDb.getIstance().GetParkings();

        TableNoleggi scroll = new TableNoleggi(data,columns);

        CustomMap map = new CustomMap(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(1000,1000);
            }


        };


        panel.setPreferredSize(new Dimension(1000,50));
        map.setPreferredSize(new Dimension(1000,600));
        //scroll.setPreferredSize(new Dimension(1000,250));
        this.add(panel,BorderLayout.NORTH);
        this.add(map,BorderLayout.CENTER);
        this.add(scroll,BorderLayout.SOUTH);


        this.setVisible(true);
    }


}
