package View.GeneralComponentHomeView.Label;

import javax.swing.*;
import java.awt.*;

public class LabelMenu extends JLabel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public LabelMenu(String Title) {
        this.setText(Title);
        this.setFont(new Font("Dialog",Font.BOLD,25));
        this.setHorizontalAlignment(CENTER);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setMaximumSize(new Dimension(275,20));
        this.setOpaque(true);
        this.setBackground(new Color(0x0c3e28));
        this.setForeground(Color.white);

    }
}



