package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JList;
import javax.swing.border.LineBorder;

public class MyAccount extends JFrame{

	private JPanel contentPane;
	
	
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
					MyAccount frame = new MyAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		

	}
	public MyAccount(){
		
		setTitle(Member.getCurrentMember().getMemberID() +"'s account.");
		Database data = new Database();
		setResizable(false);
		setTitle("My Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 553);
		contentPane = new JPanel();
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
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "Leave This Page?", "Confirmation", JOptionPane.YES_NO_OPTION);
    			  if(n ==JOptionPane.YES_OPTION){
				    Member.logOut();
				    try {
				    	MainScreen frame = new MainScreen();
	    				frame.setVisible(true);
	    				dispose();  
				    }
				    
				    catch (SQLException e) {
				    	e.printStackTrace();
				    }
    				  				
    			  }
			}
        });
        btnLogout.setBounds(10, 92, 373, 29);
        contentPane.add(btnLogout);
        
        JList lstCurrentLoans = new JList(data.getLoans(Member.getCurrentMember().getMemberID()).toArray());
        lstCurrentLoans.setBorder(new LineBorder(new Color(0, 0, 0)));
        lstCurrentLoans.setBounds(10, 132, 373, 295);
        contentPane.add(lstCurrentLoans);					
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        });
        btnHome.setBounds(10, 454, 178, 29);
        contentPane.add(btnHome);
        
        JButton btnReturnBook = new JButton("Return Book");
        btnReturnBook.setBounds(205, 454, 178, 29);
        contentPane.add(btnReturnBook);
	}
}

 
