package p6;
/**
 * 
 * @author Benjamin Sejdic
 * version 1.0
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
	 * This method copies the values from array to array7x7
	 * @param array the array we want to copy to array7x7
	 */
	public Array7x7(int[][] array) {
		array7x7 = new int [7][7];
		for (int row = 0; row < array7x7.length; row++) { 		
			for (int column = 0; column < array7x7[row].length; column++) {
				array7x7[row][column] = array[row][column];
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
	 * Overwrites a row with a new one
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
	 * Overwrites a column with a new one
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
	
	
	/**
	 * @author George, Nazdar
	 * @version 1.0
	 */
	
	/**
	 * Returns an array after shifting columns to the left is finished
	 * @param arr the new array that will be part of Array7x7
	 * @return the array that falls over the edge in the end
	 */
	public int[] shiftRight(int[] arr){
		int[] temp = new int[arr.length];
		for(int i=0; i<array7x7.length; i++){
			temp = getCol(i);
			setCol(i, arr);
			arr = copyArray(temp);
		}
		return arr;
	}
	
	/**
	 * Returns an array after shifting columns to the right is finished
	 * @param arr the new array that will be part of Array7x7
	 * @return the array that falls over the edge in the end
	 */
	public int[] shiftLeft(int[] arr){
		int[] temp = new int[arr.length];
		for(int i=array7x7.length-1; i>=0; i--){
			temp = getCol(i);
			setCol(i, arr);
			arr = copyArray(temp);
		}
		return arr;
	}
	
	/**
	 * Returns an array that is copied with no attachments to the original array
	 * @param arr the array that will be copied
	 * @return an new array with same elements as the original
	 */
	public int[] copyArray(int[] arr){
		int[] temp = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			temp[i] = arr[i];
		}
		return temp;
	}

	/**
	 * Returns a 2D array filled with 0
	 * @return a 2D array filled with 0 
	 */
	public int[][] zeroArray7x7(){
		int[][] temp2D = new int[array7x7.length][array7x7[0].length];
		for(int i=0; i<array7x7.length;i++){
			for(int j=0; j<array7x7[i].length;j++){
				temp2D[i][j] = 0;
			}
		}
		return temp2D;
	}
}