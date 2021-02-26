package View.ClientView.PayamentView;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Interfaccia con il riepilogo dei pagamenti
 */

public class PaymentPanel extends JPanel {

	public PaymentPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for(int i = 0; i<4; i++) { //TODO: contatore dinamico da DB		
			PaymentPanelUnit paymentUnit = new PaymentPanelUnit();
			add(paymentUnit);
		}
		
		this.setVisible(true);
	}
	
}
