package AdminAdd;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class AdminAdd {

	private JFrame AdminAdd;
	private JTextField txthotel_id;
	private JTextField txtlocation;
	private JTextField txthotel_name;
	private JTextField txtroom_no;
	private JTextField txttype;
	private JTextField txtrate;
	private JTextField txtstatus;
	private JTextField txtf_id;
	private JTextField txtfoodrate;
	private JTextField txtfoodtype;
	private JTextField txtfacility_name;
	private JTextField txtfacilityrate;
	private JTextField txtfacilitiesh_id;
	private JTextField txtfh_id;
	private JTextField txtrh_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAdd window = new AdminAdd();
					window.AdminAdd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminAdd = new JFrame();
		AdminAdd.setSize(650,416);
		AdminAdd.setBounds(350, 350, 650, 423);
		AdminAdd.setVisible(true);
		AdminAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminAdd.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 621, 366);
		AdminAdd.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		tabbedPane.addTab("Hotels", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAddHotels = new JLabel("Add Hotels");
		lblAddHotels.setForeground(Color.WHITE);
		lblAddHotels.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddHotels.setBounds(241, 13, 176, 70);
		panel.add(lblAddHotels);
		
		JLabel lblHotelId = new JLabel("Hotel ID");
		lblHotelId.setForeground(Color.WHITE);
		lblHotelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHotelId.setBounds(56, 102, 88, 29);
		panel.add(lblHotelId);
		
		txthotel_id = new JTextField();
		txthotel_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txthotel_id.setBounds(178, 106, 263, 22);
		panel.add(txthotel_id);
		txthotel_id.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLocation.setBounds(56, 167, 88, 16);
		panel.add(lblLocation);
		
		txtlocation = new JTextField();
		txtlocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtlocation.setBounds(178, 165, 263, 22);
		panel.add(txtlocation);
		txtlocation.setColumns(10);
		
		JLabel lblHotelName = new JLabel("Hotel Name");
		lblHotelName.setForeground(Color.WHITE);
		lblHotelName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHotelName.setBounds(56, 217, 88, 16);
		panel.add(lblHotelName);
		
		txthotel_name = new JTextField();
		txthotel_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txthotel_name.setBounds(178, 217, 263, 22);
		panel.add(txthotel_name);
		txthotel_name.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(260, 81, 1, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(56, 81, 477, 2);
		panel.add(separator_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
			    Statement stmt = con.createStatement();	
			    stmt.execute("insert into hotel values ('"+txthotel_id.getText()+"','"+txtlocation.getText()+"','"+txthotel_name.getText()+"',0,0)");
			    txthotel_id.setText(null);
			    txtlocation.setText(null);
			    txthotel_name.setText(null);
			    
			    
			    con.close();
			}
				catch (SQLException ex) {
					
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
			}
			
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(119, 265, 97, 25);
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("delete from hotel where hotel_id = '"+txthotel_id.getText()+"'");
				    txthotel_id.setText(null);
				    txtlocation.setText(null);
				    txthotel_name.setText(null);
				    
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(344, 266, 97, 25);
		panel.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		tabbedPane.addTab("Room", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAddRooms = new JLabel("Add Rooms");
		lblAddRooms.setForeground(Color.WHITE);
		lblAddRooms.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddRooms.setBounds(239, 13, 175, 40);
		panel_1.add(lblAddRooms);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setForeground(Color.WHITE);
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRoomNo.setBounds(29, 73, 95, 26);
		panel_1.add(lblRoomNo);
		
		txtroom_no = new JTextField();
		txtroom_no.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtroom_no.setBounds(171, 77, 271, 22);
		panel_1.add(txtroom_no);
		txtroom_no.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblType.setBounds(29, 112, 56, 26);
		panel_1.add(lblType);
		
		txttype = new JTextField();
		txttype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttype.setBounds(171, 116, 271, 22);
		panel_1.add(txttype);
		txttype.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(Color.WHITE);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRate.setBounds(29, 151, 56, 40);
		panel_1.add(lblRate);
		
		txtrate = new JTextField();
		txtrate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrate.setBounds(171, 160, 271, 26);
		panel_1.add(txtrate);
		txtrate.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStatus.setBounds(29, 204, 56, 26);
		panel_1.add(lblStatus);
		
		txtstatus = new JTextField();
		txtstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtstatus.setBounds(171, 208, 271, 22);
		panel_1.add(txtstatus);
		txtstatus.setColumns(10);
		
		JButton btnAdd_1 = new JButton("ADD");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("insert into room values ('"+txtroom_no.getText()+"','"+txttype.getText()+"','"+txtrate.getText()+"','"+txtstatus.getText()+"',null,'"+txtrh_id.getText()+"')");
				    txtroom_no.setText(null);
				    txttype.setText(null);
				    txtrate.setText(null);
				    txtstatus.setText(null);
				    txtrh_id.setText(null);
				    
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				
				
			}
		});
		btnAdd_1.setForeground(Color.BLACK);
		btnAdd_1.setBounds(94, 298, 97, 25);
		panel_1.add(btnAdd_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(48, 52, 394, 2);
		panel_1.add(separator_2);
		
		JLabel lblHotelId_3 = new JLabel("Hotel ID");
		lblHotelId_3.setForeground(Color.WHITE);
		lblHotelId_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHotelId_3.setBounds(29, 254, 95, 16);
		panel_1.add(lblHotelId_3);
		
		txtrh_id = new JTextField();
		txtrh_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrh_id.setBounds(171, 253, 271, 22);
		panel_1.add(txtrh_id);
		txtrh_id.setColumns(10);
		
		JButton btnDelete_1 = new JButton("DELETE");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("delete from room where room_no = '"+txtroom_no.getText()+"' and h_id = '"+txtrh_id.getText()+"'");
				     
				    txtroom_no.setText(null);
				    txttype.setText(null);
				    txtrate.setText(null);
				    txtstatus.setText(null);
				    txtrh_id.setText(null);
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_1.setBounds(355, 298, 97, 25);
		panel_1.add(btnDelete_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		tabbedPane.addTab("Food", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblAddFood = new JLabel("Add Food");
		lblAddFood.setForeground(Color.WHITE);
		lblAddFood.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddFood.setBounds(246, 13, 108, 55);
		panel_2.add(lblAddFood);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(45, 66, 391, 2);
		panel_2.add(separator_3);
		
		JLabel lblFoodId = new JLabel("Food ID");
		lblFoodId.setForeground(Color.WHITE);
		lblFoodId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFoodId.setBounds(45, 102, 89, 31);
		panel_2.add(lblFoodId);
		
		txtf_id = new JTextField();
		txtf_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtf_id.setBounds(167, 108, 269, 22);
		panel_2.add(txtf_id);
		txtf_id.setColumns(10);
		
		JLabel lblRate_1 = new JLabel("Rate");
		lblRate_1.setForeground(Color.WHITE);
		lblRate_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRate_1.setBounds(45, 146, 68, 31);
		panel_2.add(lblRate_1);
		
		txtfoodrate = new JTextField();
		txtfoodrate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfoodrate.setBounds(167, 152, 269, 22);
		panel_2.add(txtfoodrate);
		txtfoodrate.setColumns(10);
		
		JLabel lblType_1 = new JLabel("Type");
		lblType_1.setForeground(Color.WHITE);
		lblType_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblType_1.setBounds(45, 190, 68, 31);
		panel_2.add(lblType_1);
		
		txtfoodtype = new JTextField();
		txtfoodtype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfoodtype.setBounds(167, 196, 269, 22);
		panel_2.add(txtfoodtype);
		txtfoodtype.setColumns(10);
		
		JButton btnAdd_2 = new JButton("ADD");
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("insert into food values ('"+txtf_id.getText()+"','"+txtfoodrate.getText()+"','"+txtfh_id.getText()+"','"+txtfoodtype.getText()+"')");
				    txtf_id.setText(null);
				    txtfoodrate.setText(null);
				    txtfh_id.setText(null);
				    txtfoodtype.setText(null);
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
				
			}
		});
		btnAdd_2.setBounds(128, 283, 97, 25);
		panel_2.add(btnAdd_2);
		
		JLabel lblHotelId_2 = new JLabel("Hotel ID");
		lblHotelId_2.setForeground(Color.WHITE);
		lblHotelId_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHotelId_2.setBounds(45, 246, 89, 16);
		panel_2.add(lblHotelId_2);
		
		txtfh_id = new JTextField();
		txtfh_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfh_id.setBounds(167, 245, 269, 22);
		panel_2.add(txtfh_id);
		txtfh_id.setColumns(10);
		
		JButton btnDelete_2 = new JButton("DELETE");
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("delete from food where f_id = '"+txtf_id.getText()+"'");
				    txtf_id.setText(null);
				    txtfoodrate.setText(null);
				    txtfh_id.setText(null);
				    txtfoodtype.setText(null);
				    
				    
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnDelete_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_2.setBounds(351, 283, 97, 25);
		panel_2.add(btnDelete_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		tabbedPane.addTab("Facilities", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblAddFacilities = new JLabel("Add Facilities");
		lblAddFacilities.setForeground(Color.WHITE);
		lblAddFacilities.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddFacilities.setBounds(230, 13, 175, 49);
		panel_3.add(lblAddFacilities);
		
		JLabel lblFacilityName = new JLabel("Facility Name");
		lblFacilityName.setForeground(Color.WHITE);
		lblFacilityName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFacilityName.setBounds(35, 102, 139, 41);
		panel_3.add(lblFacilityName);
		
		txtfacility_name = new JTextField();
		txtfacility_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfacility_name.setBounds(198, 113, 259, 22);
		panel_3.add(txtfacility_name);
		txtfacility_name.setColumns(10);
		
		JLabel lblRate_2 = new JLabel("Rate");
		lblRate_2.setForeground(Color.WHITE);
		lblRate_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRate_2.setBounds(50, 190, 56, 27);
		panel_3.add(lblRate_2);
		
		txtfacilityrate = new JTextField();
		txtfacilityrate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfacilityrate.setBounds(198, 194, 259, 22);
		panel_3.add(txtfacilityrate);
		txtfacilityrate.setColumns(10);
		
		JButton btnAdd_3 = new JButton("ADD");
		btnAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("insert into facility values ('"+txtfacilitiesh_id.getText()+"','"+txtfacilityrate.getText()+"','"+txtfacility_name.getText()+"')");
				    txtfacilitiesh_id.setText(null);
				    txtfacilityrate.setText(null);
				    txtfacility_name.setText(null);
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnAdd_3.setBounds(94, 258, 97, 25);
		panel_3.add(btnAdd_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(35, 75, 422, 1);
		panel_3.add(separator_4);
		
		JLabel lblHotelId_1 = new JLabel("HOTEL ID");
		lblHotelId_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHotelId_1.setForeground(Color.WHITE);
		lblHotelId_1.setBounds(45, 156, 107, 16);
		panel_3.add(lblHotelId_1);
		
		txtfacilitiesh_id = new JTextField();
		txtfacilitiesh_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfacilitiesh_id.setBounds(198, 148, 259, 22);
		panel_3.add(txtfacilitiesh_id);
		txtfacilitiesh_id.setColumns(10);
		
		JButton btnDelete_3 = new JButton("DELETE");
		btnDelete_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Nihar");	
				    Statement stmt = con.createStatement();	
				    stmt.execute("delete from facility where facility_name = '"+txtfacility_name.getText()+"' and h_id ='"+txtfacilitiesh_id.getText()+"' ");
				    txtfacilitiesh_id.setText(null);
				    txtfacilityrate.setText(null);
				    txtfacility_name.setText(null);
				    
				    
				    con.close();
				}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnDelete_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_3.setBounds(336, 258, 97, 25);
		panel_3.add(btnDelete_3);
	}
}
