package View.ClientView.HistoryView;

import GeneralInsert.GeneralImageInsert;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




/**
 * Interfaccia per le schede degli storici dei noleggi
 */

public class RentHistory extends JPanel {
	
	// TODO: Aggiungere parametri al costruttore per la creazione dinamica
	
	public RentHistory() {
		
		GridBagConstraints con = new GridBagConstraints();
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		con.insets = new Insets(5,5,5,5);

		GeneralImageInsert carImage = new GeneralImageInsert("Car.png");
		con.gridx = 0;
		con.gridy = 0;
		con.gridwidth = 3;
		con.gridheight = 4;
		con.fill = GridBagConstraints.BOTH;
		this.add(carImage, con);
		
		JLabel modello = new JLabel("Renault Modus");
		modello.setFont(new Font("Arial", Font.PLAIN, 30));
		con.gridx = 4;
		con.gridy = 0;
		con.gridwidth = 3;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		this.add(modello, con);
		
		JLabel marca = new JLabel("Renault");
		marca.setFont(new Font("Arial", Font.PLAIN, 20));
		con.gridx = 4;
		con.gridy = 1;
		con.gridwidth = 3;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		this.add(marca, con);
		
		JLabel stato = new JLabel();
		stato.setFont(new Font("Arial", Font.PLAIN, 30));
		con.gridx = 4;
		con.gridy = 2;
		con.gridwidth = 3;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		
		if(true) { // TODO: controllare se non è stato pagato il noleggio
			stato.setText("PAGATO");
			stato.setForeground(new Color(0x00AA00));
		} else {
			stato.setText("DA PAGARE");
			stato.setForeground(Color.RED);
			this.setBackground(new Color(0xFFEED6));
		}
		
		this.add(stato, con);
		
		JLabel dataNoleggio = new JLabel("22 febbraio 2021");
		con.gridx = 4;
		con.gridy = 3;
		con.gridwidth = 3;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		this.add(dataNoleggio, con);
		
		JLabel costo = new JLabel("33 €");
		costo.setFont(new Font("Arial", Font.PLAIN, 45));
		con.gridx = 7;
		con.gridy = 2;
		con.gridwidth = 2;
		con.gridheight = 1;
		con.fill = GridBagConstraints.FIRST_LINE_START;
		this.add(costo, con);
		
		JLabel numeroMinuti = new JLabel("15 minuti");
		con.gridx = 7;
		con.gridy = 3;
		con.gridwidth = 3;
		con.gridheight = 1;
		this.add(numeroMinuti, con);
		
		if(stato.getText().equals("DA PAGARE")) { // TODO: controllare se non è stato pagato il noleggio
			JButton bottonePagaNoleggio = new JButton("PAGA");
			con.gridx = 0;
			con.gridy = 4;
			con.gridwidth = 9;
			con.gridheight = 1;
			con.fill = GridBagConstraints.HORIZONTAL;
			bottonePagaNoleggio.setFocusable(false); // rimuove il bordo intorno al testo
			bottonePagaNoleggio.setBackground(new Color(0xD6E0FF));
			this.add(bottonePagaNoleggio, con);
		}
	}
}
