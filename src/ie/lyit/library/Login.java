package ie.lyit.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

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
		setTitle("Library - Login/Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("User Login");
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeading.setBounds(120, 11, 88, 27);
		contentPane.add(lblHeading);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(25, 56, 75, 27);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(110, 49, 204, 32);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(25, 94, 75, 27);
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Database data = new Database();
					@SuppressWarnings("deprecation")
					String returnString = data.validLogin(
							txtUsername.getText(), txtPassword.getText());
					if (returnString.equals("Member")) {
						Member m = new Member(txtUsername.getText());
						Member.setCurrentMember(m);
						JOptionPane
								.showMessageDialog(null, "Login Successful!");
						MainScreen window = new MainScreen();
						window.setVisible(true);
						dispose();
					}

					else if (returnString.equals("Librarian")) {
						JOptionPane.showMessageDialog(null,
								"Welcome, Librarian!");
						Member.loggedOn = true;
						LibrarianScreen frame = new LibrarianScreen();
						frame.setVisible(true);
						dispose();
					}

					else {
						JOptionPane.showMessageDialog(null,
								"Incorrect Login details!");
						data.closeConnection();
						txtUsername.setText("");
						txtPassword.setText("");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(25, 132, 89, 38);
		contentPane.add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreen frame;
				try {
					frame = new MainScreen();
					frame.setVisible(true);
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnCancel.setBounds(225, 132, 89, 38);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel(
				"Click register if you do not have an account!");
		lblNewLabel.setBounds(70, 170, 212, 27);
		contentPane.add(lblNewLabel);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registerWindow = new Registration();
				registerWindow.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(25, 199, 289, 32);
		contentPane.add(btnRegister);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(110, 92, 204, 32);
		contentPane.add(txtPassword);
	}
}
