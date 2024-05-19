/**
 * Miza.java
 *
 * Opis:
 * Program za prikaz delovanja GUI
 * na primeru razredov poslovne logike Steklenica in PivskaSteklenica
 *
 */

// Uvozimo vse razrede in pakete za delo z V/I napravami, pripomočke, GUI, dogodke in tabele
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

/**
 * Javni razred za zagon uporabniškega vmesnika
 *
 * @author Sebastjan Kreže
 * @version Primer 20 (Grafični uporabniški vmesnik in dogodki)
 */
public class Miza extends JFrame implements ActionListener {

	/**
	 * Glavna površina okna
	 */
	private JPanel povrsina;

	/**
	 * Gumb za dodajanje nove pivske steklenice v tabelo
	 */
	private JButton dodajButton;

	/**
	 * Tekstovno polje za vnos znamke piva
	 */
	private JTextField znamkaVnos;
	
	/**
	 * Tekstovno polje za vnos vsebine alkohola
	 */
	private JTextField alkoholVnos;

	/**
	 * Tabela za prikaz pivskih steklenic
	 */
	private JTable tabela;

	/**
	 * Model tabele za prikaz pivskih steklenic
	 */
	private PivskaSteklenicaTableModel modelTabele;
	
	/** Javna statična metoda, ki se izvede ob zagonu programa
	 * @param args Seznam nizov (vhodnih argumentov), ki jih vnesemo ob zagonu programa
	 */
	public static void main(String[] args) {

		// Izpišemo pozdrav v konzolo
		System.out.println("Zaganjam GUI...");

		// Ustvarimo objekt tipa miza (kličemo konstruktor razred Miza)
		Miza m = new Miza();
	}
	
	/** Javni konstruktor za ustvarjanje novega okna s prikazom steklenic
	 */
	public Miza() {

		// Pokličemo konstruktor nadrazreda
		super("Miza s steklenicami");

		// Nastavimo obnašanje križca (x) tako, da konča aplikacijo
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Nastavimo privzeto velikost okna
		setSize(800, 600);

		// Inicializiramo lastnosti
		povrsina = new JPanel();
		dodajButton = new JButton("Dodaj steklenico");
		znamkaVnos = new JTextField(32);
		alkoholVnos = new JTextField(4);
		modelTabele = new PivskaSteklenicaTableModel();
		tabela = new JTable(modelTabele);

		// Gumbu za diodajanje dodamo action listener
		dodajButton.addActionListener(this);

		// Na površino dodamo vnosna polja
		povrsina.add(new JLabel("Znamka"));
		povrsina.add(znamkaVnos);
		povrsina.add(new JLabel("Stopnja alkohola"));
		povrsina.add(alkoholVnos);

		// Na površino dodamo gumb
		povrsina.add(dodajButton);

		// Na površino dodamo tabelo
		povrsina.add(tabela);

		// Na okno dodamo površino
		add(povrsina);

		// Naredimo okno vidno
		setVisible(true);	
	}

	/** Javna metoda, ki se izvaja aktivnosti glede na dogodke
	 * @param e Dogodek, ki je sprožil, klical metodo
	 */
	public void actionPerformed(ActionEvent e) {

		// Izpišemo indikator klika gumba
		System.out.println("Dodajam steklenico...");
		System.out.println("Znamka: " + znamkaVnos.getText());
		System.out.println("Stopnja alkohola: " + alkoholVnos.getText());

		// Ustvarimo spremenljivko za stopnjo alkohola
		double sa = Double.parseDouble(alkoholVnos.getText());

		// Ustvarimo objekt tipa PivskaSteklenica
		PivskaSteklenica nova = new PivskaSteklenica(znamkaVnos.getText(), 500, sa);

		// Pivsko steklenico dodamo v model tabele
		modelTabele.addPivskaSteklenica(nova);
	}
}