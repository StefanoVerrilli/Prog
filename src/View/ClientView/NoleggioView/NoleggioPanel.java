package View.ClientView.NoleggioView;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

import javax.swing.*;
import java.awt.*;

public class NoleggioPanel extends JPanel {

    public NoleggioPanel(){
    	
        this.setLayout(new BorderLayout());

        this.setOpaque(true);
        SearchByCarEntry panel = new SearchByCarEntry();
        String[] columns = {"ParkName","Indirizzo","Numero Macchine",""};
        Object[][] data = {
                {"Parcheggio dei drogati","Via di Francesco","104","Prenota"}
        };
        TableNoleggi scroll = new TableNoleggi(columns,data);

        CustomMap map = new CustomMap(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(1000,1000);
            }


        };


        panel.setPreferredSize(new Dimension(1000,50));
        map.setPreferredSize(new Dimension(1000,600));
        scroll.setPreferredSize(new Dimension(1000,250));
        this.add(panel,BorderLayout.NORTH);
        this.add(map,BorderLayout.CENTER);
        this.add(scroll,BorderLayout.SOUTH);


        this.setVisible(true);
    }


}
