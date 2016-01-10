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

	private JButton[] btnArrayH = new JButton[7];
	private JButton[] btnArrayV = new JButton[7];

	private AL listener = new AL(); // lyssnare

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
		 * panel7x7 representerar den stora arrayen med de 49 textfield
		 * elementen
		 * 
		 */
		JPanel panel7x7 = new JPanel();
		panel7x7.setLayout(new GridLayout(7, 7, 10, 10));
		for (int i = 0; i < 7; i++) { // för alla rader
			for (int j = 0; j < 7; j++) { // för alla kolumner
				tfCenter[i][j] = new JTextField(null, JTextField.CENTER);
				tfCenter[i][j].setPreferredSize(new Dimension(50, 50));
				panel7x7.add(tfCenter[i][j]);

				panel7x7.setBorder(new EmptyBorder(5, 15, 1, 30));// Skapar
																	// utrymme
																	// mellan
																	// fönstrets
																	// kanter
																	// och
																	// panelerna
				add(panel7x7, BorderLayout.CENTER); // panelen placeras i center
													// på fönstret

			}
		}
		/*
		 * vertikalv representerar den vänstra vertikala arrayen med de 7
		 * elementen Arrayen är editerbar, består av 7 rader och 1 kolumn
		 * 
		 */

		JPanel vertikalv = new JPanel();
		JPanel vertikalh = new JPanel();

		vertikalv.setLayout(new GridLayout(7, 1));
		vertikalh.setLayout(new GridLayout(7, 1));

		for (int i = 0; i < tfCenter.length; i++) {
			btnArrayV[i] = new JButton();
			btnArrayV[i].setPreferredSize(new Dimension(55, 55));
			

			btnArrayH[i] = new JButton();
			btnArrayH[i].setPreferredSize(new Dimension(55, 55));
			

			tfVertikalv[i] = new JTextField("", JLabel.CENTER);
			tfVertikalv[i].addActionListener(listener); // tryckbar
			btnArrayV[i].add(tfVertikalv[i]);

			tfVertikalh[i] = new JTextField("", JLabel.CENTER);
			tfVertikalh[i].addActionListener(listener);
			btnArrayH[i].add(tfVertikalh[i]);

			vertikalv.add(btnArrayV[i]);
			vertikalv.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalv, BorderLayout.WEST);

			vertikalh.add(btnArrayH[i]);
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

		greenP.setBorder(new EmptyBorder(0, 20, 20, 0));
		add(greenP, BorderLayout.SOUTH);
		pack();
		setResizable(true); // gör att man ej kan ändra storlek på det skapade
							// fönstret
		setVisible(true); // gör fönstret synligt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör fönstret
														// stängbart
	}

	
	public int[][] getTfCenterArray(){
		int[][] tempArr = new int[tfCenter.length][tfCenter.length];
		for (int i = 0; i < tfCenter.length; i++) {
			for (int j = 0; j < tfCenter.length; j++) {
				try{
				tempArr[i][j] = Integer.parseInt(tfCenter[i][j].getText());
				}catch(NumberFormatException e){
					//Do nothing
					}
				}
			}
		return tempArr;
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
			JTextField tempTxtField;
			int[] arr = new int[7];
			// for(int i=0;i<tfVertikalh.length;i++){
			/*
			 * tfVertikalh[0].setText("X"); String s = tfVertikalh[i].getText();
			 * tfVertikalh[i].setText(s); System.out.println("Printing s: " +
			 * s); System.out.println("Printing tfVertikalh["+i+"]: " +
			 * tfVertikalh[i].getText()); tfTemp.setText("YES!"); s =
			 * tfTemp.getText(); System.out.println(s);
			 */
			// }
			if (e.getSource() == skRight) {
				for (int i = 0; i < arr.length; i++) {
					tempTxtField = (JTextField) btnArrayV[i].getComponent(0);
					arr[i] = Integer.parseInt(tempTxtField.getText());

					tempTxtField.setText(Integer.toString(arr[i]));
				}
				
				array7x7.setArray7x7(getTfCenterArray());
				arr = array7x7.shiftRight(arr); // här anroppar vi shiftright
												// metod

				//Uppdaterar den symmetriska 7x7 arrayen
				for (int i = 0; i < tfCenter.length; i++) {
					for (int j = 0; j < tfCenter.length; j++) {
						tfCenter[i][j].setText(Integer.toString(array7x7.getElement(i, j))); 
					}
					tempTxtField = (JTextField) btnArrayH[i].getComponent(0);
					tempTxtField.setText(Integer.toString(arr[i]));
				}
			} else if (e.getSource() == skLeft) {

				for (int i = 0; i < arr.length; i++) {
					tempTxtField = (JTextField) btnArrayH[i].getComponent(0);
					arr[i] = Integer.parseInt(tempTxtField.getText());

					tempTxtField.setText(Integer.toString(arr[i]));
				}

				array7x7.setArray7x7(getTfCenterArray());
				arr = array7x7.shiftLeft(arr); // här anroppar vi shiftright
												// metod

				//Uppdaterar den symmetriska 7x7 arrayen
				for (int i = 0; i < tfCenter.length; i++) {
					for (int j = 0; j < tfCenter.length; j++) {
						tfCenter[i][j].setText(Integer.toString(array7x7.getElement(i, j))); 
					}
					tempTxtField = (JTextField) btnArrayV[i].getComponent(0);
					tempTxtField.setText(Integer.toString(arr[i]));
				}
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
