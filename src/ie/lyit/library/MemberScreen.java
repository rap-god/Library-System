package ie.lyit.library;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberScreen extends JFrame {
	public MemberScreen() {
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
		lblHeader.setBounds(0, 0, 404, 60);
		lblHeader.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/header.png")));
		contentPane.add(lblHeader);
		
		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBounds(0, 60, 394, 19);
		pnlSeparator.setBackground(new Color(65, 105, 225));
		contentPane.add(pnlSeparator);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);
		
		JTextField lblSearch = new JTextField();
		lblSearch.setBounds(29, 90, 243, 23);
		contentPane.add(lblSearch);
		lblSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(282, 90, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(29, 124, 130, 29);
		contentPane.add(btnBrowse);
		
		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccount window = new MyAccount();
				window.setVisible(true);
				dispose();
			}
		});
		btnMyAccount.setBounds(241, 124, 130, 29);
		contentPane.add(btnMyAccount);
		
		JPanel bookPanel = new JPanel();
		bookPanel.setBounds(29, 164, 342, 311);
		contentPane.add(bookPanel);

		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBounds(29, 486, 130, 29);
		contentPane.add(btnReturnBook);
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.setBounds(241, 489, 130, 29);
		contentPane.add(btnBorrowBook);

	}
}
