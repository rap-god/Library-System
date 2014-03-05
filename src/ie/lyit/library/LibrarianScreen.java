package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianScreen extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtFldTitle;
	private JTextField txtFldAuthor;
	private JTextField txtFldGenre;
	private JTextField txtFldPublisher;
	private JTextField txtFldYear;
	private JTextField txtFldDesc;
	private JTextField txtFldImage;

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
					LibrarianScreen frame = new LibrarianScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public LibrarianScreen() {
		
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
		
		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setBounds(47, 146, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author : ");
		lblAuthor.setBounds(47, 171, 46, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(47, 196, 46, 14);
		contentPane.add(lblGenre);
		
		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setBounds(47, 221, 68, 14);
		contentPane.add(lblPublisher);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setBounds(47, 246, 46, 14);
		contentPane.add(lblYear);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(47, 271, 68, 14);
		contentPane.add(lblDescription);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setBounds(47, 382, 46, 14);
		contentPane.add(lblImage);
		
		txtFldTitle = new JTextField();
		txtFldTitle.setBounds(137, 143, 206, 20);
		contentPane.add(txtFldTitle);
		txtFldTitle.setColumns(10);
		
		txtFldAuthor = new JTextField();
		txtFldAuthor.setBounds(137, 168, 206, 20);
		contentPane.add(txtFldAuthor);
		txtFldAuthor.setColumns(10);
		
		txtFldGenre = new JTextField();
		txtFldGenre.setBounds(137, 193, 206, 20);
		contentPane.add(txtFldGenre);
		txtFldGenre.setColumns(10);
		
		txtFldPublisher = new JTextField();
		txtFldPublisher.setBounds(137, 218, 206, 20);
		contentPane.add(txtFldPublisher);
		txtFldPublisher.setColumns(10);
		
		txtFldYear = new JTextField();
		txtFldYear.setBounds(137, 243, 206, 20);
		contentPane.add(txtFldYear);
		txtFldYear.setColumns(10);
		
		txtFldDesc = new JTextField();
		txtFldDesc.setBounds(137, 268, 206, 100);
		contentPane.add(txtFldDesc);
		txtFldDesc.setColumns(10);
		
		JButton btnViewMemberDetails = new JButton("View Member Details");
		btnViewMemberDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMembers frame = new ViewMembers();
				frame.setVisible(true);
			}
		});
		btnViewMemberDetails.setBounds(47, 90, 133, 23);
		contentPane.add(btnViewMemberDetails);
		
		JButton btnOverdueLoans = new JButton("View Overdue Loans");
		btnOverdueLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverdueLoans overdueLoans = new OverdueLoans();
				overdueLoans.setVisible(true);
			}
		});
		btnOverdueLoans.setBounds(210, 90, 133, 23);
		contentPane.add(btnOverdueLoans);
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.setBounds(47, 491, 133, 23);
		contentPane.add(btnRemoveBook);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(210, 491, 133, 23);
		contentPane.add(btnAddBook);
		
		txtFldImage = new JTextField();
		txtFldImage.setBounds(137, 379, 206, 20);
		contentPane.add(txtFldImage);
		txtFldImage.setColumns(10);
		
		
	}
}
