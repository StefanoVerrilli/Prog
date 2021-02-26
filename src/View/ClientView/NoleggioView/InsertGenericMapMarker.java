package View.ClientView.NoleggioView;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

public class InsertGenericMapMarker extends MapMarkerCircle {
    public InsertGenericMapMarker(String Name, Coordinate Punto,double rad){
        super(null,Name,Punto,rad,STYLE.FIXED,getDefaultStyle());

    }

}
