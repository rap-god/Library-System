package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;

public class ViewMembers extends JFrame{
	private JTextField textField;
	
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
					ViewMembers frame = new ViewMembers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	public ViewMembers() {
		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 553);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(MemberScreen.class.getResource("/images/header.png")));
		lblHeader.setBounds(0, 0, 404, 60);
		contentPane.add(lblHeader);
		
		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBackground(new Color(65, 105, 225));
		pnlSeparator.setBounds(0, 60, 394, 19);
		contentPane.add(pnlSeparator);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(294, 491, 89, 23);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(10, 90, 278, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(294, 90, 89, 23);
		contentPane.add(btnSearch);
		
		JList list = new JList();
		list.setBounds(98, 365, 201, -177);
		contentPane.add(list);
	}
}
