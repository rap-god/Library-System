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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle("[BOOK TITLE]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(215, 11, 234, 201);
		contentPane.add(lblImage);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 34, 32, 21);
		contentPane.add(lblTitle);
		
		txtGrapes = new JTextField();
		txtGrapes.setText(b.getTitle());
		txtGrapes.setEditable(false);
		txtGrapes.setBounds(52, 34, 153, 20);
		contentPane.add(txtGrapes);
		txtGrapes.setColumns(10);
		
		txtSteinbeck = new JTextField();
		txtSteinbeck.setText(b.getAuthor());
		txtSteinbeck.setEditable(false);
		txtSteinbeck.setColumns(10);
		txtSteinbeck.setBounds(52, 65, 153, 20);
		contentPane.add(txtSteinbeck);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(b.getPublishedYear()));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(52, 96, 153, 20);
		contentPane.add(textField_2);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 66, 42, 21);
		contentPane.add(lblAuthor);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(10, 96, 32, 21);
		contentPane.add(lblYear);
		
		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setText(b.getDescription());
		txtrDescription.setBounds(10, 246, 458, 261);
		contentPane.add(txtrDescription);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(124, 518, 110, 45);
		contentPane.add(btnBack);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setBounds(244, 518, 110, 45);
		contentPane.add(btnBorrow);
		
		BufferedImage img = null;

		try {
			//img = ImageIO.read(new File("images/placeholder.jpg"));
			img = ImageIO.read(ClassLoader.getSystemResource("images/placeholder.jpg"));
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Image scaledImage = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		lblImage.setIcon(icon);
		
	}
}
