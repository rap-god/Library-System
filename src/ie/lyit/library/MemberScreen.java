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

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.JTable;
import javax.swing.JComboBox;

/**
 * The first window seen by the user after launching the application.
 * @author Sean Morris - l00095752
 *
 */
public class MemberScreen extends JFrame {

	private JPanel contentPane;
	// Constant to indicate there are 3 houses
	private final int NUM_OF_PICS = 3;
	private JTextField txtFFN;
	private JTextField txtFLN;
	private JTextField txtFEM;
	private JTextField txtFREM;
	private JTextField txtFNPass;
	private JTextField txtFRPass;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
					MemberScreen frame = new MemberScreen();
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
	public MemberScreen() {
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
		
		JButton lblRegister = new JButton("Register");
		lblRegister.setBounds(12, 488, 373, 29);
		contentPane.add(lblRegister);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(46, 90, 86, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(46, 118, 86, 15);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel = new JLabel("Your E-mail:");
		lblNewLabel.setBounds(46, 158, 86, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Re-Enter E-Mail:");
		lblNewLabel_1.setBounds(46, 184, 125, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(46, 211, 113, 15);
		contentPane.add(lblNewPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password:");
		lblReenterPassword.setBounds(46, 240, 102, 17);
		contentPane.add(lblReenterPassword);
		
		txtFFN = new JTextField();
		txtFFN.setBounds(205, 90, 143, 19);
		contentPane.add(txtFFN);
		txtFFN.setColumns(10);
		
		txtFLN = new JTextField();
		txtFLN.setBounds(205, 117, 143, 19);
		contentPane.add(txtFLN);
		txtFLN.setColumns(10);
		
		txtFEM = new JTextField();
		txtFEM.setBounds(205, 155, 143, 19);
		contentPane.add(txtFEM);
		txtFEM.setColumns(10);
		
		txtFREM = new JTextField();
		txtFREM.setBounds(205, 182, 143, 19);
		contentPane.add(txtFREM);
		txtFREM.setColumns(10);
		
		txtFNPass = new JTextField();
		txtFNPass.setBounds(205, 209, 143, 19);
		contentPane.add(txtFNPass);
		txtFNPass.setColumns(10);
		
		txtFRPass = new JTextField();
		txtFRPass.setBounds(205, 238, 143, 19);
		contentPane.add(txtFRPass);
		txtFRPass.setColumns(10);
		
		table = new JTable();
		table.setBounds(104, 304, 1, 1);
		contentPane.add(table);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(46, 278, 70, 15);
		contentPane.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(205, 270, 143, 24);
		contentPane.add(comboBox);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(46, 316, 70, 15);
		contentPane.add(lblBirthday);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(204, 311, 42, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(258, 311, 42, 24);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(306, 311, 42, 24);
		contentPane.add(comboBox_3);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(46, 357, 70, 15);
		contentPane.add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(205, 354, 143, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 385, 143, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 413, 143, 19);
		contentPane.add(textField_2);
	}
}
