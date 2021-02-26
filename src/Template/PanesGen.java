package Template;



import javax.swing.*;
import java.awt.*;

public class PanesGen extends JPanel {
    String title;
    public PanesGen(String Title){
        this.title =Title;
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        JLabel Front = new JLabel(title);
        Front.setAlignmentX(CENTER_ALIGNMENT);
        Front.setAlignmentY(CENTER_ALIGNMENT);
        this.setBackground(Color.yellow);

        this.add(Box.createVerticalGlue());
        this.add(Front);
        this.add(Box.createVerticalGlue());
        this.setVisible(true);
    }
}
