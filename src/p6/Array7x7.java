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
	public int[] shiftLeft(int[] arr){
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
	public int[] shiftRight(int[] arr){
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

	public int[][] zeroArray7x7(){
		int[][] temp2D = new int[array7x7.length][array7x7[0].length];
		for(int i=0; i<array7x7.length;i++){
			for(int j=0; j<array7x7[i].length;j++){
				array7x7[i][j] = 0;
			}
		}
		return temp2D;
	}


	//Testning av min kod 
	public static void main(String[] args) {
		/**/
		Array7x7 arr7x7 = new Array7x7();
		Array7 arr7 = new Array7();
		arr7.setElement(0, 1);
		arr7.setElement(1, 2);
		arr7.setElement(2, 3);
		arr7.setElement(3, 4);
		arr7.setElement(4, 5);
		arr7.setElement(5, 6);
		arr7.setElement(6, 7);
		arr7x7.setRow(0, arr7.getArray() );
		arr7x7.setCol(2, arr7.getArray() );
		for(int i = 0; i < 7; i++){
			System.out.print(arr7x7.getRow(0)[i]);
		}
		System.out.println();
		for(int i = 0; i < 7; i++){
			System.out.print(arr7x7.getCol(2)[i]);
		}
		/**/

		System.out.println();
		System.out.println();

		//Dummy matrix initialized to zeroes
		int[][] zeroes2D = new int[7][7]; 
		System.out.println("Printing the 2D zeroes array:");
		zeroes2D =	arr7x7.zeroArray7x7();
		for(int col = 0; col < 7; col++){
			for(int row = 0; row < 7; row++){
				System.out.print(arr7x7.getCol(col)[row]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		//Testing shifting methods, 2 to the left and 1 to the right using elements in arr7
		System.out.println("Printing the same array after shifting 1 left:");
		arr7x7.shiftLeft(arr7.getArray());
		for(int col = 0; col < 7; col++){
			for(int row = 0; row < 7; row++){
				System.out.print(arr7x7.getCol(col)[row]);
			}
			System.out.println();	
		}
		
		System.out.println("Printing the same array after shifting 1 more left:");
		arr7x7.shiftLeft(arr7.getArray());
		for(int col = 0; col < 7; col++){
			for(int row = 0; row < 7; row++){
				System.out.print(arr7x7.getCol(col)[row]);
			}
			System.out.println();	
		}
		
		System.out.println();	
		System.out.println();	
		
		System.out.println("Printing the same array after shifting 1 to the right:");
		arr7x7.shiftRight(arr7.getArray());
		for(int col = 0; col < 7; col++){
			for(int row = 0; row < 7; row++){
				System.out.print(arr7x7.getCol(col)[row]);
			}
			System.out.println();	
		}
	}
}













