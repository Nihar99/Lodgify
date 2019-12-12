package Lodgify;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;

import javax.swing.JLabel;



import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import ratinglogin.ratinglogin;

public class Lodgify {

	private JFrame Lodgify;
	private JTextField txtlocation;
	private JList listhotels; 
	private JList listrooms;
	int[] hotelid = new int[100];
	int roomno[] = new int[100];
	String type[] = new String[100];
	private JPanel details;
	private JTextField txtssn;
	private JTextField txtname;
	private JTextField txtcontact;
	private JTextField txtadults;
	private JTextField txtchildren;
	private JLabel booked;
	private JPanel panelbutton;
	private JCheckBox chckbxfacilityone;
	private JCheckBox chckbxfacilitytwo;
	private JCheckBox chckbxfacilitythree;
	private JPanel panelfacilities;
	private JLabel lblty ;
	private JButton btnbook;
	private JPanel panelrate;
	private JLabel lblhotelid ;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lodgify window = new Lodgify();
					window.Lodgify.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lodgify() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Lodgify = new JFrame();
		Lodgify.getContentPane().setBackground(Color.BLACK);
		Lodgify.setBackground(Color.WHITE);
		Lodgify.setSize(1686,875);
		//Lodgify.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Lodgify.setVisible(true);
		Lodgify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lodgify.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(433, 13, 944, 157);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Raptor\\Desktop\\django\\btre_project\\static\\img\\logo1.jpg"));
		Lodgify.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(116, 190, 793, -5);
		separator.setForeground(Color.WHITE);
		Lodgify.getContentPane().add(separator);
		
		JLabel lblEnterLocation = new JLabel("Enter Location");
		lblEnterLocation.setBounds(441, 198, 135, 38);
		lblEnterLocation.setForeground(Color.WHITE);
		lblEnterLocation.setFont(new Font("Tahoma", Font.BOLD, 17));
		Lodgify.getContentPane().add(lblEnterLocation);
		
