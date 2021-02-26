package View.ClientView;


import ObserverPark.Observable;
import ObserverPark.Observer;
import Template.PanesGen;
import View.ClientView.HistoryView.HistoryPanel;
import View.ClientView.NoleggioView.NoleggioPanel;
import View.ClientView.PayamentView.PaymentPanel;
import View.GeneralComponentHomeView.Label.LabelMenu;
import View.GeneralComponentHomeView.MainPane.MainPane;
import View.GeneralComponentHomeView.MouseListener.MenuMouseListener;
import GeneralInsert.GeneralImageInsert;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class HomeView extends JPanel {
    JLayeredPane Pain;
    public NoleggioPanel Noleggio;
    public HomeView() throws SQLException, ClassNotFoundException {

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));  // Settings for the main frame
        this.setSize(2200,2000);

        JPanel PanelMenu = new JPanel();
        PanelMenu.setMinimumSize(new Dimension(275,1000));

        MainPane Pain = MainPane.getPane();

        Noleggio = new NoleggioPanel();
        HistoryPanel StoricoNoleggi = new HistoryPanel();
        PanesGen Notifichepanel = new PanesGen("Prova");
        PanesGen IncidentiPanel = new PanesGen("IncidentiPanel");
        PanesGen ProfiloPanel = new PanesGen("ProfiloPanel");
        PaymentPanel PagamentoPanel = new PaymentPanel();
        LogoutPanel Logout = new LogoutPanel();

        GeneralImageInsert Image = new GeneralImageInsert("Car.png");


        LabelMenu label = new LabelMenu(new String("NOLEGGIO"));
        LabelMenu label1 = new LabelMenu(new String("STORICO"));
        LabelMenu label2 = new LabelMenu(new String("NOTIFICHE"));
        LabelMenu label3 = new LabelMenu(new String("INCIDENTI"));
        LabelMenu label4 = new LabelMenu(new String("PROFILO"));
        LabelMenu label5 = new LabelMenu(new String("PAGAMENTI"));
        LabelMenu LogoutLabel = new LabelMenu("Logout");

        label.addMouseListener(new MenuMouseListener(label,Pain,Noleggio));
        label1.addMouseListener(new MenuMouseListener(label1,Pain,StoricoNoleggi));
        label2.addMouseListener(new MenuMouseListener(label2,Pain,Notifichepanel));
        label3.addMouseListener(new MenuMouseListener(label3,Pain,IncidentiPanel));
        label4.addMouseListener(new MenuMouseListener(label4,Pain,ProfiloPanel));
        label5.addMouseListener(new MenuMouseListener(label5,Pain,PagamentoPanel));

        PanelMenu.setPreferredSize(new Dimension(275,1000));
        PanelMenu.setMinimumSize(new Dimension(220,220));

        PanelMenu.setLayout(new BoxLayout(PanelMenu,BoxLayout.Y_AXIS));         //Setting piled layout for the Menu
        PanelMenu.setBackground(new Color(0x0c3e28));

        PanelMenu.add(Box.createVerticalGlue());
        PanelMenu.add(Image);
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
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 5)));
        PanelMenu.add(label5);
        PanelMenu.add(Box.createRigidArea(new Dimension(0, 50)));
        PanelMenu.add(LogoutLabel);
        PanelMenu.add(Box.createVerticalGlue());

        Pain.add(Noleggio,BorderLayout.CENTER);
        this.add(PanelMenu);
        this.add(Pain);
        this.setVisible(true);

    }
}
