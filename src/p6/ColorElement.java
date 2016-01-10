package p6;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ColorElement {
	private int r, g, b, color;
	private Array7x7 arr7x7 = new Array7x7();
	private ColorDisplay colorDisplaySmall = new ColorDisplay(Color.RED, Color.WHITE); // "new" måste finnas med för att kunna instansiera ColorDisplay
	private	ColorDisplay colorDisplayBig = new ColorDisplay(1, 5, Color.BLACK, Color.WHITE);																				 																	
	
	public void panelSmall() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(colorDisplaySmall);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void panelBig() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(colorDisplayBig);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 * Går igenom varje plats i den tvådimensionella arrayen och
	 * ser hur mycket av rött, grönt och blått int värdet innehåller.
	 * @param array
	 */
	public void checkColor(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				r = Color.red(array[row][col]); 
				g = Color.green(array[row][col]);
				b = Color.blue(array[row][col]);
				color = Color.rgb(r, g, b);
				array[row][col] = color;
			}
		}		
	}
	
	public void updateSmallDisplay(int[][] array) {
		colorDisplaySmall.setDisplay(array);
		colorDisplaySmall.updateDisplay();
	}
	
	public void updateBigDisplay(int[][] array) {
		colorDisplayBig.setDisplay(array);
		colorDisplayBig.updateDisplay();
	}
 
	public static void main(String[] args) {
		ColorElement ce = new ColorElement();
		int arr[] = { 255, 255, 255, 255, 255, 255, 255 }; // En array skapas med bestämda (slumpmässiga) int värden (=färgvärden)
		ce.arr7x7.setCol(6, arr); // Skickar över färgvärdena som skapades i arr till rad 2
		
		ce.checkColor(ce.arr7x7.array7x7);
		ce.panelSmall();
		ce.updateSmallDisplay(ce.arr7x7.array7x7);
		JOptionPane.showMessageDialog(null, 0);
		ce.arr7x7.shiftRight();
		ce.updateBigDisplay(ce.arr7x7.array7x7);
	
	}
}
