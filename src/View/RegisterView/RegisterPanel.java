package View.RegisterView;

import Controller.RegisterController;
import MainFrame.MainFrame;
import GeneralInsert.*;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {

    private MainFrame mainFrame;

    public RegisterPanel(MainFrame frame) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setSize(2200, 2200);
        this.setBackground(new Color(0x028998));
        this.setVisible(true);
        mainFrame = frame;
        GeneralTextInsert name = new GeneralTextInsert("name");
        GeneralTextInsert surname = new GeneralTextInsert("surname");
        GeneralTextInsert personalId = new GeneralTextInsert("fiscal code");
        GeneralTextInsert telephoneNumber = new GeneralTextInsert("telephoneNumber");
        GeneralTextInsert email = new GeneralTextInsert("email");
        GeneralPasswordInsert password = new GeneralPasswordInsert("password");
        GeneralPasswordInsert confirmPassword = new GeneralPasswordInsert("confirm password");
        //GeneralImageInsert Image = new GeneralImageInsert("");

        this.add(Box.createVerticalGlue());
        //this.add(new GeneralImageInsert("Contact.png"));
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(name);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(surname);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(personalId);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(telephoneNumber);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(email);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(password);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(confirmPassword);
        this.add(Box.createRigidArea(new Dimension(0, 5)));

        RegisterAttempt view = new RegisterAttempt("Submit", this, mainFrame, name, password, surname, personalId, telephoneNumber , email , confirmPassword);
        this.add(view);
        RegisterController register = new RegisterController(view);
        this.add(Box.createVerticalGlue());
        this.setVisible(true);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
}