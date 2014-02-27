package ie.lyit.library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * The first window seen by the user after launching the application.
 * @author Sean Morris - l00095752
 *
 */
public class Login extends JFrame {
	private JTextField txtfUsername;
	private JTextField txtFPassword;
	public Login() {
		
		JLabel lblPleaseLoginUsing = new JLabel("Please login using your username and password");
		lblPleaseLoginUsing.setFont(new Font("Tahoma", Font.ITALIC, 14));
		getContentPane().add(lblPleaseLoginUsing, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(57, 30, 91, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(57, 55, 79, 14);
		panel.add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(47, 98, 89, 23);
		panel.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(204, 98, 89, 23);
		panel.add(btnLogin);
		
		txtfUsername = new JTextField();
		txtfUsername.setBounds(158, 29, 135, 20);
		panel.add(txtfUsername);
		txtfUsername.setColumns(10);
		
		txtFPassword = new JTextField();
		txtFPassword.setBounds(158, 54, 135, 20);
		panel.add(txtFPassword);
		txtFPassword.setColumns(10);
	}

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
				
				try {
					HomeWindow frame = new HomeWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	
	}
}
