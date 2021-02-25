package View.LoginView;

import View.RegisterView.RegisterLabel;
import MainFrame.*;
import Model.UserModel.User;
import GeneralInsert.*;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    MainFrame frame;
    LoginAttempT Submit;

    public LoginPanel(MainFrame frame) {
        
        this.frame = frame;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setSize(2200, 2200);
        this.setBackground(new Color(0x028998));

        // GeneralImageInsert image = new GeneralImageInsert("Wiki.png");

        RegisterLabel register = new RegisterLabel(this,frame);
        GeneralTextInsert username = new GeneralTextInsert("Username");
        GeneralPasswordInsert password = new GeneralPasswordInsert("Password");
        Submit = new LoginAttempT("Submit", this, password, username, frame );

        this.add(Box.createVerticalGlue());
        // this.add(image);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(username);
        this.add(Box.createRigidArea(new Dimension(0, 4)));
        this.add(password);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(Submit);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(register);
        this.add(Box.createVerticalGlue());

        // image.requestFocus();

    }

    public LoginAttempT getSubmit() {
        return Submit;
    }


    public void RemoveAll() {
        this.removeAll();
        this.repaint();
        this.revalidate();
    }

}