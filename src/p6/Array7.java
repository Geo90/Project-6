package p6;

public class Array7 {

	private int[] array7;
	
	public Array7() {
		this.array7 = new int[7];
	}

	public void setElement(int pos, int value) {
		array7[pos] = value;
	}

	public int getElement(int pos) {
		return array7[pos];
	}
	
	public int[] getArray() {
		int[] tempArr = new int[7];
		for (int i = 0; i < array7.length; i++ ) {
			tempArr[i] = array7[i];
		}
		return tempArr;
	}

}
