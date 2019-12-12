package ratinglogin;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;

import rate.rate;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ratinglogin {

	private JFrame frame;
	private JTextField txtrhid;
	private JPasswordField pffssn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ratinglogin window = new ratinglogin();
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
	public ratinglogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 919, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Raptor\\Desktop\\django\\btre_project\\static\\img\\logo1.jpg"));
		lblNewLabel.setBounds(66, 13, 735, 135);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 174, 877, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the details");
		lblPleaseEnterThe.setForeground(Color.WHITE);
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPleaseEnterThe.setBounds(22, 189, 215, 16);
		frame.getContentPane().add(lblPleaseEnterThe);
		
		JLabel lblFssn = new JLabel("fssn");
		lblFssn.setForeground(Color.WHITE);
		lblFssn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFssn.setBounds(213, 299, 56, 16);
		frame.getContentPane().add(lblFssn);
		
		JLabel lblHotelId = new JLabel("Hotel ID");
		lblHotelId.setForeground(Color.WHITE);
		lblHotelId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHotelId.setBounds(213, 251, 78, 22);
		frame.getContentPane().add(lblHotelId);
		
		txtrhid = new JTextField();
		txtrhid.setBounds(317, 253, 324, 22);
		frame.getContentPane().add(txtrhid);
		txtrhid.setColumns(10);
		
		pffssn = new JPasswordField();
		pffssn.setBounds(317, 293, 324, 22);
		frame.getContentPane().add(pffssn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 430, 867, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnRate = new JButton("RATE");
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				int[] arr = new int[100];
				String username = txtrhid.getText();
				String password = pffssn.getText();
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
			    Statement stmt = con.createStatement();	
			    ResultSet rs = stmt.executeQuery("select h_id,f_ssn from room where status = 'booked' ");
			   
			    
			    while(rs.next())
			    {
			    	arr[i] = rs.getInt(1);
			    	if(username.contains(Integer.toString(rs.getInt(1)))&& password.contains(Integer.toString(rs.getInt(2))))
			    	{
			    		pffssn.setText(null);
						txtrhid.setText(null);
						//rate info = new rate();
						rate.main(null);
						frame.setVisible(false);
						
			    	}
			    	else
			    	{
						JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
						txtrhid.setText(null);
						pffssn.setText(null);
			    	}
			    }
			    
			    
			    con.close();
			    
				}	catch (SQLException ex) {
					
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
				}
		});
		btnRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRate.setBounds(140, 350, 97, 25);
		frame.getContentPane().add(btnRate);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrhid.setText(null);
				pffssn.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(374, 351, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Cofirm exit","Admin",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(626, 350, 97, 25);
		frame.getContentPane().add(btnExit);
	}
}
