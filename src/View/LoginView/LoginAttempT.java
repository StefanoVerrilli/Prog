package View.LoginView;

import MainFrame.MainFrame;
import ObserverLogin.*;
import Model.UserModel.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginAttempT extends JButton implements ActionListener, Observer, Observable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    LoginPanel panel;
    JPasswordField password;
    JTextField username;
    MainFrame mainFrame;
    private ArrayList<Observer> controllers = new ArrayList<Observer>();
    private User userModel;

    LoginAttempT(String Text, LoginPanel panel, JPasswordField password, JTextField username, MainFrame frame) {
        this.userModel = new User();
        this.userModel.attach(this);
        this.panel = panel;
        this.password = password;
        this.username = username;
        this.mainFrame = frame;
        this.setText(Text);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setMaximumSize(new Dimension(200, 600));
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            String userText;
            String pwdText;
            userText = username.getText();
            pwdText = new String(password.getPassword());
            this.userModel.setId(userText);
            this.userModel.setPassword(pwdText);
            try {
                this.inform();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

        }

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public LoginPanel getPanel() {
        return panel;
    }

    @Override
    public void update(User userModel) {
        this.userModel = userModel;
        if (userModel.getState()) {
            JOptionPane.showMessageDialog(null,
                    "Login Effettuato " + userModel.getCategory() + " ID: " + userModel.getId());
        } else {
            JOptionPane.showMessageDialog(null, "ID  e/o password errati!" + userModel.getId());
        }
    }

    @Override
    public void attach(Observer observer) {
        controllers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        controllers.remove(observer);
    }

    @Override
    public void inform() throws SQLException, ClassNotFoundException {
        for (Observer observer : controllers) {
            observer.update(this.userModel);
        }
    }

}