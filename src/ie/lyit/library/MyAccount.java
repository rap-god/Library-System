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

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAccount extends JFrame{

	private JPanel contentPane;
	private JTable table;
	
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
			
			Button btnPayFine = new Button("Pay Fine");
			btnPayFine.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnPayFine.setBounds(62, 472, 130, 29);
			contentPane.add(btnPayFine);
			
			
			Button btnRenew = new Button("Renew Book");
			btnRenew.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnRenew.setBounds(215, 472, 130, 29);
			contentPane.add(btnRenew);
			
			Button btnLogout = new Button("Logout");
			btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnLogout.setBounds(215, 85, 130, 29);
			contentPane.add(btnLogout);
			
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int n = JOptionPane.showConfirmDialog(null, "Leave This Page?", "Confirmation", JOptionPane.YES_NO_OPTION);
	    			  if(n ==JOptionPane.YES_OPTION){
    				    Member.logOut();
	    				HomeWindow homePage = new HomeWindow();
	    				dispose();
	    				homePage.setVisible(true);
	    			  }
				}
			});
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 120, 338, 338);
			contentPane.add(scrollPane);
			
			
			//Create String array to hold column names
			String[] columnNames = {"ISBN",
                    "Author",
                    "Due Date",
                    "Fine",
                    "Renew"};
			//Create array to hold JTable data(data from database)
			Object[][] data = {
					{"Kathy", "Smith",
				     "Snowboarding", new Integer(5), new Boolean(false)},
				    
				};
				    
				
			table = new JTable(data,columnNames);
			scrollPane.setViewportView(table);
			
	
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
	        
		
	        //Add the scroll pane to this panel.
	        getContentPane().add(scrollPane);
			
	
	
		
	}
	
}

 
