package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * Opens the ViewMembers frame. Allows the admin to view and/or remove users
 * from the system.
 */
public class ViewMembers extends JFrame {

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
					ViewMembers frame = new ViewMembers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ViewMembers Constructor.
	 */
	public ViewMembers() {
		final Database data = new Database();
		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 575);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(ViewMembers.class
				.getResource("/images/header.png")));
		lblHeader.setBounds(0, 0, 394, 60);
		contentPane.add(lblHeader);

		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBackground(new Color(65, 105, 225));
		pnlSeparator.setBounds(0, 60, 394, 19);
		contentPane.add(pnlSeparator);

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibrarianScreen frame = new LibrarianScreen();
					frame.setVisible(true);
					dispose();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnBack.setBounds(10, 502, 373, 34);
		contentPane.add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 373, 359);
		contentPane.add(scrollPane);

		final JList lstMembers = new JList(data.getMembers().toArray());
		scrollPane.setViewportView(lstMembers);

		JButton btnRemoveMember = new JButton("Remove");
		btnRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String selectedMember = (String) lstMembers
							.getSelectedValue();
					if (data.isLibrarian(selectedMember)) {
						throw new IllegalArgumentException(
								"Cannot delete the admininstrator!");
					}

					data.removeUser(selectedMember);
					ViewMembers frame = new ViewMembers();
					JOptionPane.showMessageDialog(null, "User: "
							+ selectedMember
							+ " has been removed from the system.");
					dispose();
					frame.setVisible(true);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRemoveMember.setBounds(10, 87, 373, 34);
		contentPane.add(btnRemoveMember);
	}
}
