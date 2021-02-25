package GeneralInsert;

import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class GeneralPasswordInsert extends JPasswordField implements FocusListener {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    GeneralPasswordInsert instance;
    String text;
    String input;
    public GeneralPasswordInsert(String text) {
        this.setEchoChar((char)0);
        this.setForeground(Color.gray);
        this.setText(text);
        this.text = text;
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setMaximumSize(new Dimension(300, 1000));
        this.setHighlighter(null);
        this.setFont(new Font("Dialog", Font.ITALIC, 20));
        instance = this;
        this.addFocusListener(this);
}

    @Override
    public void focusGained(FocusEvent e) {
        input = new String(this.getPassword());
        if(input.equals(text)){
            this.setEchoChar('*');
            this.setForeground(Color.black);
            setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        input = new String(this.getPassword());
        if(input.equals("")){
            this.setEchoChar((char)0);
            this.setForeground(Color.gray);
            setText(text);
        }

    }
}
