package ie.lyit.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtGrapes;
	private JTextField txtSteinbeck;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBook frame = new ViewBook();
					frame.setVisible(true);
					
					// Set system look and feel ...
					UIManager.setLookAndFeel(
	        		UIManager.getSystemLookAndFeelClassName());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewBook() {
		Database data = new Database();
		Book b = new Book();
		try {
			b = data.getBookByTitle("Grapes of Wrath");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle(b.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 683);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(215, 92, 234, 201);
		contentPane.add(lblImage);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 115, 32, 21);
		contentPane.add(lblTitle);
		
		txtGrapes = new JTextField();
		txtGrapes.setText(b.getTitle());
		txtGrapes.setEditable(false);
		txtGrapes.setBounds(52, 115, 153, 20);
		contentPane.add(txtGrapes);
		txtGrapes.setColumns(10);
		
		txtSteinbeck = new JTextField();
		txtSteinbeck.setText(b.getAuthor());
		txtSteinbeck.setEditable(false);
		txtSteinbeck.setColumns(10);
		txtSteinbeck.setBounds(52, 146, 153, 20);
		contentPane.add(txtSteinbeck);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(b.getPublishedYear()));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(52, 177, 153, 20);
		contentPane.add(textField_2);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 147, 42, 21);
		contentPane.add(lblAuthor);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(10, 177, 32, 21);
		contentPane.add(lblYear);
		
		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setEditable(false);
		txtrDescription.setText(b.getDescription());
		txtrDescription.setBounds(10, 327, 458, 261);
		txtrDescription.setLineWrap(true);
		contentPane.add(txtrDescription);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeWindow home = new HomeWindow();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(124, 599, 110, 45);
		contentPane.add(btnBack);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setBounds(244, 599, 110, 45);
		contentPane.add(btnBorrow);
		
		BufferedImage img = null;

		try {
			img = ImageIO.read(ClassLoader.getSystemResource("images/placeholder.jpg"));
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Image scaledImage = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		lblImage.setIcon(icon);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewBook.class.getResource("/images/header.png")));
		label.setBounds(0, 0, 491, 60);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 60, 491, 19);
		contentPane.add(panel);
		
	}
}
