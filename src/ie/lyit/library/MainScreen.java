package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.io.IOException;

public class MainScreen extends JFrame{
	private JTextField textField;
	
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
						MainScreen frame = new MainScreen();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} 
			}); 
		}
		
		public MainScreen() throws SQLException {
			
				final CardLayout c1 = new CardLayout(0,0);
			
				setResizable(false);
				setTitle("Library");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 678, 530);
				JPanel contentPane = new JPanel();
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblHeader = new JLabel("");
				lblHeader.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/header.png")));
				lblHeader.setBounds(135, 0, 453, 60);
				contentPane.add(lblHeader);
				
				JPanel pnlSeparator = new JPanel();
				pnlSeparator.setBackground(new Color(65, 105, 225));
				pnlSeparator.setBounds(0, 60, 672, 19);
				contentPane.add(pnlSeparator);
				
				JButton btnLoginRegister = new JButton("Login / Register");
				btnLoginRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							Login loginScreen = new Login();
							loginScreen.setVisible(true);
							dispose();
						}
				});
				btnLoginRegister.setBounds(20, 89, 124, 23);
				contentPane.add(btnLoginRegister);
				
				textField = new JTextField();
				textField.setBounds(372, 90, 170, 20);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("Search");
				btnNewButton.setBounds(563, 89, 89, 23);
				contentPane.add(btnNewButton);
				
				Database data = new Database();
				Book b = new Book();
				try {
					b = data.getBookByTitle("Grapes of Wrath");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				//txtAuthor.setText()
				
				@SuppressWarnings("unchecked")
				final JList list = new JList(Database.select().toArray());

				list.setBackground(Color.LIGHT_GRAY);
				
				//list.setBackground(Color.LIGHT_GRAY);
				list.setBounds(372, 127, 280, 322);
				contentPane.add(list);
				
				//if(Member.loggedOn = true){
					JButton btnBorrow = new JButton("Borrow");
					
					btnBorrow.setBounds(474, 460, 89, 23);
					contentPane.add(btnBorrow);
					
					final JPanel jplMainPanel = new JPanel();
					jplMainPanel.setBounds(20, 127, 280, 329);
					contentPane.add(jplMainPanel);
					jplMainPanel.setLayout(c1);
					
					JLabel lblImage = new JLabel("");
					lblImage.setIcon(new ImageIcon(MainScreen.class.getResource("/images/placeholder.jpg")));
					jplMainPanel.add(lblImage, "name_1196884078311");
					
					JPanel jplDetailsPanel = new JPanel();
					jplDetailsPanel.setBackground(Color.WHITE);
					jplMainPanel.add(jplDetailsPanel, "name_1373888375022");
					jplDetailsPanel.setLayout(null);
					
					JLabel lblSmallImage = new JLabel("");
					lblSmallImage.setBounds(166, 0, 114, 91);
					jplDetailsPanel.add(lblSmallImage);
					
					final JLabel lblTitle = new JLabel("");
					lblTitle.setBounds(0, 0, 81, 23);
					jplDetailsPanel.add(lblTitle);
					
					JLabel lblAuthor = new JLabel("");
					lblAuthor.setBounds(0, 34, 81, 23);
					jplDetailsPanel.add(lblAuthor);
					
					JLabel lblPublisher = new JLabel("");
					lblPublisher.setBounds(0, 68, 81, 23);
					jplDetailsPanel.add(lblPublisher);
					
					JTextArea txtDescription = new JTextArea();
					txtDescription.setEditable(false);
					txtDescription.setBounds(10, 102, 260, 216);
					jplDetailsPanel.add(txtDescription);
					
					list.addListSelectionListener(new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent arg0) {
							Book selectedBook = (Book) list.getSelectedValue();
							c1.last(jplMainPanel);
							lblTitle.setText(selectedBook.getTitle());
						}
						
					});
					
					if (list.isSelectionEmpty()) {
						c1.first(jplMainPanel);
					}
					
					
					BufferedImage img = null;

					try {
						img = ImageIO.read(ClassLoader.getSystemResource("images/placeholder.jpg"));
					}
					
					catch (IOException e) {
						e.printStackTrace();
					}
					
					Image scaledImage = img.getScaledInstance(lblSmallImage.getWidth(), lblSmallImage.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(scaledImage);
					lblSmallImage.setIcon(icon); 
					
				}
}
