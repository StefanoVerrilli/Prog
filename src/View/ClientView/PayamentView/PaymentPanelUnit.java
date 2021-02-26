package View.ClientView.PayamentView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Singola istanza di pagamento nella scheda dei pagamenti
 */

public class PaymentPanelUnit extends JPanel {
	
	public PaymentPanelUnit() {
	
		GridBagConstraints con = new GridBagConstraints(); // costraints per il layout
	
		this.setLayout(new GridBagLayout()); // imposta il layour a GridBagLayout
		this.setBackground(new Color(0x91bba8)); // colore di sfondo della scheda
	
		con.insets = new Insets(5,5,5,5); // spazi
	
		JLabel tipologia = new JLabel("Noleggio"); // tipologia del pagamento (noleggio/indicente...)
		con.gridx = 0; // inizio posizionamento
		con.gridy = 0;
		con.gridwidth = 7;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL; // fine posizionamento
		tipologia.setFont(new Font("Arial", Font.PLAIN, 30)); // dimensione del carattere
		add(tipologia, con);
		
		JLabel numero = new JLabel("#1"); // numero o id del pagamento
		con.gridx = 8; // inizio posizionamento
		con.gridy = 0;
		con.gridwidth = 2;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL; // fine posizionamento
		add(numero, con);
		
		JLabel prezzo = new JLabel("30 €");
		con.gridx = 0; // inizio posizionamento
		con.gridy = 4;
		con.gridwidth = 9;
		con.gridheight = 2;
		con.fill = GridBagConstraints.BOTH; // fine posizionamento
		prezzo.setFont(new Font("Arial", Font.PLAIN, 50)); // dimensione del carattere
		add(prezzo, con);
		
		if(false) { // TODO: Controllare se non è stato pagato
			JLabel scadenza = new JLabel("Data di scadenza: ieri"); // data di scadenza del pagamento
			con.gridx = 0; // inizio posizionamento
			con.gridy = 6;
			con.gridwidth = 9;
			con.gridheight = 1;
			con.fill = GridBagConstraints.HORIZONTAL; // fine posizionamento
			add(scadenza, con);
		}	
		
		JButton pulsantePagamento = new JButton(); // pulsante di pagamento
		con.gridx = 0; // inizio posizionamento
		con.gridy = 7;
		con.gridwidth = 9;
		con.gridheight = 2;
		con.fill = GridBagConstraints.BOTH; // fine posizionamento
		pulsantePagamento.setFocusable(false); // rimuove il bordo intorno al testo
		pulsantePagamento.setBorder(BorderFactory.createEtchedBorder()); // bordo in stile 3D
		if(false) { // TODO: controllare se non è già pagato
			pulsantePagamento.setText("PAGA"); // aggiunge come testo del pulsante "PAGA"
		} else {
			pulsantePagamento.setText("PAGATO"); //aggiunge come testo del pulsante "PAGATO"
			pulsantePagamento.setEnabled(false); // disabilita il pulsante perché non serve
		}
		add(pulsantePagamento, con);
	}
	
}
