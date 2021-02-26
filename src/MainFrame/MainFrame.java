package MainFrame;

import Main.Main;
import View.LoginView.LoginPanel;
import Model.UserModel.User;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    /**
     *
     */
    private static MainFrame instance = null;
    private static final long serialVersionUID = 1L;
    private LoginPanel panel;

    private MainFrame() {
        this.setTitle("Car Sharing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        panel = new LoginPanel(this);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension((int)(screenSize.getWidth()/1.5),(int)(screenSize.getHeight()/1.5)));
        this.getContentPane().setBackground(new Color(0x028998));
        this.getContentPane().add(panel);
        panel.requestFocus();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static synchronized MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    public LoginPanel getPanel() {
        return panel;
    }

    public void setPanel(LoginPanel panel) {
        this.panel = panel;
    }
}