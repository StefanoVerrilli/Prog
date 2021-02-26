package View.ClientView.NoleggioView;

import GeneralInsert.GeneralTextInsert;


import javax.swing.*;
import java.awt.*;

public class SearchByCarEntry extends JPanel{

    SearchByCarEntry(){
        this.setBounds(0,0,1000,1000);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton buttonSBC = new JButton("Search Car");
        GeneralTextInsert GeneralText =new GeneralTextInsert("Search Car");
        buttonSBC.setOpaque(true);
        buttonSBC.setPreferredSize(new Dimension(90,35));
        GeneralText.setPreferredSize(new Dimension(200,35));
        this.add(GeneralText);
        this.add(buttonSBC);

    }
}
