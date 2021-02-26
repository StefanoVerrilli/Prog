package GeneralInsert;

import javax.swing.*;
import java.awt.*;

public class GeneralImageInsert extends JLabel {

    public GeneralImageInsert(String path){
        ImageIcon Image = new ImageIcon(path);
        this.setIcon(Image);
        //this.setHorizontalAlignment(CENTER);
        //this.setAlignmentX(Component.CENTER_ALIGNMENT);
        //this.setMaximumSize(new Dimension(300,1000));

    }
}
