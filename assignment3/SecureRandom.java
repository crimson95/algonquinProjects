/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Fedor Ilitchev
 * Lab number: Assignment 3
 */

package assignment3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * simulate a multi-sided die and roll it to obtain random values
 * @author Jay
 */
public class SecureRandom implements Runnable{
	private Font font = new Font("Tahoma", Font.PLAIN, 24);
	
	/**
	 * Default constructor
	 */
	public SecureRandom() {}
	
	/**
	 * builds and displays the die GUI
	 * responsible for input validation, dice roll calculation, and result display
	 */
	@Override
	public void run() {
		JFrame frame = new JFrame("Electic Die");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 220);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout(0,0));
		
		JPanel panel = new JPanel(new GridLayout(2,2,0,0));
		JTextField side = new JTextField();
		side.setFont(font);
		JLabel sideLabel = new JLabel("# of sides: ");
		sideLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sideLabel.setFont(font);
		
		JTextField roll = new JTextField();
		roll.setFont(font);
		roll.setEditable(false);
		JLabel rollLabel = new JLabel("Rolled: ");
		rollLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rollLabel.setFont(font);
		
		panel.add(sideLabel);   panel.add(side);
		panel.add(rollLabel);   panel.add(roll);
		frame.add(panel, BorderLayout.CENTER);
		
		JButton button = new JButton("Roll the die");
		button.setFont(font);
		button.setPreferredSize(new Dimension(300,40));
		button.setBackground(new Color(204,229,255));
		frame.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			
			/**
			 * read, validate input, and jump error messages in events 
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String text = side.getText().trim();
					int sides = Integer.parseInt(text);
					
					if (sides <= 0) {
						JOptionPane.showMessageDialog(frame, "enter integer greater than 0", "input error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					int result = new java.security.SecureRandom().nextInt(sides) + 1;
					roll.setText(String.valueOf(result));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "enter valid number", "input error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
