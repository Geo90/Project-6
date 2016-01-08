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


public class Grpanel extends JFrame {
	
	private Array7x7 array7x7 = new Array7x7();
	private JButton skRight = new JButton("Shift Right");
	private JButton skLeft = new JButton("Shift Left");
	private JLabel lblBoxes2D[][] = new JLabel[7][7]; // 2D array för lagring av knapparna
	private JTextField tfVertikal[] = new JTextField[7];
	private JTextField tfCenter[][] = new JTextField[7][7];
	
	
	public Grpanel(Array7x7 array7x7) {
		this.array7x7  = array7x7;
		
		AL listener = new AL(); // lyssnare - för man ska kunna lyssna (trycka) på knappar
								
		skRight.addActionListener(listener);
		skLeft.addActionListener(listener);
	
	}
	/**
	 * Metoden består av fyra paneler som är alla samlade på en BorderLayout I
	 * 1:a panelen skapas de 49 elementen I 2:a skapas 7x1 (vertikal) array med
	 * textfält I 3:e skapas 1x7 (horisontell) array med textfält I 4:e skapas 6
	 * knappar med varsin label, & lyssnare
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
				tfCenter[i][j]= new JTextField("");
				tfCenter[i][j].setPreferredSize(new Dimension(50,50));
				panel7x7.add(tfCenter[i][j]);
			
			
				panel7x7.setBorder(new EmptyBorder(5, 15, 1, 30));// Skapar utrymme mellan fönstrets kanter och panelerna
				add(panel7x7, BorderLayout.CENTER); // panelen placeras i center på fönstre
				
				}
		}
		
		/*
		 * vertikalP representerar den vertikala arrayen med de 7 elementen
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
			
			//defaultParametersVertical();
			vertikalv.add(btnV);
			vertikalv.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalv, BorderLayout.WEST);
			pack();
			
		}
		
		JPanel vertikalh = new JPanel();
		vertikalh.setLayout(new GridLayout(7, 1));
		for (int element = 0; element < 7; element++) {
			JButton btnV = new JButton();
			btnV.setPreferredSize(new Dimension(55, 55));
			
			for (int i = 0; i < tfVertikal.length; i++) {
			tfVertikal[i] = new JTextField("");
			btnV.add(tfVertikal[i]);
			}
			
			//defaultParametersVertical();
			vertikalh.add(btnV);
			vertikalh.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalh, BorderLayout.EAST);
			pack();
			
		}
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
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör fönstret
															// stängbart
	}
	private class AL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == skRight) {
				
			//	array7x7.shiftRight(arr); //här anroppar vi shiftright metod
				
			} else if (e.getSource() == skLeft) {
				//array7x7.shiftLeft(arr);//anropar shiftleft metod
				
			}
	    } 
     }
	public static void main(String[] args) {
		Array7x7 array7x7 = new Array7x7();
		Grpanel gr = new Grpanel(array7x7);
		gr.Grpanel();

	}
	 
}
