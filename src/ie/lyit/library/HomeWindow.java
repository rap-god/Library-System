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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The first window seen by the user after launching the application.
 * @author Sean Morris - l00095752
 *
 */
public class HomeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField lblSearch;

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

	/**
	 * Create the frame.
	 */
	public HomeWindow() {
		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/header.png")));
		lblHeader.setBounds(0, 0, 404, 60);
		contentPane.add(lblHeader);
		
		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBackground(new Color(65, 105, 225));
		pnlSeparator.setBounds(0, 60, 394, 19);
		contentPane.add(pnlSeparator);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);
		
		JLabel lblBookImage = new JLabel("");
		lblBookImage.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/placeholder.jpg")));
		lblBookImage.setBounds(29, 164, 342, 313);
		contentPane.add(lblBookImage);
		
		lblSearch = new JTextField();
		lblSearch.setBounds(29, 90, 243, 23);
		contentPane.add(lblSearch);
		lblSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(282, 90, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(29, 124, 130, 29);
		contentPane.add(btnBrowse);
		
		JButton btnLogin = new JButton("Log in / Register");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login loginScreen = new Login();
				loginScreen.setVisible(true);
			}
		});
		btnLogin.setBounds(241, 124, 130, 29);
		contentPane.add(btnLogin);
		
		JButton btnViewBook = new JButton("View Book");
		btnViewBook.setBounds(29, 488, 130, 29);
		contentPane.add(btnViewBook);
		
		JButton lblBorrow = new JButton("Borrow Book");
		lblBorrow.setBounds(241, 488, 130, 29);
		contentPane.add(lblBorrow);
	}
}
