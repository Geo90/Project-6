package p6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.plugins.jpeg.JPEGQTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Klassen representerar en grafisk miljö bestående av en 7x7 array, och en 7x1
 * vertikal-, samt horisontell array Men även 6 knappar med lyssnare
 * 
 * @author ansambassamabdulhamid
 *
 */
public class TestArray7x7 extends JFrame {

	private JButton btnLasRad = new JButton("Läs rad");
	private JButton btnSkrivRad = new JButton("Skriv rad");
	private JButton btnInputRadNr = new JButton();
	private JButton btnLasKol = new JButton("Läs kol");
	private JButton btnSkrivKol = new JButton("Skriv kol");
	private JButton btnInputKolNr = new JButton();

	private JLabel lblBoxes2D[][] = new JLabel[7][7]; // 2D array för lagring av
														// lablarna

	private JTextField tfHorisont[] = new JTextField[7]; // fördel med array är
															// att samma
															// referens kan
															// användas 7
															// element med
															// textfield
	private JTextField tfVertikal[] = new JTextField[7];
	private JTextField tfInputRad = new JTextField();
	private JTextField tfInputKol = new JTextField();

	private JButton btnVertikal[] = new JButton[7];
	private JButton btnHorisontell[] = new JButton[7];

	private Array7x7 array7x7 = new Array7x7();

	/**
	 * Konstruktorn innehåller knappar med lyssnare Vi skickar klassen Array7x7
	 * i parametern för att nå dess metoder, och för att sedan kunna lyssna på
	 * knappar
	 * 
	 * @param array7x7
	 *            referens till Array7x7 klassen
	 * 
	 */
	public TestArray7x7(Array7x7 array7x7) {
		this.array7x7 = array7x7;
		AL listener = new AL(); // lyssnare - för man ska kunna lyssna (trycka)
								// på knappar
		btnLasRad.addActionListener(listener);
		btnSkrivRad.addActionListener(listener);
		btnLasKol.addActionListener(listener);
		btnSkrivKol.addActionListener(listener);
		btnInputRadNr.add(tfInputRad);
		btnInputKolNr.add(tfInputKol);
	}

