package View.AdminView;

import View.GeneralComponentHomeView.Label.LabelMenu;
import View.GeneralComponentHomeView.Panel.Panel;
import View.GeneralComponentHomeView.MouseListener.*;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLayeredPane Pain;

    public AdminView() {

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Settings for the main frame
        this.setSize(2200, 2000);

        JPanel PanelMenu = new JPanel();

        Pain = new JLayeredPane();
        Pain.setBounds(0, 0, 1000, 2000);
        Pain.setLayout(new BorderLayout());
        Pain.setBackground(Color.GREEN);
        Pain.setVisible(true);

        Panel Homepanel = new Panel();
        //NoleggioPanel Noleggio = new NoleggioPanel();
        Panel Notifichepanel = new Panel();
        Panel IncidentiPanel = new Panel();
        Panel ProfiloPanel = new Panel();

        //GeneralImageInsert Image = new GeneralImageInsert("Car.png");

        LabelMenu label = new LabelMenu(new String("ADMIN"));
        LabelMenu label1 = new LabelMenu(new String("ADMIN"));
        LabelMenu label2 = new LabelMenu(new String("ADMIN"));
        LabelMenu label3 = new LabelMenu(new String("ADMIN"));
        LabelMenu label4 = new LabelMenu(new String("ADMIN"));

        label.addMouseListener(new MenuMouseListener(label, Pain, Homepanel));
        //label1.addMouseListener(new MenuMouseListener(label1, Pain, Noleggio));
        label2.addMouseListener(new MenuMouseListener(label2, Pain, Notifichepanel));
        label3.addMouseListener(new MenuMouseListener(label3, Pain, IncidentiPanel));
        label4.addMouseListener(new MenuMouseListener(label4, Pain, ProfiloPanel));

        PanelMenu.setPreferredSize(new Dimension(275, 1000));
        PanelMenu.setMinimumSize(new Dimension(220, 220));

        PanelMenu.setLayout(new BoxLayout(PanelMenu, BoxLayout.Y_AXIS)); // Setting piled layout for the Menu
        PanelMenu.setBackground(new Color(0x0c3e28));

        PanelMenu.add(Box.createVerticalGlue());
        //PanelMenu.add(Image);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 50)));
        PanelMenu.add(label);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 5)));
        PanelMenu.add(label1);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 5)));
        PanelMenu.add(label2);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 5)));
        PanelMenu.add(label3);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 5)));
        PanelMenu.add(label4);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 50)));
        PanelMenu.add(Box.createVerticalGlue());

        Pain.add(Homepanel, BorderLayout.CENTER);
        this.add(PanelMenu);
        this.add(Pain);
        this.setVisible(true);

    }
}

