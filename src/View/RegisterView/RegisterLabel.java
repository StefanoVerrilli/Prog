package View.RegisterView;

import View.LoginView.LoginPanel;
import MainFrame.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class RegisterLabel extends JLabel implements MouseListener {
    Font original;
    LoginPanel panel;
    MainFrame frame;
    public RegisterLabel(LoginPanel panel, MainFrame frame){
        this.panel = panel;
        this.frame = frame;
        this.setText("Effettua Registrazione");
        this.setForeground(Color.white);
        this.setFont(new Font("Dialog",Font.PLAIN,15));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        frame.remove(panel);
        RegisterPanel register = new RegisterPanel(frame);
        frame.add(register);
        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        original = e.getComponent().getFont();
        Font font = this.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        this.setForeground(Color.blue);
        e.getComponent().setFont(original.deriveFont(attributes));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setFont(original);
        e.getComponent().setForeground(Color.white);
    }
}
