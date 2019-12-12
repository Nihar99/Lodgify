package rate;

import java.awt.EventQueue;
import java.sql.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;

import Lodgify.Lodgify;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class rate {

	private JFrame frame;
	private JTextField txtrate;
	private JTextField txthotelid;
	private JLabel lblend ;
	private JTextField txtfssn;
	private JPanel panelinput;
	private JButton btnBack;

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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 880, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Raptor\\Desktop\\django\\btre_project\\static\\img\\logo1.jpg"));
		lblNewLabel.setBounds(31, 13, 803, 115);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 145, 838, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 311, 819, 2);
		frame.getContentPane().add(separator_1);
		
		lblend = new JLabel("Thank You! For The Rating");
		lblend.setForeground(Color.GREEN);
		lblend.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblend.setBounds(458, 211, 236, 39);
		lblend.setVisible(false);
		frame.getContentPane().add(lblend);
		
		panelinput = new JPanel();
		panelinput.setBackground(Color.BLACK);
		panelinput.setBounds(149, 160, 257, 149);
		frame.getContentPane().add(panelinput);

		panelinput.setLayout(null);
		
		JLabel lblFSsn = new JLabel("F SSN");
		lblFSsn.setBounds(12, 13, 56, 16);
		panelinput.add(lblFSsn);
		lblFSsn.setForeground(Color.WHITE);
		lblFSsn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblHotelId = new JLabel("Hotel ID");
		lblHotelId.setBounds(12, 42, 73, 16);
		panelinput.add(lblHotelId);
		lblHotelId.setForeground(Color.WHITE);
		lblHotelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblRate = new JLabel("RATE");
		lblRate.setBounds(12, 71, 56, 16);
		panelinput.add(lblRate);
		lblRate.setForeground(Color.WHITE);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtfssn = new JTextField();
		txtfssn.setBounds(98, 10, 147, 22);
		panelinput.add(txtfssn);
		txtfssn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfssn.setColumns(10);
		
		txthotelid = new JTextField();
		txthotelid.setBounds(97, 39, 147, 22);
		panelinput.add(txthotelid);
		txthotelid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txthotelid.setColumns(10);
		
		txtrate = new JTextField();
		txtrate.setBounds(98, 68, 56, 22);
		panelinput.add(txtrate);
		txtrate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrate.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(166, 71, 106, 16);
		panelinput.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setForeground(Color.WHITE);
		
		JLabel label_1 = new JLabel("10");
		label_1.setBounds(176, 72, 56, 16);
		panelinput.add(label_1);
		label_1.setForeground(Color.WHITE);
		
		JButton btnRate = new JButton("RATE");
		btnRate.setBounds(71, 111, 97, 25);
		panelinput.add(btnRate);
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            /*create or replace procedure ratings_update(ho_id  ratings.h_id%type,fssn  ratings.f_ssn%type,c_rating  ratings.cust_rating%type) is
                      avg_r ratings.cust_rating%type;
                      begin
                      insert into ratings values(ho_id,fssn,c_rating);
                      select avg(cust_rating) into avg_r from ratings where h_id=ho_id group by h_id;
                      update hotel set avg_rating=avg_r where hotel_id=ho_id;
                      update hotel set tot_ratings=tot_ratings+1 where hotel_id=ho_id;
                      end;
                       /
                        
                       */
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");
				
					CallableStatement stmt = null;
					
					
					String str1=txthotelid.getText();
					String str2=txtrate.getText();
					String str3=txtfssn.getText();
					
					stmt = con.prepareCall("{call ratings_update(?,?,?)}");
					stmt.setInt(1,Integer.parseInt(str1));
					stmt.setInt(2,Integer.parseInt(str3));
					stmt.setInt(3,Integer.parseInt(str2));

				
					stmt.executeUpdate();
					con.close();

				} catch (Exception exc) {
					System.out.println(exc);
				}
				lblend.setVisible(true);
				panelinput.setVisible(false);
				btnBack.setVisible(true);
			}
		});
		btnRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Lodgify info = new Lodgify();
				Lodgify.main(null);
				frame.setVisible(false);
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(518, 273, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}
