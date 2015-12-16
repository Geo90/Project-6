package p6;
/**
 * 
 * @author Benjamin Sejdic
 *
 */
public class Array7x7 {

	int[][] array7x7;

	/**
	 * This constructor initializes the 2D array with 0
	 */
	public Array7x7() {
		array7x7 = new int [7][7];
		for (int row = 0; row < array7x7.length; row++) {	// 		
			for (int column = 0; column < array7x7[row].length; column++) {
				array7x7[row][column] = 0;
			}
		}
	}

	/**
	 * This method sets a element in the 2D arrray
	 * @param row specifies in which row we want to make the change 
	 * @param col specifies in which column we want to make the change 
	 * @param value sets a value to the specified column
	 */
	public void setElement(int row, int col, int value) {
		array7x7[row][col] = value;
	}

	/**
	 * Return the element in a specific column 
	 * @param row specifies in which row we want to get the element from
	 * @param col specifies in which column we want to get the element from
	 * @return element
	 */
	public int getElement(int row, int col) {
		return array7x7[row][col];
	}

	/**
	 * Overwrittens a row with a new one
	 * @param row specifies which row needs to be overwritten with a new row
	 * @param arr the new row we want to set 
	 */
	public void setRow(int row, int[] arr) {
		for (int column = 0; column < array7x7[row].length; column++) {
			 array7x7[row][column] = arr[column];

		}
	}

	/**
	 * Returns a row from the 2D array
	 * @param row the row we want to read
	 * @return the row we red gets returned
	 */
	public int[] getRow(int row) {
		int[] tempArr = new int[array7x7.length];
		for (int column = 0; column < array7x7.length; column++) {
			tempArr[column] = array7x7[row][column];
		}
		return tempArr;
	}

	/**
	 * Overwrittens a column with a new one
	 * @param col specifies which column needs to be overwritten with a new column
	 * @param arr the new column we want to set 
	 */
	public void setCol(int col, int[] arr) {
		for (int row = 0; row < array7x7.length; row++) {
			array7x7[row][col] = arr[row];
		}
	}

	/**
	 * Returns a column from the 2D array
	 * @param col the column we want to read
	 * @return the column we red gets returned
	 */
	public int[] getCol(int col) {
		int[] tempArr = new int[array7x7.length];
		for (int row = 0; row < array7x7.length; row++) {
			tempArr[row] = array7x7[row][col];
		}
		return tempArr;
	}
	
	// Testning av min kod 
//	public static void main(String[] args) {
//		Array7x7 arr7x7 = new Array7x7();
//		Array7 arr7 = new Array7();
//		arr7.setElement(0, 1);
//		arr7.setElement(1, 2);
//		arr7.setElement(2, 3);
//		arr7.setElement(3, 4);
//		arr7.setElement(4, 5);
//		arr7.setElement(5, 6);
//		arr7.setElement(6, 7);
//		arr7x7.setRow(0, arr7.getArray() );
//		arr7x7.setCol(2, arr7.getArray() );
//		for(int i = 0; i < 7; i++){
//			System.out.print(arr7x7.getRow(0)[i]);
//		}
//		System.out.println();
//		for(int i = 0; i < 7; i++){
//			System.out.print(arr7x7.getCol(2)[i]);
//		}
//	}

}
