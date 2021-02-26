package View.ClientView.HistoryView;

import javax.swing.*;

/**
 * Interfaccia grafica per lo storico dei noleggi
 */

public class HistoryPanel extends JPanel {
	public HistoryPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		if (true) { // TODO: Aggiungere come condizione isCurrentlyRenting() true quando vi è un noleggio in corso
			CurrentlyRentingPanel noleggioInCorso = new CurrentlyRentingPanel();
			add(noleggioInCorso);
		}
		
		for (int i = 0; i < 4 ; i++) { // TODO: iL FOR DEVE ESSERE DINAMICO A SECONDA DEGLI ELEMENTI DELLO STORICO
			RentHistory rent = new RentHistory();
			add(rent);
		}
		
		this.setVisible(true);
		
	}
}

