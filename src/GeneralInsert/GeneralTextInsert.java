package GeneralInsert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class GeneralTextInsert extends JTextField implements FocusListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    GeneralTextInsert instance;
    String default1;

    public GeneralTextInsert(String text) {
        this.setText(text);
        this.default1 = text;
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setForeground(Color.gray);
        this.setMaximumSize(new Dimension(300, 1000));
        this.setFont(new Font("Dialog", Font.ITALIC, 20));
        this.addFocusListener(this);
        instance = this;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(default1)) {
            this.setForeground(Color.black);
            this.setText("");

        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            this.setForeground(Color.gray);
            this.setText(default1);
        }
    }
}