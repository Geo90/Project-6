package p6;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;
 
public class FlowingText1 extends JFrame{
	int count;
	FlowingText2 timer;
	private JTextField tf;
	private JLabel timeLabel;
	private JLabel label1;
	private JButton start, stop, cancel;
	
	public FlowingText1() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		label1 = new JLabel(" Mata in en text ");
		panel.add(label1);

		tf = new JTextField(20);
		panel.add(tf);
		
		//Buttons
		start = new JButton("Start");
		stop = new JButton("Stop");
		cancel = new JButton("Cancel");
	
		
		panel.add(start);
		panel.add(stop);
		panel.add(cancel);
		
		start.addActionListener(new ButtonListener());
		stop.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		
		add(panel);
		this.pack();	
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//Sends the input to the FlowingText2 class
			if(e.getSource() == start){
				if(tf.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "The textfield is empty. Please try again.");
				else{
					timer = new FlowingText2(tf.getText());
					tf.setText(null);
					timer.run();
				}
			}
			//Stops the timer
			else if(e.getSource() == stop){
				timer.stopTimer();
			}
			//Closes the JFrame window
			else{
				JFrame.getFrames()[0].dispose();
			}
				
		}

	}
	public static void main(String[] args) {
		FlowingText1 ft1 = new FlowingText1();

		ft1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		//ft1.setLocation(dim.width/2-ft1.getSize().width/2, dim.height/2-ft1.getSize().height/2);
		ft1.setLocationRelativeTo(null); //Same as the row of code that is commented above
		
		ft1.setVisible(true);
		ft1.setSize(new Dimension(300,200) );
		
	}
}

