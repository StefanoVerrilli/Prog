package View.GeneralComponentHomeView.Panel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Panel() {
        this.setPreferredSize(new Dimension(1000,1000));
        this.setLayout(new BorderLayout());
        this.setBounds(0,0,2000,2000);
        this.setOpaque(true);
       // CustomMap MapPanel = new CustomMap();
        this.setBackground(Color.black);
       // this.add(MapPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }
}