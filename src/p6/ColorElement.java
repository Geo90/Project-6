package p6;

import javax.swing.JOptionPane;

public class ColorElement {
	private int r, g, b, color;
	private Array7x7 arr7x7 = new Array7x7();
	private ColorDisplay colorDisplay = new ColorDisplay(Color.RED, Color.WHITE); // "new" måste finnas med för att kunna instansiera ColorDisplay
																					 																	
	public void checkColor(int[][] array) {
		/*
		 * For-loopen går igenom varje plats i den tvådimensionella arrayen och
		 * ser hur mycket av rött, grönt och blått int värdet innehåller.
		 */
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
 //Testning
	public static void main(String[] args) {
		ColorElement ce = new ColorElement();
		int arr[] = { 255, 255, 255, 255, 255, 255, 255 }; // En array skapas med bestämda (slumpmässiga) int värden (=färgvärden)
		ce.arr7x7.setCol(6, arr); // Skickar över färgvärdena som skapades i arr till rad 2
		
		ce.checkColor(ce.arr7x7.array7x7);
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftLeft(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		//int arr1[] = { 255, 255, 255, 255, 255, 255, 255 }; // En array skapas med bestämda (slumpmässiga) int värden (=färgvärden)
		//ce.arr7x7.setCol(2, arr1); // Skickar över färgvärdena som skapades i arr till rad 2
		ce.checkColor(ce.arr7x7.array7x7);
		ce.arr7x7.shiftRight(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftRight(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftRight(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftRight(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
		
		ce.arr7x7.shiftRight(ce.arr7x7.getRow(2));
		ce.colorDisplay.setDisplay(ce.arr7x7.array7x7);
		ce.colorDisplay.updateDisplay();
		JOptionPane.showMessageDialog(null, ce.colorDisplay);
	}
}
