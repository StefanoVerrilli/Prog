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
    	this.setTitle("Car Sharing"); // nome dell'applicazione
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiudi l'applicazione con il tasto X della finestra
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        panel = new LoginPanel(this);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.getContentPane().add(panel);
        this.setPreferredSize(new Dimension((int)(screenSize.getWidth()/1.5),(int)(screenSize.getHeight()/1.5))); // dimensione della finestra
        this.getContentPane().setBackground(new Color(0xd7888b8)); // colore di sfondo dell'applicazione
        this.setExtendedState(MAXIMIZED_BOTH); // mette la finestra a schermo intero se possibile
        this.pack();
        this.setLocationRelativeTo(null);
        panel.requestFocus();
        this.setVisible(true);
        
        
        
        
        ImageIcon icona = new ImageIcon("icon.png"); // icona dell'applicazione
        this.setIconImage(icona.getImage()); // imposta l'icona dell'applicazione
    	
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