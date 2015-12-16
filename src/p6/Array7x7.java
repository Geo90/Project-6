package p6;

public class Array7x7 {
	private Array7 arr7;
	
	int[][] array7x7 = new int[7][7]; 

	/**
	 * This constructor initializes the 2D array with 0
	 */
	public Array7x7() { 
		for (int row = 0; row < array7x7.length; row++) {
			for (int column = 0; column < array7x7[row].length; column++) {
				array7x7[row][column] = 0;
			}
		}
	}

	public void setElement(int row, int col, int value) {
		array7x7[row][col] = value;
	}

	public int getElement(int row, int col) {
		return array7x7[row][col];
	}

	public void setRow(int row, int[] arr) {
				for (int column = 0; column < array7x7[row].length; column++) {
					array7x7[row][column] = arr[column];	// The specified row in the 2D array copies all the values of the 1D array
				}
	}

	public int[] getRow(int row) {
		int[] temp = new int[row];
				for (int column = 0; column < array7x7[i].length; column++) {
					temp[column] = array7x7[row][column]
				}			}
		}
		return temp; // returns the specified row in the 2D array
	}

	public void setCol(int col, Array7 theCol) {
		for (int row = 0; row < array7x7.length; row++) {						// Loops through the rows
			for (int column = 0; column < array7x7[row].length; column++) {		// Loops through the columns
				if (column == col) {
					array7x7[row][column] = theCol.array7[row];
				}
			}
		}
	}

	public Array7 getCol(int col) {
		for (int row = 0; row < array7x7.length; row++) {
			for (int column = 0; column < array7x7[row].length; column++) {
				if (column == col) {
					arr7.array7[row] = array7x7[row][column];
				}
			}
		}
		return arr7;
	}
}

