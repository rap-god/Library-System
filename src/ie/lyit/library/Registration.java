package ie.lyit.library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.*;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

/**
 * The first window seen by the user after launching the application.
 * @author Sean Morris - l00095752
 *
 */
public class Registration extends JFrame {
	

	private JPanel contentPane;
	// Constant to indicate there are 3 houses
	private final int NUM_OF_PICS = 3;
	private JTable table;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtComparePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            // Set system look and feel ...
					UIManager.setLookAndFeel(
	        		UIManager.getSystemLookAndFeelClassName());
				} 
				
				catch (Exception e) {
					System.out.println(e.getMessage());
				}			
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		final Database data = new Database();
		setResizable(false);
		setTitle("Library - Register new user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 305);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(Registration.class.getResource("/images/header.png")));
		lblHeader.setBounds(0, 0, 394, 60);
		contentPane.add(lblHeader);
		
		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBackground(new Color(65, 105, 225));
		pnlSeparator.setBounds(0, 60, 394, 19);
		contentPane.add(pnlSeparator);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtComparePassword.getText().isEmpty()) {
						throw new IllegalArgumentException("Fields must contain correct data!");
					}
					
					if (txtPassword.getText().equals(txtComparePassword.getText())) {
						ArrayList<String> currentMembers = data.getMembers();
						for(String s : currentMembers) {
							if(txtUsername.getText().equals(s)) {
								throw new IllegalArgumentException("Member already exists!");
							}
						}
						data.registerUser(txtUsername.getText(), txtPassword.getText());
						Member newMember = new Member(txtUsername.getText());
						Member.setCurrentMember(newMember);
						Member.loggedOn = true;
						JOptionPane.showMessageDialog(null, "Registration Successful!");
						MainScreen frame = new MainScreen();
						frame.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Passwords don't match.");
						txtUsername.setText("");
						txtPassword.setText("");
						txtComparePassword.setText("");
					}
				}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				catch(IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					txtUsername.setText("");
					txtPassword.setText("");
					txtComparePassword.setText("");
				}
			}
		});
		btnRegister.setBounds(25, 237, 138, 29);
		contentPane.add(btnRegister);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(46, 136, 138, 29);
		contentPane.add(lblNewPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password:");
		lblReenterPassword.setBounds(46, 174, 149, 34);
		contentPane.add(lblReenterPassword);
		
		table = new JTable();
		table.setBounds(104, 304, 1, 1);
		contentPane.add(table);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(205, 90, 143, 29);
		contentPane.add(txtUsername);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(46, 90, 117, 29);
		contentPane.add(lblUsername);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				window.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(205, 237, 143, 29);
		contentPane.add(btnCancel);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(205, 136, 143, 29);
		contentPane.add(txtPassword);
		
		txtComparePassword = new JPasswordField();
		txtComparePassword.setBounds(205, 179, 143, 29);
		contentPane.add(txtComparePassword);
	
	}
}
