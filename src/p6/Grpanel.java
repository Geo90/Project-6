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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


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
	
	private JTextField tfVertikalh[] = new JTextField[7];
	private JTextField tfVertikalv[] = new JTextField[7];
	private JTextField tfCenter[][] = new JTextField[7][7];

	private AL listener = new AL(); // lyssnare
	
	private JTextField tfTemp;
	
	
	private JPanel vertikalv = new JPanel();
	private JPanel vertikalh = new JPanel();
	/**
	 * Konstruktorn innehåller knappar med lyssnare Vi skickar klassen Array7x7
	 * i parametern för att nå dess metoder, och för att sedan kunna lyssna på
	 * knappar
	 * 
	 * @param array7x7
	 * 
	 */
	public Grpanel(Array7x7 array7x7) {
		this.array7x7 = array7x7;

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
				tfCenter[i][j]= new JTextField("");
				tfCenter[i][j].setPreferredSize(new Dimension(50,50));
				panel7x7.add(tfCenter[i][j]);
			
				panel7x7.setBorder(new EmptyBorder(5, 15, 1, 30));// Skapar utrymme mellan fönstrets kanter och panelerna
				add(panel7x7, BorderLayout.CENTER); // panelen placeras i center på fönstre
				
				}
		}
		/*
		 * vertikalv representerar den venstra vertikala arrayen med de 7
		 * elementen Arrayen är editerbar består av 7 rader och 1 kolumn
		 * 
		 */
		
		vertikalv.setLayout(new GridLayout(7, 1));
		vertikalh.setLayout(new GridLayout(7, 1));
		
		for (int element = 0; element < tfCenter.length; element++) {
			JButton btnV = new JButton();
			btnV.setPreferredSize(new Dimension(55, 55));

			JButton btnH = new JButton();
			btnH.setPreferredSize(new Dimension(55, 55));

			for (int i = 0; i < tfVertikalv.length; i++) {
				tfVertikalv[i] = new JTextField("1");
				tfVertikalv[i].addActionListener(listener);
				tfVertikalv[i].setEnabled(true);
				tfVertikalv[i].setEditable(true);
				btnV.add(tfVertikalv[i]);
				
				tfVertikalh[i] = new JTextField("2");
				tfVertikalh[i].setEnabled(true);
				tfVertikalh[i].setEditable(true);
				tfVertikalh[i].addActionListener(listener);
				btnH.add(tfVertikalh[i]);
			}

			vertikalv.add(btnV);
			vertikalv.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalv, BorderLayout.WEST);
			
			vertikalh.add(btnH);
			vertikalh.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalh, BorderLayout.EAST);
			pack();
		}
		
		/*
		 * greenP representerar 2 knappar med varsin label, Dessa knappar är
		 * "tryckbara" - har lyssnare
		 */
		JPanel greenP = new JPanel();
		greenP.setLayout(new GridLayout(7, 1));
		skRight.setForeground(new Color(0xFF00FF00)); // green color
		greenP.add(skRight);
		skLeft.setForeground(new Color(0xFF00FF00));
		greenP.add(skLeft);

		tfTemp = new JTextField("temp");
		greenP.add(tfTemp);
		
		greenP.setBorder(new EmptyBorder(0, 20, 20, 0));
		add(greenP, BorderLayout.SOUTH);
		pack();
		setResizable(true); // gör att man ej kan ändra storlek på det skapade
								// fönstret
		setVisible(true); // gör fönstret synligt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör fönstret
														// stängbart
	}

	/**
	 * Inre klass som implementerar ActionListener
	 * 
	 * @author Nazdar
	 * @author George
	 *
	 */
	
	private class AL implements ActionListener, DocumentListener{
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<tfVertikalh.length;i++){
				tfVertikalh[0].setText("X");
				String s = tfVertikalh[i].getText();
				tfVertikalh[i].setText(s);
				System.out.println("Printing s: " + s);
				System.out.println("Printing tfVertikalh["+i+"]: " + tfVertikalh[i].getText());
				tfTemp.setText("YES!");
				s = tfTemp.getText();
				System.out.println(s);
			}		
			if (e.getSource() == skRight) {
				int[] arr = new int[tfVertikalv.length];
				for (int i = 0; i < arr.length; i++) {
					//arr[i] = Integer.parseInt(tfVertikalv[i].getText());
				}
				array7x7.shiftRight(arr); // här anroppar vi shiftright metod
				repaint();
			} else if (e.getSource() == skLeft) {
				int[] arr = new int[tfVertikalh.length];
				for (int i = 0; i < arr.length; i++) {
					//arr[i] = Integer.parseInt(tfVertikalh[i].getText());
				}
				array7x7.shiftLeft(arr); // här anroppar vi shiftleft metod
				repaint();
			}
		}
//Funkar inte och behövs nog inte
		@Override
		public void insertUpdate(DocumentEvent e) {
			for(int i=0; i<tfCenter.length;i++){
				if(tfVertikalh[i] == null)
					tfVertikalh[i].setText("0");
				if(tfVertikalv[i] == null)
					tfVertikalv[i].setText("0");
				if(tfVertikalv[i] != null || tfVertikalh[i] != null){
					tfVertikalv[i].setText("X");
					tfVertikalv[i].setText("X");
				}
				
			}
			System.out.println("insertUpdate");
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("removeUpdate");
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("changedUpdate");
			
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
