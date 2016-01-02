package p6;

// detta är den första förslag som jag skrev
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class FlowingText1 extends JFrame{
	int count;
	Timer timer;
	private JTextField tf;
	private JLabel timeLabel;

	public FlowingText1(int delay, ActionListener listener) {
		JFrame frame = new JFrame(" Inmatning fönster");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		this.pack();
		this.setVisible(true);

		setLayout(new GridLayout(6, 3, 5, 5));
		JLabel label1 = new JLabel(" Mata in en text ");
		frame.add(label1);

		tf = new JTextField(5);
		frame.add(tf);

		JButton btn1 = new JButton(" Start timing ");
		frame.add(btn1);

		JLabel timerlabel = new JLabel(" Waiting......");
		frame.add(timerlabel);
		btn1.addActionListener(new Action());

	}

	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int count = (int) (Double.parseDouble(tf.getText()));
			timeLabel.setText("Time left: " + count);
			TimeClass tc = new TimeClass(count);
			timer = new Timer(1000, tf);
			timer.start();
		}

	}
}
