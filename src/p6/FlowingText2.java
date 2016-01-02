
// detta var det andra förslaget

package p6;

import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

public class FlowingText2{

	private long start, stop;
	private Timer timer;
	private int delay = 1000; // en second
	private boolean isRunning = false;
	char[] charArray;
	String txt;
	
	//Timer task will be executed when called by the Timer object
	private TimerTask timerTask = new TimerTask(){
		public void run(){
			int i = 0;
			while(i<txt.length()){
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Value: " + " " + charArray[i]); 
				i++;
			}
			stopTime();
			System.out.println("Time in seconds: " + (stop-start)/1000);
		}
	};

	/**
	 * Constructor
	 * @param delay
	 */
	public FlowingText2(int delay) {
		timer = new Timer();
		getUserInput();
		charArray = new char[txt.length()];
		charArray();

	}
	
	/**
	 * Asks the user to input a text that is stored in a String variable
	 */
	private void getUserInput(){
		txt = JOptionPane.showInputDialog(null, "Input the text you want to show: ");
	}
	
	/**
	 * Sets the text that is stored in a String variable
	 * and initializes the char array and copies the chars
	 * from the string to the char array
	 */
	private void setInput(String str){
		txt = str;
		charArray = new char[txt.length()];
		for(int i=0;i<txt.length();i++){
			charArray[i] = txt.charAt(i);
		}
	}
	
	/**
	 * Copies the contents of the user intput string to
	 * the character array
	 */
	private void charArray(){
		for(int i=0;i<txt.length();i++){
			charArray[i] = txt.charAt(i);
		}
	}

	/**
	 * Returns a boolean of the timer showing if it is 
	 * running or not
	 * @return isRunning
	 */
	public boolean isRunning(){
		return this.isRunning;
		}
		
	/**
	 * Sets the delay in milliseconds
	 * @param delay
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}

	/**
	 * The current system time stored into the start variable,
	 * used for time measurement and sets the boolean isRunning
	 * to the value true
	 */
	public void startTime() {
		this.start = System.currentTimeMillis();
		isRunning = true;
	}

	/**
	 * The current system time stored into the stop variable,
	 * used for time measurement and sets the boolean isRunning
	 * to the value false
	 */
	public void stopTime() {
		this.stop = System.currentTimeMillis();
		isRunning = false;
	}
	
	/**
	 * Calling the TimerTask to execute the task parallel to the
	 * run method
	 */
	public void run(){
		System.out.println("System ready...");
		startTime();
		System.out.println("running...");
		timer.schedule(timerTask, 2000);
	}
	
	//Main to test the code
	public static void main(String[] args){
		
		//When JOptionPane asks for input just press OK because input is already provided in the code below!
		FlowingText2 ft2 = new FlowingText2(1000);
		ft2.setInput("abcdefg");
		ft2.run();
		FlowingText2 ft3 = new FlowingText2(1000);
		ft3.setInput("0123456");
		System.out.println("Starting next round parallell to first...");
		ft3.run();
		
	}
}
