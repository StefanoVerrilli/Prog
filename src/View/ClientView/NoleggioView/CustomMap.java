package View.ClientView.NoleggioView;

import java.awt.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 * Inserisce una mappa di OpenStreetMap utilizzando JMapViewer
 */

public class CustomMap extends JMapViewer {
        private int maxZoomLevel;

        public CustomMap() {
            this.maxZoomLevel = 8;
            this.remove(zoomSlider);
            this.remove(zoomInButton);
            this.remove(zoomOutButton);

            Coordinate Napoli = new Coordinate(40.8395,14.25);
            this.setCenter(new Point(40,14));
            InsertGenericMapMarker marker= new InsertGenericMapMarker(null,Napoli,22);
            Style stile = marker.getStyle();
            stile.setColor(Color.red);
            this.setScrollWrapEnabled(true);
            stile.setBackColor(Color.yellow);
            this.addMapMarker(marker);
            InsertGenericMapMarker marker2 = new InsertGenericMapMarker(null,Napoli,16);
            marker2.getStyle().setBackColor(Color.RED);
            this.addMapMarker(marker2);
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