		txtlocation = new JTextField();
		txtlocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtlocation.setBounds(625, 208, 444, 22);
		Lodgify.getContentPane().add(txtlocation);
		txtlocation.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(1124, 206, 97, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i = 0;
					booked.setText(null);
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    ResultSet rs = stmt.executeQuery("select hotel_id,hotel_name from hotel where location = '"+txtlocation.getText()+"' order by avg_rating desc ");
				    DefaultListModel dlm = new DefaultListModel();
				    while (rs.next())
				    {
				    	dlm.addElement(rs.getString(2));
				    	hotelid[i] = rs.getInt(1);
				    	i = i + 1;
				    	
				    }
				    
				   listhotels.setModel(dlm);
				   
				
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				lblty.setVisible(false);
				lblhotelid.setVisible(false);
				panelbutton.setVisible(false);
				panelfacilities.setVisible(false);
				details.setVisible(false);
				btnbook.setVisible(false);
			
			}
			
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lodgify.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 433, 36, -23);
		Lodgify.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setBounds(270, 458, 194, -115);
		list.setBackground(Color.LIGHT_GRAY);
		Lodgify.getContentPane().add(list);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(279, 341, -11, 117);
		Lodgify.getContentPane().add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(462, 341, -168, 104);
		Lodgify.getContentPane().add(scrollPane_3);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(462, 356, -177, 38);
		Lodgify.getContentPane().add(scrollPane_7);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(306, 452, 2, -91);
		Lodgify.getContentPane().add(scrollPane_11);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.setBounds(82, 628, 97, 25);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int i = 0;
					String hh = listhotels.getSelectedValue().toString();
				    int ind = listhotels.getSelectedIndex();
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    int a = hotelid[ind];
				    ResultSet rs = stmt.executeQuery(" select room_no,type from room where h_id ="+a+" and status='Vacant'  group by room_no,type");
				    DefaultListModel dlm = new DefaultListModel();
				    while(rs.next())
				    {
				    	 dlm.addElement("Room_no:" + rs.getInt(1) + " " +"Type:" + rs.getString(2));
				    	 roomno[i] = rs.getInt(1);
				    	 type[i] = rs.getString(2);
				    	 i = i + 1;
				         
				    	 
				    }
				    
				    booked.setText(null);
				   listrooms.setModel(dlm);
				   
				
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				lblty.setVisible(false);
				btnbook.setVisible(true);
				lblhotelid.setVisible(false);
				panelbutton.setVisible(false);
				panelfacilities.setVisible(false);
				details.setVisible(false);

				
			}
		
		});
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lodgify.getContentPane().add(btnSelect);
		
		JLabel lblHotelsNearYou = new JLabel("Hotels near you");
		lblHotelsNearYou.setBounds(68, 249, 131, 16);
		lblHotelsNearYou.setForeground(Color.WHITE);
		lblHotelsNearYou.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lodgify.getContentPane().add(lblHotelsNearYou);
		
		listhotels = new JList();
		listhotels.setBounds(12, 278, 241, 330);
		listhotels.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Lodgify.getContentPane().add(listhotels);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(373, 249, 56, 16);
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
		Lodgify.getContentPane().add(lblRoom);
		
		listrooms = new JList();
		listrooms.setBounds(280, 278, 257, 330);
		listrooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lodgify.getContentPane().add(listrooms);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(362, 183, 933, 2);
		Lodgify.getContentPane().add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(320, 290, -2, 172);
		Lodgify.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(320, 472, 144, 2);
		Lodgify.getContentPane().add(scrollPane_4);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(320, 290, 2, 2);
		Lodgify.getContentPane().add(scrollPane_5);
		
		btnbook = new JButton("BOOK");
		btnbook.setBounds(367, 628, 97, 25);
		btnbook.setVisible(false);
		
		btnbook.addActionListener(new ActionListener() {
		
		
			public void actionPerformed(ActionEvent e) {
				String hh = listrooms.getSelectedValue().toString();
				if(hh==null)
				{
					
				}
				else {
				details.setVisible(true);
				booked.setText(null);
				txtssn.setText(null);
				
				}
			}
		});
		btnbook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lodgify.getContentPane().add(btnbook);
		
		details = new JPanel();
		details.setBounds(579, 259, 473, 330);
		details.setVisible(false);
		details.setBackground(Color.BLACK);
		Lodgify.getContentPane().add(details);
		details.setLayout(null);
		
		JLabel lblEnterYourDetails = new JLabel("Enter your Details");
		lblEnterYourDetails.setForeground(Color.WHITE);
		lblEnterYourDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnterYourDetails.setBounds(166, 13, 177, 27);
		details.add(lblEnterYourDetails);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setForeground(Color.WHITE);
		lblSsn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSsn.setBounds(43, 58, 56, 16);
		details.add(lblSsn);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(43, 98, 56, 16);
		details.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("contact");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(43, 142, 56, 16);
		details.add(lblNewLabel_2);
		
		JLabel lblNoOfAdults = new JLabel("no of adults");
		lblNoOfAdults.setForeground(Color.WHITE);
		lblNoOfAdults.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNoOfAdults.setBounds(24, 191, 104, 16);
		details.add(lblNoOfAdults);
		
		JLabel lblNoOfChildren = new JLabel("no of children");
		lblNoOfChildren.setForeground(Color.WHITE);
		lblNoOfChildren.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNoOfChildren.setBounds(24, 233, 104, 16);
		details.add(lblNoOfChildren);
		
		txtssn = new JTextField();
		txtssn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtssn.setBounds(140, 56, 256, 22);
		details.add(txtssn);
		txtssn.setColumns(10);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtname.setBounds(140, 96, 256, 22);
		details.add(txtname);
		txtname.setColumns(10);
		
		txtcontact = new JTextField();
		txtcontact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcontact.setBounds(140, 140, 256, 22);
		details.add(txtcontact);
		txtcontact.setColumns(10);
		
		txtadults = new JTextField();
		txtadults.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtadults.setBounds(140, 189, 256, 22);
		details.add(txtadults);
		txtadults.setColumns(10);
		
		txtchildren = new JTextField();
		txtchildren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtchildren.setBounds(140, 231, 256, 22);
		details.add(txtchildren);
		txtchildren.setColumns(10);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				try {
					int ind = listhotels.getSelectedIndex();
				    int ind1 = listrooms.getSelectedIndex();
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
			    Statement stmt = con.createStatement();	
			    int b = roomno[ind1];
			    int c = hotelid[ind];
			    stmt.execute(" insert into family values ('"+txtssn.getText()+"','"+txtname.getText()+"','"+txtlocation.getText()+"','"+txtcontact.getText()+"','"+txtadults.getText()+"','"+txtchildren.getText()+"')");
			    stmt.executeUpdate("update room set f_ssn = '"+txtssn.getText()+"' where room_no = "+b+" and h_id = "+c+" ");
			   
			    stmt.executeUpdate("update room set status = 'booked' where room_no = "+b+" and h_id = '"+c+"' ");
			    booked.setText("Room booked Successfully");
			    
			    txtname.setText(null);txtlocation.setText(null);txtcontact.setText(null);txtadults.setText(null);txtchildren.setText(null);
		
			    DefaultListModel dlm =  (DefaultListModel) listrooms.getModel();
			    if(ind1 != -1)
			    {
			    	dlm.removeAllElements();
			    }
			    details.setVisible(false);
			    panelbutton.setVisible(true);
			    lblhotelid.setText("Hotel ID is:" + " " + hotelid[ind]);
			    lblhotelid.setVisible(true);
			    
			    
			
			    con.close();
			    con.close();
			    con.close();
			}
				catch (SQLException ex) {
					
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
				booked.setVisible(true);
				btnbook.setVisible(false);
				panelrate.setVisible(true);
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm.setBounds(180, 278, 123, 25);
		details.add(btnConfirm);
		
		booked = new JLabel("");
		booked.setBounds(306, 666, 247, 32);
		booked.setFont(new Font("Tahoma", Font.BOLD, 17));
		booked.setForeground(Color.GREEN);
		Lodgify.getContentPane().add(booked);
		booked.setVisible(false);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(32, 751, 212, -5);
		Lodgify.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(286, 711, 1080, 1);
		Lodgify.getContentPane().add(separator_3);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(12, 290, 21, 221);
		Lodgify.getContentPane().add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(279, 290, 21, 48);
		Lodgify.getContentPane().add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(287, 290, 21, 238);
		Lodgify.getContentPane().add(scrollBar_2);
		
		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(12, 311, 21, 200);
		Lodgify.getContentPane().add(scrollBar_3);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(12, 555, 229, -275);
		Lodgify.getContentPane().add(scrollPane_6);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(292, 278, -7, -5);
		Lodgify.getContentPane().add(scrollPane_8);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(279, 278, 257, 276);
		Lodgify.getContentPane().add(scrollPane_10);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_10.setColumnHeaderView(scrollPane_13);
		
		JScrollPane scrollPane_14 = new JScrollPane();
		scrollPane_10.setRowHeaderView(scrollPane_14);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(12, 278, 229, 276);
		Lodgify.getContentPane().add(scrollPane_12);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_12.setRowHeaderView(scrollPane_9);
		
		panelbutton = new JPanel();
		panelbutton.setBackground(Color.BLACK);
		panelbutton.setBounds(1119, 401, 131, 32);
		Lodgify.getContentPane().add(panelbutton);
		panelbutton.setLayout(null);
		panelbutton.setVisible(false);
		
		JButton btnFacilities = new JButton("Facilities");
		btnFacilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
			    Statement stmt = con.createStatement();	
			    int ind = listhotels.getSelectedIndex();
			    int i = 0;
			    int a = hotelid[ind];
			    ResultSet rs = stmt.executeQuery("select facility_name from facility where h_id = "+a+" ");
			    
			   if (rs.next()) 
			       chckbxfacilityone.setText(rs.getString(1));
			   else
				   chckbxfacilityone.setVisible(false);
			   if(rs.next())
				   chckbxfacilitytwo.setText(rs.getString(1));
			   else
				   chckbxfacilitytwo.setVisible(false);
			   if(rs.next())
			       chckbxfacilitythree.setText(rs.getString(1));
			       else
				   chckbxfacilitythree.setVisible(false);
			   
			
			   
			   
			   
			    
			    
		
			    
			    
			    con.close();
			}
				catch (SQLException ex) {
					
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
				panelfacilities.setVisible(true);
				booked.setVisible(false);
				lblhotelid.setVisible(false);
				
				
				
				
			}
		});
		btnFacilities.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFacilities.setBounds(12, 0, 97, 25);
		panelbutton.add(btnFacilities);
		
		panelfacilities = new JPanel();
		panelfacilities.setBackground(Color.BLACK);
		panelfacilities.setForeground(Color.WHITE);
		panelfacilities.setBorder(null);
		panelfacilities.setBounds(1287, 264, 346, 264);
		Lodgify.getContentPane().add(panelfacilities);
		panelfacilities.setLayout(null);
		panelfacilities.setVisible(false);
		
		JLabel lblSelectYourFacilities = new JLabel("Select your facilities");
		lblSelectYourFacilities.setForeground(Color.WHITE);
		lblSelectYourFacilities.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectYourFacilities.setBounds(90, 13, 170, 16);
		panelfacilities.add(lblSelectYourFacilities);
		
		chckbxfacilityone = new JCheckBox("facility one");
		chckbxfacilityone.setForeground(Color.BLACK);
		chckbxfacilityone.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxfacilityone.setBounds(25, 56, 176, 25);
		panelfacilities.add(chckbxfacilityone);
		
		chckbxfacilitytwo = new JCheckBox("facility two");
		chckbxfacilitytwo.setForeground(Color.BLACK);
		chckbxfacilitytwo.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxfacilitytwo.setBounds(25, 86, 176, 25);
		panelfacilities.add(chckbxfacilitytwo);
		
		chckbxfacilitythree = new JCheckBox("facility three");
		chckbxfacilitythree.setForeground(Color.BLACK);
		chckbxfacilitythree.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxfacilitythree.setBounds(25, 116, 176, 25);
		panelfacilities.add(chckbxfacilitythree);
		
		JButton btnConfirm_1 = new JButton("Confirm");
		btnConfirm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
			    Statement stmt = con.createStatement();
				int ind = listhotels.getSelectedIndex();
				int a = hotelid[ind];
				 for (Component c: panelfacilities.getComponents()) {
					if(c.getClass().equals(JCheckBox.class)) {
						chckbxfacilityone = (JCheckBox) c;
						if(chckbxfacilityone.isSelected())
							stmt.executeQuery("insert into facilitybooked values ('"+txtssn.getText()+"' , '"+chckbxfacilityone.getText()+"', "+a+" )");
						    chckbxfacilityone.setSelected(false);
						
						}}
				 for (Component c: panelfacilities.getComponents()) {
					if(c.getClass().equals(JCheckBox.class)) {
						chckbxfacilitytwo = (JCheckBox) c;
						if(chckbxfacilitytwo.isSelected())
							stmt.executeQuery("insert into facilitybooked values ('"+txtssn.getText()+"' , '"+chckbxfacilitytwo.getText()+"', "+a+" )");
						chckbxfacilitytwo.setSelected(false);
					}}
				 for (Component c: panelfacilities.getComponents()) {
					if(c.getClass().equals(JCheckBox.class)) {
						chckbxfacilitythree = (JCheckBox) c;
						if(chckbxfacilitythree.isSelected())
							stmt.executeQuery("insert into facilitybooked values ('"+txtssn.getText()+"' , '"+chckbxfacilitythree.getText()+"', "+a+" )");
						chckbxfacilitythree.setSelected(false);
					}}
				
				con.close();
				con.close();
				con.close();
				
				
				
			}
				
				catch (SQLException ex) {
				
		        System.out.println(ex);

		    }catch (ClassNotFoundException ex) {

		        System.out.println(ex);			
		    }
				
				
				panelfacilities.setVisible(false);
				lblty.setVisible(true);
				panelbutton .setVisible(false);
				panelrate.setVisible(true);
		
				
				
				

			
			}
		
			
		});
		
		btnConfirm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm_1.setBounds(133, 168, 97, 25);
		panelfacilities.add(btnConfirm_1);
		
		lblty = new JLabel("Thank You!");
		lblty.setForeground(Color.GREEN);
		lblty.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblty.setBounds(815, 666, 219, 32);
		Lodgify.getContentPane().add(lblty);
		
		panelrate = new JPanel();
		panelrate.setBackground(Color.BLACK);
		panelrate.setForeground(Color.BLACK);
		panelrate.setBounds(772, 749, 212, 32);
		Lodgify.getContentPane().add(panelrate);
		panelrate.setLayout(null);
		
		
		JButton btnRate = new JButton("RATE");
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ratinglogin info = new ratinglogin();
				ratinglogin.main(null);
				Lodgify.setVisible(false);
				
				
			}
		});
		btnRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRate.setBounds(34, 0, 143, 32);
		panelrate.add(btnRate);
		
		lblhotelid = new JLabel("HOTEL ID:");
		lblhotelid.setForeground(Color.RED);
		lblhotelid.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblhotelid.setBounds(594, 682, 174, 16);
		lblhotelid.setVisible(false);
		Lodgify.getContentPane().add(lblhotelid);
		lblty.setVisible(false);
		
	}	
}
	


