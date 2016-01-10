


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
	
    public FlowingText2(String txt){
    	timer = new Timer();
		this.txt = txt;
		charArray = new char[txt.length()];
		charArray();
    }
	
	//Timer task will be executed when called by the Timer object
	private TimerTask timerTask = new TimerTask(){
		private int i = 0;
		
		public void run(){
			if(i<txt.length()) {
				System.out.println("Value: " + " " + charArray[i]); 
				i++;
			} else {
				timer.cancel();
			}
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
		setDelay(delay);

	}
	
	
	/**
	 * Asks the user to input a text that is stored in a String variable
	 */
	private String getUserInput(){
		return this.txt;
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
	
	public void stopTimer(){
		timer.cancel();
	}
	
	/**
	 * Calling the TimerTask to execute the task parallel to the
	 * run method
	 */
	public void run(){
		System.out.println("System ready...");
		startTime();
		System.out.println("running...");
		timer.schedule(timerTask, 2000, 1000);
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
