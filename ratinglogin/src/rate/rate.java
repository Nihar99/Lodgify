package rate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class rate {

	private JFrame frame;
	private JTextField txtrate;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rate window = new rate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 880, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Raptor\\Desktop\\django\\btre_project\\static\\img\\logo1.jpg"));
		lblNewLabel.setBounds(31, 13, 803, 134);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 174, 838, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblRate = new JLabel("RATE");
		lblRate.setForeground(Color.WHITE);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBounds(310, 231, 56, 16);
		frame.getContentPane().add(lblRate);
		
		txtrate = new JTextField();
		txtrate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrate.setBounds(378, 228, 56, 22);
		frame.getContentPane().add(txtrate);
		txtrate.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setForeground(Color.WHITE);
		label.setBounds(446, 232, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("10");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(464, 232, 56, 16);
		frame.getContentPane().add(label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 287, 819, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblHotelId = new JLabel("Hotel ID");
		lblHotelId.setForeground(Color.WHITE);
		lblHotelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHotelId.setBounds(293, 202, 73, 16);
		frame.getContentPane().add(lblHotelId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(378, 200, 147, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblThankYouFor = new JLabel("Thank You! For The Rating");
		lblThankYouFor.setForeground(Color.WHITE);
		lblThankYouFor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThankYouFor.setBounds(310, 325, 236, 39);
		frame.getContentPane().add(lblThankYouFor);
	}
}
