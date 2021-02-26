package View.RegisterView;

import Model.UserModel.ClientImplement;
import ObserverLogin.*;
import GeneralInsert.*;
import MainFrame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import View.ViewPanel;

public class RegisterAttempt extends JButton implements ActionListener, Observer, Observable, ViewPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<Observer> controllers = new ArrayList<Observer>();
    RegisterPanel panel;
    JPasswordField password;
    JPasswordField confirmPassword;
    JTextField name;
    JTextField surname;
    JTextField personalId;
    JTextField telephoneNumber;
    JTextField email;
    MainFrame frame;
    Client userModel;

    public RegisterAttempt(String Text, RegisterPanel panel, MainFrame frame, GeneralTextInsert name, GeneralPasswordInsert password,
                           GeneralTextInsert surname, GeneralTextInsert personalId, GeneralTextInsert telephoneNumber, GeneralTextInsert email, GeneralPasswordInsert confirmPassword) {
        userModel = new Client();
        this.userModel.attach(this);
        this.panel = panel;
        this.name = name;
        this.frame = frame;
        this.password = password;
        this.surname = surname;
        this.personalId = personalId;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.confirmPassword = confirmPassword;
        this.setText(Text);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setMaximumSize(new Dimension(200, 600));
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if (password.getText().equals(confirmPassword.getText())) {
                clientImplement.getUser().setName(name.getText());
                clientImplement.getUser().setSurname(surname.getText());
                clientImplement.getUser().setEmail(email.getText());
                clientImplement.getUser().setTelephoneNumber(telephoneNumber.getText());
                clientImplement.getUser().setPersonalId(personalId.getText());
                clientImplement.getUser().setPassword(password.getText());

                try {
                    this.inform();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            } else
                JOptionPane.showMessageDialog(null, "Le password non corrispondono", "Messaggio", JOptionPane.INFORMATION_MESSAGE);
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
            observer.update(this.clientImplement);
        }
    }

    @Override
    public void update(T clientImplement) {
        this.clientImplement = (ClientImplement) clientImplement;
        if (this.clientImplement.getUser().getState() == false)
            JOptionPane.showMessageDialog(null, "Email non valida");
        else
            JOptionPane.showMessageDialog(null, "Registrazione Effettutata il tuo id per accedere è " + userModel.getId());
    }

    @Override
    public MainFrame getFrame() {
        return frame;
    }


    @Override
    public JPanel getPanel() {
        return panel;
    }
}

