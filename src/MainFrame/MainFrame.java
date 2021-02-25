package MainFrame;

import View.LoginView.LoginPanel;
import Model.UserModel.User;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private LoginPanel panel;

    public MainFrame() {
        this.setTitle("Car Sharing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        panel = new LoginPanel(this);
        //this.setMinimumSize(new Dimension(1200,940));
        this.getContentPane().setBackground(new Color(0x028998));
        this.getContentPane().add(panel);
        //this.setSize(1200, 955);
        this.setVisible(true);
        panel.requestFocus();

    }

    public LoginPanel getPanel() {
        return panel;
    }

    public void setPanel(LoginPanel panel) {
        this.panel = panel;
    }
}