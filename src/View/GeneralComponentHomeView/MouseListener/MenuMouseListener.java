package View.GeneralComponentHomeView.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuMouseListener implements MouseListener {
    JLayeredPane LayeredPane;
    JPanel Panel2switch;
    JLabel CallerLabel;
    public MenuMouseListener(JLabel label, JLayeredPane Pain, JPanel Panel){
        this.LayeredPane= Pain;
        this.Panel2switch=Panel;
        this.CallerLabel=label;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switchPanels(Panel2switch);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switchPanels(Panel2switch);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        CallerLabel.setBackground(new Color(116,166,145));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        CallerLabel.setBackground(new Color(0x0c3e28));
    }

    public void switchPanels(JPanel panel){
        LayeredPane.removeAll();
        LayeredPane.add(panel,BorderLayout.CENTER);
        LayeredPane.repaint();
        LayeredPane.revalidate();
    }
}
