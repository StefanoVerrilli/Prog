package CarsView;

import GeneralInsert.GeneralImageInsert;

import javax.swing.*;
import java.awt.*;

public class SingleCar extends JPanel {

    public SingleCar(){
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(1000,200));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,20,0,20);
        JLabel Nomelabel = new JLabel("Modello: Modello");
        Nomelabel.setFont(new Font("Dialog",Font.PLAIN,30));
        JLabel MarcaLabel = new JLabel("Marca: Marca");
        MarcaLabel.setFont(new Font("Dialog",Font.PLAIN,30));
        JLabel Seats = new JLabel("Numero Posti: "+"Posti");
        Seats.setFont(new Font("Dialog",Font.PLAIN,30));
        ImageIcon image = new ImageIcon("icon.png");
        Image imageScaled = image.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        image = new ImageIcon(imageScaled);
        JLabel labelImage = new JLabel();
        labelImage.setIcon(image);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 7;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(labelImage, constraints);

        constraints.gridx= 3;
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(Nomelabel, constraints);

        constraints.gridx= 3;
        constraints.gridy = 2;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(MarcaLabel, constraints);

        constraints.gridx= 3;
        constraints.gridy = 3;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(Seats, constraints);






    }
}
