package View.ClientView.NoleggioView;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.GenericDb;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 * Inserisce una mappa di OpenStreetMap utilizzando JMapViewer
 */

public class CustomMap extends JMapViewer {
        private int maxZoomLevel;
        private ArrayList<Park> listMarkers;
        public CustomMap() {
            this.maxZoomLevel = 8;
            this.remove(zoomSlider);
            this.remove(zoomInButton);
            this.remove(zoomOutButton);

            Coordinate Napoli = new Coordinate(40.8395,14.25);
            try {listMarkers = GenericDb.getIstance().GetParkings();
            } catch (SQLException sqlException) { sqlException.printStackTrace();
            }

            for(int i=0;i<listMarkers.size();i++){
                String Name = listMarkers.get(i).getName();
                float Lat = listMarkers.get(i).getLatitude();
                float Long = listMarkers.get(i).getLongitude();
                Object[] array = {Lat,Long};
                this.addMapMarker(new InsertGenericMapMarker(Name,(new Coordinate(Lat,Long)),22));
            }

            this.setCenter(new Point(40,14));
            this.setScrollWrapEnabled(true);
            this.setTileSource(new OsmTileSource.TransportMap());
            this.setDisplayPosition(Napoli,18);
        }

        public int getMaxZoomLevel() {
            return maxZoomLevel;
        }

        public void setMaxZoomLevel(int maxZoom) {
            this.maxZoomLevel = maxZoom;
        }

        @Override
        public void setZoom(int zoom, Point mapPoint) {
            if (zoom > getMaxZoomLevel())
                super.setZoom(zoom, mapPoint);
        }
    }