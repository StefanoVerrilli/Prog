package View.ClientView.NoleggioView;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.Style;

import java.awt.*;

public class InsertGenericMapMarker extends MapMarkerCircle {
    public InsertGenericMapMarker(String Name, Coordinate Punto,double rad){
        super(null,Name,Punto,rad,STYLE.FIXED,getDefaultStyle());
        this.getStyle().setColor(Color.red);
        this.setBackColor(Color.red);
    }

}
