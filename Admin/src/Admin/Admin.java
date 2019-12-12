package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import AdminAdd.AdminAdd;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin {

	private JFrame frmAdminLogin;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.getContentPane().setBackground(Color.BLACK);
		frmAdminLogin.setBounds(300, 300, 615, 373);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lbladminlogin = new JLabel("Admin Login");
		lbladminlogin.setForeground(Color.WHITE);
		lbladminlogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbladminlogin.setBounds(235, 24, 145, 78);
		frmAdminLogin.getContentPane().add(lbladminlogin);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setForeground(Color.WHITE);
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblusername.setBounds(74, 127, 105, 44);
		frmAdminLogin.getContentPane().add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpassword.setBounds(74, 169, 73, 62);
		frmAdminLogin.getContentPane().add(lblpassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(191, 135, 256, 27);
		frmAdminLogin.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(191, 187, 256, 29);
		frmAdminLogin.getContentPane().add(txtpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtpassword.getText();
				String username = txtusername.getText();
				
				if (password.contains("Oracle")&& username.contains("Nihar")) {
					txtpassword.setText(null);
					txtusername.setText(null);
					
					//AdminAdd info = new AdminAdd();
					AdminAdd.main(null);
			        frmAdminLogin.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtpassword.setText(null);
					txtusername.setText(null);
				}
			}
		});
		btnLogin.setBounds(74, 263, 97, 25);
		frmAdminLogin.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtusername.setText(null);
				txtpassword.setText(null);
				
			}
		});
		btnReset.setBounds(240, 263, 97, 25);
		frmAdminLogin.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminLogin = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmAdminLogin, "Cofirm exit","Admin",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(411, 263, 97, 25);
		frmAdminLogin.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(73, 229, 435, 2);
		frmAdminLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(74, 82, 434, 2);
		frmAdminLogin.getContentPane().add(separator_1);
	}
}
