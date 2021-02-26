package View;

import MainFrame.MainFrame;
import View.GeneralComponentHomeView.Panel.Panel;

import javax.swing.*;

public interface ViewPanel {
    public JPanel getPanel();

    public MainFrame getFrame();
}
