package ie.lyit.library;

import java.awt.Color;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.UIManager;

import javax.swing.border.EmptyBorder;

import javax.swing.JTable;

import java.awt.Font;

import java.awt.SystemColor;

public class OverdueLoans extends JFrame {

	private JPanel contentPane;

	private JTable table;

	/**
	 * 
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

	/**
	 * 
	 * Create the frame.
	 */

	public OverdueLoans() {

		setResizable(false);

		setTitle("Library");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 459, 460);

		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("");

		lblHeader.setIcon(new ImageIcon(MainScreen.class
				.getResource("/images/header.png")));

		lblHeader.setBounds(0, 0, 453, 60);

		contentPane.add(lblHeader);

		JPanel pnlSeparator = new JPanel();

		pnlSeparator.setBackground(new Color(65, 105, 225));

		pnlSeparator.setBounds(0, 60, 453, 19);

		contentPane.add(pnlSeparator);

		JPanel pnlHeader = new JPanel();

		pnlHeader.setBounds(0, 0, 394, 80);

		contentPane.add(pnlHeader);

		JButton btnNotify = new JButton("Send Notification");

		btnNotify.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showInputDialog("Loan Renewed.");

			}

		});

		btnNotify.setBounds(231, 353, 163, 29);

		contentPane.add(btnNotify);

		table = new JTable();

		table.setBackground(Color.LIGHT_GRAY);

		table.setBounds(52, 148, 342, 181);

		contentPane.add(table);

		JButton btnBack = new JButton("Back");

		btnBack.setBounds(52, 355, 163, 26);

		contentPane.add(btnBack);

	}

}