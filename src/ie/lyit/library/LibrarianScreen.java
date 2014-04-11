package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTable;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class LibrarianScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldTitle;
	private JTextField txtFldAuthor;
	private JTextField txtFldGenre;
	private JTextField txtFldPublisher;
	private JTextField txtFldYear;
	private JTextField txtFldImage;
	private JTextField txtISBN;
	final JFileChooser fc = new JFileChooser();
	private String test;
	private JTextField txtImg;
	private JTable table;
	private JTextField textField;
	private int row = 0;
	private JTextField txtSearch;
	private JTextArea txtFldDesc;
	private JComboBox box;
	private String genre;

	/**
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
					LibrarianScreen frame = new LibrarianScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public LibrarianScreen() throws SQLException {

		@SuppressWarnings("serial")
		final DefaultTableModel model = new DefaultTableModel() {

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		final DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 639);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(LibrarianScreen.class
				.getResource("/images/header.png")));
		lblHeader.setBounds(201, 0, 463, 60);
		contentPane.add(lblHeader);

		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBackground(new Color(65, 105, 225));
		pnlSeparator.setBounds(0, 60, 789, 19);
		contentPane.add(pnlSeparator);

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);

		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setBounds(20, 185, 68, 24);
		contentPane.add(lblTitle);

		JLabel lblAuthor = new JLabel("Author : ");
		lblAuthor.setBounds(20, 229, 68, 19);
		contentPane.add(lblAuthor);

		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(20, 282, 68, 23);
		contentPane.add(lblGenre);

		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setBounds(20, 328, 68, 23);
		contentPane.add(lblPublisher);

		JLabel lblYear = new JLabel("Year :");
		lblYear.setBounds(20, 376, 68, 24);
		contentPane.add(lblYear);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(22, 440, 80, 24);
		contentPane.add(lblDescription);

		JLabel lblImage = new JLabel("Image :");
		lblImage.setBounds(20, 500, 68, 17);
		contentPane.add(lblImage);

		txtFldTitle = new JTextField();
		txtFldTitle.setBounds(143, 176, 206, 33);
		contentPane.add(txtFldTitle);
		txtFldTitle.setColumns(10);

		txtFldAuthor = new JTextField();
		txtFldAuthor.setBounds(143, 220, 206, 33);
		contentPane.add(txtFldAuthor);
		txtFldAuthor.setColumns(10);

		txtFldGenre = new JTextField();
		txtFldGenre.setBounds(143, 273, 206, 33);
		contentPane.add(txtFldGenre);
		txtFldGenre.setColumns(10);

		txtFldPublisher = new JTextField();
		txtFldPublisher.setBounds(143, 328, 206, 33);
		contentPane.add(txtFldPublisher);
		txtFldPublisher.setColumns(10);

		txtFldYear = new JTextField();
		txtFldYear.setBounds(143, 372, 206, 33);
		contentPane.add(txtFldYear);
		txtFldYear.setColumns(10);

		JButton btnViewMemberDetails = new JButton("View Member Details");
		btnViewMemberDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMembers frame = new ViewMembers();
				frame.setVisible(true);
				dispose();
			}
		});
		btnViewMemberDetails.setBounds(10, 88, 166, 33);
		contentPane.add(btnViewMemberDetails);

		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.setBounds(588, 567, 181, 33);
		contentPane.add(btnRemoveBook);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(20, 567, 329, 33);
		contentPane.add(btnAddBook);

		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database data = new Database();
				// local variables
				int isbn = 0;
				try {
					if (txtFldTitle.getText().equals("")
							|| txtFldDesc.getText().equals("")
							|| txtISBN.getText().equals("")
							|| txtFldAuthor.getText().equals("")
							|| txtFldGenre.getText().equals("")) {
						throw new IllegalArgumentException(
								"All fields must contain correct data!");
					}

					isbn = Integer.parseInt(txtISBN.getText());
					// add book to the database
					data.addBook(isbn, txtFldAuthor.getText(),
							txtFldTitle.getText(), txtFldYear.getText(),
							txtFldDesc.getText(), txtFldPublisher.getText(),
							txtFldGenre.getText(), txtImg.getText());

					resetTextFields();
					model.fireTableDataChanged();
					model.setRowCount(0);
					data.populateTable(model);
					boxModel.removeAllElements();
					data.populateComboBox(boxModel);
				}

				catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				catch (Exception x) {
					JOptionPane.showMessageDialog(null,
							"Fields Must Contain Correct Data");

					x.printStackTrace();
				}
			}
		});

		// **************************************************************************************************//
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database data = new Database();
				if (table.getSelectedRow() > -1) {
					row = table.getSelectedRow();
					int col = 0;
					Object isbn = table.getValueAt(row, col);
					int isbn2 = (Integer) isbn;
					int n;
					try {
						n = JOptionPane.showConfirmDialog(null,
								"Removing Book: "
										+ data.getBookByISBN(isbn2).getTitle(),
								"Confirmation", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							data.removeBook(isbn2);
							model.fireTableDataChanged();
							model.setRowCount(0);
							data.populateTable(model);
						}
					} catch (HeadlessException | SQLException x) {
						x.printStackTrace();
					}
				}
			}
		});
		// ***************************************************REMOVE
		// END**********************************************//

		JButton btnFile = new JButton("Open File");
		btnFile.setBounds(143, 500, 100, 33);
		contentPane.add(btnFile);
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(LibrarianScreen.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					txtImg.setText(fc.getSelectedFile().getName());
				}
			}
		});

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(20, 139, 68, 20);
		contentPane.add(lblIsbn);

		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(143, 132, 206, 33);
		contentPane.add(txtISBN);

		txtImg = new JTextField();
		txtImg.setColumns(10);
		txtImg.setBounds(253, 500, 100, 33);
		contentPane.add(txtImg);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(395, 143, 374, 390);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		txtSearch = new JTextField();
		txtSearch.setBounds(395, 89, 275, 33);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(680, 88, 89, 33);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Database test = new Database();
				model.setRowCount(0);

				try {
					test.searchBooks(txtSearch.getText(), model);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (txtSearch.getText().equals("")) {
					try {
						model.setRowCount(0);
						test.populateTable(model);
					} catch (SQLException e1) {
						e1.printStackTrace();

					}
					JOptionPane.showMessageDialog(null, "Please Enter Value");

				}
			}
		});

		Database test = new Database();
		model.addColumn("ISBN");
		model.addColumn("Author");
		model.addColumn("Title");
		model.addColumn("Quantity");
		try {
			test.populateTable(model);

		} catch (Exception e) {

		}
		table = new JTable(model);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(143, 416, 206, 68);
		contentPane.add(scrollPane_1);

		txtFldDesc = new JTextArea();
		txtFldDesc.setLineWrap(true);
		scrollPane_1.setViewportView(txtFldDesc);

		Database haha = new Database();
		haha.populateComboBox(boxModel);
		box = new JComboBox(boxModel);
		box.setBounds(201, 90, 148, 31);
		contentPane.add(box);

		JButton btnViewOverdueLoans = new JButton("View Overdue Loans");
		btnViewOverdueLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OverdueLoans overdueLoans = new OverdueLoans();
					overdueLoans.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnViewOverdueLoans.setBounds(395, 567, 181, 33);
		contentPane.add(btnViewOverdueLoans);

		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (box.getSelectedIndex() > -1) {
					genre = box.getSelectedItem().toString();
					Database test = new Database();
					model.setRowCount(0);
					if (box.getSelectedItem().equals("-All books-")) {

						try {
							model.setRowCount(0);
							test.populateTable(model);
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

					}// end if
					else {

						try {
							test.searchByGenre(genre, model);

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}// end else
				}
			}
		});

		// ***************************************************** COMBO BOX
		// ACTION LISTENER END *******************************************//
	}

	// Public method to reset JTextField's
	public void resetTextFields() {
		txtFldTitle.setText("");
		txtFldAuthor.setText("");
		txtFldGenre.setText("");
		txtFldPublisher.setText("");
		txtFldYear.setText("");
		txtFldDesc.setText("");
		txtImg.setText("");
		txtISBN.setText("");
	}
}
