package p6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import p6.Array7x7;
import p6.TestArray7x7;

/**
 * Klassen representerar en grafisk miljö bestående av en 7x7 array, och två 7x1
 * vertikala array, två knappar med lyssnare
 * 
 * @author NAZDAR
 * @author George
 *
 */

public class Grpanel extends JFrame {
	
	private Array7x7 array7x7 = new Array7x7();
	private JButton skRight = new JButton("Shift Right");
	private JButton skLeft = new JButton("Shift Left");
	private JLabel lblBoxes2D[][] = new JLabel[7][7]; // 2D array för lagring av knapparna
	private JTextField tfVertikal[] = new JTextField[7];
	private JTextField tfCenter[][] = new JTextField[7][7];
	
	/**
	 * Konstruktorn innehåller knappar med lyssnare Vi skickar klassen Array7x7
	 * i parametern för att nå dess metoder, och för att sedan kunna lyssna på
	 * knappar
	 * 
	 * @param array7x7
	 *            
	 */
	public Grpanel(Array7x7 array7x7) {
		this.array7x7  = array7x7;
		
		AL listener = new AL(); // lyssnare 
								
		skRight.addActionListener(listener);
		skLeft.addActionListener(listener);
	
	}
	/**
	 * Metoden består av fyra paneler som är alla samlade på en BorderLayout I
	 * 1:a panelen skapas de 49 elementen I 2:a skapas 7x1 (vertikalv) array med
	 * textfält I 3:e skapas 1x7 (vertikalh) array med textfält I 4:e skapas 2
	 * knappar med lyssnare
	 */
	public void Grpanel() {
		/*
		 * panel7x7 representerar den stora arrayen med de 49 elementen Till
		 * detta ändamål användes en 2D- array för lagring av knapparna En
		 * nestlad for loop användes för att gå igenom alla rader och kolumner
		 */
		JPanel panel7x7 = new JPanel();
		panel7x7.setLayout(new GridLayout(7, 7, 10, 10));
		for (int i = 0; i < 7; i++) { // för alla rader
			for (int j = 0; j < 7; j++) { // för alla kolumner
				lblBoxes2D[i][j] = new JLabel(""); // skapa en knapp
				lblBoxes2D[i][j].setPreferredSize(new Dimension(50, 50)); // ge knapparna en storlek
				lblBoxes2D[i][j].setBackground(Color.BLACK);
				lblBoxes2D[i][j].setForeground(Color.WHITE);
				lblBoxes2D[i][j].setOpaque(true);
				panel7x7.add(lblBoxes2D[i][j]); // lägg knapparna på panelen
				panel7x7.setBorder(new EmptyBorder(5, 15, 1, 30));// Skapar utrymme mellan fönstrets kanter och panelerna
				add(panel7x7, BorderLayout.CENTER); // panelen placeras i center på fönstre
			}
				for (int x = 0; x < tfCenter.length; x++) {
					for (int y = 0; y < tfCenter[x].length; y++) {
					 JTextField[x][y] = new JTextField("");
					 lblBoxes2D.add(tfCenter[x][y]);	
					 }
				
				}
		}
		
		/*
		 * vertikalv representerar den venstra vertikala arrayen med de 7 elementen
		 * Arrayen är editerbar består av 7 rader och 1 kolumn
		 * 
		 */
		JPanel vertikalv = new JPanel();
		vertikalv.setLayout(new GridLayout(7, 1));
		for (int element = 0; element < 7; element++) {
			JButton btnV = new JButton();
			btnV.setPreferredSize(new Dimension(55, 55));
			
			for (int i = 0; i < tfVertikal.length; i++) {
			tfVertikal[i] = new JTextField("");
			btnV.add(tfVertikal[i]);
			}
			
			vertikalv.add(btnV);
			vertikalv.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalv, BorderLayout.WEST);
			pack();
			
		}
		/*
		 * vertikalh representerar den högra vertikala arrayen med de 7 elementen
		 * Arrayen är editerbar består av 7 rader och 1 kolumn
		 * 
		 */
		
		JPanel vertikalh = new JPanel();
		vertikalh.setLayout(new GridLayout(7, 1));
		for (int element = 0; element < 7; element++) {
			JButton btnV = new JButton();
			btnV.setPreferredSize(new Dimension(55, 55));
			
			for (int i = 0; i < tfVertikal.length; i++) {
			tfVertikal[i] = new JTextField("");
			btnV.add(tfVertikal[i]);
			}
			
			vertikalh.add(btnV);
			vertikalh.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalh, BorderLayout.EAST);
			pack();
			
		}
		/*
		 * greenP representerar 2 knappar med varsin label,
		 * Dessa knappar är "tryckbara" - har lyssnare
		 */
		JPanel greenP = new JPanel();
		greenP.setLayout(new GridLayout(7, 1));
			skRight.setForeground(new Color(0xFF00FF00)); // green color
			greenP.add(skRight);
			skLeft.setForeground(new Color(0xFF00FF00));
			greenP.add(skLeft);
			
			greenP.setBorder(new EmptyBorder(0, 20, 20, 0));
			add(greenP, BorderLayout.SOUTH);
			pack();
			setResizable(false); // gör att man ej kan ändra storlek på det skapade
									// fönstret
			setVisible(true); // gör fönstret synligt
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör fönstret stängbart
															
	}
	/**
	 * Inre klass som implementerar ActionListener
	 * 
	 * @author Nazdar
	 * @author George
	 *
	 */
	private class AL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == skRight) {
				array7x7.shiftRight(arr); //här anroppar vi shiftright metod
				
			} else if (e.getSource() == skLeft) {
				array7x7.shiftLeft(arr); //här anroppar vi shiftleft metod
				
			}
	    } 
     }

	/**
	 * Körprogrammet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Array7x7 array7x7 = new Array7x7();
		Grpanel gr = new Grpanel(array7x7);
		gr.Grpanel();

	}
	 
}
