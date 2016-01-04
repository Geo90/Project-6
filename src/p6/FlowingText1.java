package p6;

import java.awt.Dimension;
import java.awt.FlowLayout;
// detta är den första förslag som jag skrev
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class FlowingText1 extends JFrame{
	int count;
	Timer timer;
	private JTextField tf;
	private JLabel timeLabel;
	private JLabel label1;
	
	public FlowingText1() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		label1 = new JLabel(" Mata in en text ");
		panel.add(label1);

		tf = new JTextField(20);
		panel.add(tf);
		add(panel);
		this.pack();	
	}

	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int count = (int) (Double.parseDouble(tf.getText()));
			timeLabel.setText("Time left: " + count);
			timer.start();
		}

	}
	public static void main(String[] args) {
		FlowingText1 ft1 = new FlowingText1();
		FlowingText2 ft2 = new FlowingText2();
		ft1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ft1.setVisible(true);
		ft1.setSize(new Dimension(300,200) );
		
	}
}

