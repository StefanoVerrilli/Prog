package View.ClientView.HistoryView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;


import View.ClientView.NoleggioView.NoleggioPanel;
import View.GeneralComponentHomeView.MainPane.MainPane;

public class HistoryButton extends JButton implements ActionListener {
	
	
	public HistoryButton() {
	this.setFocusable(false); // rimuove il bordo intorno al testo
	this.setBackground(new Color(0x91BBA8)); // colore del pulsante
	this.setBorder(BorderFactory.createEtchedBorder()); // bordo stile 3D
	this.setText("VEDI"); // testo del pulsante
	this.addActionListener(this); // ActionListener per il pulsante
	
	}
	
	/**
	 * Pulsante che si collega alla finestra di noleggio
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this) {
			MainPane finestra = MainPane.getPane(); // si collega alla finestra principale
			try {
				finestra.refreshPane(new NoleggioPanel()); // ricarica il pannello per mostrare la finestra di noleggio
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
	}
}