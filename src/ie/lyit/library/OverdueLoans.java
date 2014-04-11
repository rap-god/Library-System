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
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;

import java.awt.Font;

import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JScrollPane;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class OverdueLoans extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int row;

	/**
	 * 
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Set system look and feel ...
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
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

	/**
	 * 
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ParseException
	 */

	public OverdueLoans() throws ParseException, SQLException {
		@SuppressWarnings("serial")
		final DefaultTableModel model = new DefaultTableModel() {

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 563);
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
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 498, 163, 26);
		contentPane.add(btnBack);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 432, 390);
		contentPane.add(scrollPane);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		model.addColumn("Loan ID");
		model.addColumn("Member ID");
		model.addColumn("Due Date");
		model.addColumn("ISBN");
		Database data = new Database();
		model.setRowCount(0);
		data.viewOverDueLoans(model);
		if(model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "No Overdue Loans found on system!");
		}
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibrarianScreen librarianWindow = new LibrarianScreen();
					librarianWindow.setVisible(true);
					dispose();
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnSend = new JButton("Send Notification");
		btnSend.setBounds(250, 498, 163, 26);
		contentPane.add(btnSend);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() > -1) {
					row = table.getSelectedRow();
					int col = 1;
					Object name = table.getValueAt(row, col);
					String member = (String) name;
					JOptionPane
							.showMessageDialog(null,
									"Notification has been sent to the user: "
											+ member);
				}
			}
		});

	}
}