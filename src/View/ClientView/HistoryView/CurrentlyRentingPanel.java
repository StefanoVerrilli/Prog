package View.ClientView.HistoryView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import LoginPackage.GeneralImageInsert;

/**
 * Interfaccia per la scheda inerente al noleggio attualmente attivo nel pannello dello storico dei noleggi
 */

public class CurrentlyRentingPanel extends JPanel {
	
	
	// TODO: Aggiungere String image, String model, String brand, int price, Date date nel costruttore sotto
		
	public CurrentlyRentingPanel() {
		
		GridBagConstraints con = new GridBagConstraints(); // costraints per il layout
		
		this.setLayout(new GridBagLayout()); // imposta il layour a GridBagLayout
		this.setBackground(new Color(0x91bba8)); // colore di sfondo della scheda
		
		con.insets = new Insets(5,5,5,5); // spazi

		//GeneralImageInsert carImage = new GeneralImageInsert("Car.png"); // immagine dell'auto
		con.gridx = 0; // inizio posizionamento
		con.gridy = 0;
		con.gridwidth = 3;
		con.gridheight = 4;
		con.fill = GridBagConstraints.BOTH; // fine posizionamento
		//this.add(carImage, con);
		
		JLabel modello = new JLabel("Renault Modus");
		modello.setFont(new Font("Arial", Font.PLAIN, 30));
		con.gridx = 4; // inizio posizionamento
		con.gridy = 0;
		con.gridwidth = 3;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL; // fine posizionamento
		this.add(modello, con);
		
		JLabel marca = new JLabel("Renault");
		marca.setFont(new Font("Arial", Font.PLAIN, 20));
		con.gridx = 4; // inizio posizionamento
		con.gridy = 1;
		con.gridwidth = 3;
		con.gridheight = 1;
		con.fill = GridBagConstraints.HORIZONTAL; // fine posizionamento
		this.add(marca, con);
		
		JLabel costo = new JLabel("23 €/min");
		costo.setFont(new Font("Arial", Font.PLAIN, 40));
		con.gridx = 7; // inizio posizionamento
		con.gridy = 2;
		con.gridwidth = 2;
		con.gridheight = 1;
		con.fill = GridBagConstraints.FIRST_LINE_START; // fine posizionamento
		this.add(costo, con);
		
		JLabel dataAvvio = new JLabel("In noleggio dalle 13:30");
		con.gridx = 7; // inizio posizionamento
		con.gridy = 3;
		con.gridwidth = 3;
		con.gridheight = 1; // fine posizionamento
		this.add(dataAvvio, con);
		
		HistoryButton pulsanteNoleggio = new HistoryButton(); // pulsante per passare alla scheda del noleggio
		con.gridx = 0; // inizio posizionamento in tutta l'ultima riga
		con.gridy = 5;
		con.gridwidth = 11;
		con.gridheight = 2;
		con.fill = GridBagConstraints.BOTH; // fine posizionamento
	
		this.add(pulsanteNoleggio, con);
	}

}
