package ie.lyit.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login/Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Username ");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(47, 45, 91, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 44, 135, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 69, 135, 20);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(47, 70, 79, 14);
		contentPane.add(label_1);
		
		JButton button = new JButton("Register");
		button.setBounds(37, 113, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Login");
		button_1.setBounds(194, 113, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("Please login using your username and password.");
		lblNewLabel.setBounds(37, 0, 263, 32);
		contentPane.add(lblNewLabel);
	}

}
