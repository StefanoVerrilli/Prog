package View.GeneralComponentHomeView.MainPane;


import javax.swing.*;
import java.awt.*;

public class MainPane extends JLayeredPane {

    private static MainPane basicPanel = null;

    private MainPane() {
        this.setBounds(275,0,1000,2000);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        basicPanel = this;

    }

    public static MainPane getPane() {
        if(basicPanel == null)
            basicPanel = new MainPane();
        return basicPanel;
    }


    // TODO: Risolvere problema metodo

    public void refreshPane(JComponent pane) {
        if(basicPanel != null) {
            basicPanel.removeAll();
            basicPanel.add(pane);
            basicPanel.repaint();
            basicPanel.revalidate();
        }
    }
}