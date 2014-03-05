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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class OverdueLoans extends JFrame{
	
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
					OverdueLoans frame = new OverdueLoans();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public OverdueLoans() {
		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton btnSendNotification = new JButton("Send Notification");
		btnSendNotification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSendNotification.setBounds(123, 487, 156, 25);
		contentPane.add(btnSendNotification);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(79, 141, 129, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