	/**
	 * Metoden består av fyra paneler som är alla samlade på en BorderLayout I
	 * 1:a panelen skapas de 49 elementen I 2:a skapas 7x1 (vertikal) array med
	 * textfält I 3:e skapas 1x7 (horisontell) array med textfält I 4:e skapas 6
	 * knappar med varsin label, & lyssnare
	 */
	public void TestArray7() {
		/*
		 * panel7x7 representerar den stora arrayen med de 49 elementen Till
		 * detta ändamål användes en 2D- array för lagring av knapparna En
		 * nestlad for loop användes för att gå igenom alla rader och kolumner
		 */
		JPanel panel7x7 = new JPanel();
		panel7x7.setLayout(new GridLayout(7, 7, 10, 10));
		for (int i = 0; i < 7; i++) { // för alla rader
			for (int j = 0; j < 7; j++) { // för alla kolumner
				lblBoxes2D[i][j] = new JLabel("", JLabel.CENTER); // skapa en label
				lblBoxes2D[i][j].setPreferredSize(new Dimension(50, 50)); // ge
																			// lablarna
																			// en
																			// storlek
				lblBoxes2D[i][j].setBackground(Color.BLACK); // bakground
				lblBoxes2D[i][j].setForeground(Color.WHITE);
				lblBoxes2D[i][j].setOpaque(true);
				panel7x7.add(lblBoxes2D[i][j]); // lägg knapparna på panelen
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
		JPanel horisontellP = new JPanel(); // horisontellP representerar den
											// horisontella arrayen med de 7
		horisontellP.setLayout(new GridLayout(1, 7));

		JPanel vertikalP = new JPanel(); // vertikalP representerar den
											// vertikala arrayen med de 7
											// elementen
		vertikalP.setLayout(new GridLayout(7, 1));
		for (int i = 0; i < 7; i++) {
			btnVertikal[i] = new JButton();
			btnVertikal[i].setPreferredSize(new Dimension(55, 55));
			tfVertikal[i] = new JTextField();
			btnVertikal[i].add(tfVertikal[i]);

			btnHorisontell[i] = new JButton();
			btnHorisontell[i].setPreferredSize(new Dimension(20, 40));
			tfHorisont[i] = new JTextField();
			btnHorisontell[i].add(tfHorisont[i]);
			vertikalP.add(btnVertikal[i]);
			vertikalP.setBorder(new EmptyBorder(0, 0, 20, 20));
			add(vertikalP, BorderLayout.WEST);

			horisontellP.add(btnHorisontell[i]);
			horisontellP.setBorder(new EmptyBorder(30, 35, 0, 30));
			add(horisontellP, BorderLayout.SOUTH);
		}

		/*
		 * greenP representerar 6 knappar med varsin label består av 6 rader,
		 * och 1 kolumn Dessa knappar är "tryckbara" - har lyssnare
		 */
		JPanel greenP = new JPanel();
		greenP.setLayout(new GridLayout(7, 1));

		btnLasRad.setForeground(new Color(0xFF00FF00)); // green color
		greenP.add(btnLasRad);
		btnSkrivRad.setForeground(new Color(0xFF00FF00));
		greenP.add(btnSkrivRad);
		btnInputRadNr.setForeground(new Color(0xFF00FF00));
		greenP.add(btnInputRadNr);
		btnLasKol.setForeground(new Color(0xFF00FF00));
		greenP.add(btnLasKol);
		btnSkrivKol.setForeground(new Color(0xFF00FF00));
		greenP.add(btnSkrivKol);
		btnInputKolNr.setForeground(new Color(0xFF00FF00));
		greenP.add(btnInputKolNr);

		greenP.setBorder(new EmptyBorder(0, 20, 20, 0));
		add(greenP, BorderLayout.EAST);
		pack();
		setResizable(false); // gör att man ej kan ändra storlek på det skapade
								// fönstret
		setVisible(true); // gör fönstret synligt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör fönstret
														// stängbart
	}

	public void updateGUI() {
	}

	/**
	 * Inre klass som implementerar ActionListener
	 * 
	 * @author ansambassamabdulhamid
	 *
	 */
	private class AL implements ActionListener {
		/**
		 * Vi trycker på en knapp För att det ska gå, skickar vi ett värde till
		 * klassen som innehåller alla metoder som ska anropas, genom dess
		 * referens, och metodNamn
		 */
		public void actionPerformed(ActionEvent e) {
			JTextField tempTxtField;
			int[] arr = new int[7];
			int row = -1;
			int col = -1;
			if (e.getSource() == btnLasRad) {
				tempTxtField = (JTextField) btnInputRadNr.getComponent(0);
				row += Integer.parseInt(tfInputRad.getText()); // gör om sträng
																// till siffror
				for (int i = 0; i < arr.length; i++) {
					JLabel tempLbl = (JLabel) lblBoxes2D[row][i];
					arr[i] = Integer.parseInt(tempLbl.getText());
					tempTxtField = (JTextField) btnHorisontell[i].getComponent(0);
					tempTxtField.setText(Integer.toString(arr[i]));
				}
			} else if (e.getSource() == btnSkrivRad) { // setRow(var, vad)
				tempTxtField = (JTextField) btnInputRadNr.getComponent(0);
				row += Integer.parseInt(tempTxtField.getText());
				for (int i = 0; i < arr.length; i++) {
					tempTxtField = (JTextField) btnHorisontell[i].getComponent(0);
					arr[i] = Integer.parseInt(tempTxtField.getText());
					lblBoxes2D[row][i].setText(Integer.toString(arr[i]));
					array7x7.setElement(row, i, arr[i]);
				}

			} else if (e.getSource() == btnLasKol) {
				tempTxtField = (JTextField) btnInputKolNr.getComponent(0);
				col += Integer.parseInt(tfInputKol.getText()); // gör om sträng
																// till siffror
				for (int i = 0; i < arr.length; i++) {
					JLabel tempLbl = (JLabel) lblBoxes2D[i][col];
					arr[i] = Integer.parseInt(tempLbl.getText());
					tempTxtField = (JTextField) btnVertikal[i].getComponent(0);
					tempTxtField.setText(Integer.toString(arr[i]));
				}
			} else if (e.getSource() == btnSkrivKol) {
				tempTxtField = (JTextField) btnInputKolNr.getComponent(0);
				col += Integer.parseInt(tempTxtField.getText());
				for (int i = 0; i < arr.length; i++) {
					tempTxtField = (JTextField) btnVertikal[i].getComponent(0);
					arr[i] = Integer.parseInt(tempTxtField.getText());
					lblBoxes2D[i][col].setText(Integer.toString(arr[i]));
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
		TestArray7x7 t7x7 = new TestArray7x7(array7x7);
		t7x7.TestArray7();

	}
}
