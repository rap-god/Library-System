package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.JComboBox;

public class LibrarianScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldTitle;
	private JTextField txtFldAuthor;
	private JTextField txtFldGenre;
	private JTextField txtFldPublisher;
	private JTextField txtFldYear;
	private JTextField txtFldDesc;
	private JTextField txtFldImage;
	private JTextField txtISBN;
	private JTextField txtQuantity;
	final JFileChooser fc = new JFileChooser();
	private String test;
	private JTextField txtImg;
	private JTable table;
	private JTextField textField;
	private int row = 0;
	private JTextField txtSearch;
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

	@SuppressWarnings("unchecked")
	public LibrarianScreen() throws SQLException {
		
		@SuppressWarnings("serial")
		final DefaultTableModel model = new DefaultTableModel(){
			
			 public boolean isCellEditable(int row, int column){
				 return false;
			 }
			      
			};
		final DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		setResizable(false);
		setTitle("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(HomeWindow.class
				.getResource("/images/header.png")));
		lblHeader.setBounds(0, 0, 796, 60);
		contentPane.add(lblHeader);

		JPanel pnlSeparator = new JPanel();
		pnlSeparator.setBackground(new Color(65, 105, 225));
		pnlSeparator.setBounds(0, 60, 796, 19);
		contentPane.add(pnlSeparator);

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 394, 80);
		contentPane.add(pnlHeader);

		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setBounds(47, 146, 46, 14);
		contentPane.add(lblTitle);

		JLabel lblAuthor = new JLabel("Author : ");
		lblAuthor.setBounds(47, 171, 46, 14);
		contentPane.add(lblAuthor);

		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(47, 196, 46, 14);
		contentPane.add(lblGenre);

		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setBounds(47, 221, 68, 14);
		contentPane.add(lblPublisher);

		JLabel lblYear = new JLabel("Year :");
		lblYear.setBounds(47, 246, 46, 14);
		contentPane.add(lblYear);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(47, 271, 68, 14);
		contentPane.add(lblDescription);

		JLabel lblImage = new JLabel("Image :");
		lblImage.setBounds(47, 382, 46, 14);
		contentPane.add(lblImage);

		txtFldTitle = new JTextField();
		txtFldTitle.setBounds(137, 143, 206, 20);
		contentPane.add(txtFldTitle);
		txtFldTitle.setColumns(10);

		txtFldAuthor = new JTextField();
		txtFldAuthor.setBounds(137, 168, 206, 20);
		contentPane.add(txtFldAuthor);
		txtFldAuthor.setColumns(10);

		txtFldGenre = new JTextField();
		txtFldGenre.setBounds(137, 193, 206, 20);
		contentPane.add(txtFldGenre);
		txtFldGenre.setColumns(10);

		txtFldPublisher = new JTextField();
		txtFldPublisher.setBounds(137, 218, 206, 20);
		contentPane.add(txtFldPublisher);
		txtFldPublisher.setColumns(10);

		txtFldYear = new JTextField();
		txtFldYear.setBounds(137, 243, 206, 20);
		contentPane.add(txtFldYear);
		txtFldYear.setColumns(10);

		txtFldDesc = new JTextField();
		txtFldDesc.setBounds(137, 268, 206, 100);
		contentPane.add(txtFldDesc);
		txtFldDesc.setColumns(10);
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.setBounds(627, 474, 133, 23);
		contentPane.add(btnRemoveBook);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(137, 450, 133, 23);
		contentPane.add(btnAddBook);

		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database data = new Database();
				
				//local variables
				int isbn = 0;
				int quantity = 0;
				try{
					//parse values from text fields
					isbn = Integer.parseInt(txtISBN.getText());
					quantity = Integer.parseInt(txtQuantity.getText());
						//add book to the database
						data.addBook(isbn, txtFldAuthor.getText(),
								txtFldTitle.getText(), txtFldYear.getText(),
								txtFldDesc.getText(),
								txtFldPublisher.getText(),
								txtFldGenre.getText(), txtImg.getText(), quantity);
						
						resetTextFields();
						model.fireTableDataChanged();
						model.setRowCount(0);
						data.populateTable(model);
						
						
						boxModel.removeAllElements();
						data.populateComboBox(boxModel);
						
						
						
						
						
						
				}
				catch (Exception x) {
					JOptionPane.showMessageDialog(null, "Fields Must Contain Correct Data");
					x.printStackTrace();
					
				}

			}
		});
		
		//**************************************************************************************************//
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
					Database data = new Database();
			
						if(table.getSelectedRow()> -1){
							row = table.getSelectedRow();
							int col=0;
							Object isbn = table.getValueAt(row, col);
							int isbn2 = (Integer) isbn;
							int n;
							try {
								n = JOptionPane.showConfirmDialog(null, "Removing Book: "+data.getBookByISBN(isbn2).getTitle(), "Confirmation", JOptionPane.YES_NO_OPTION);
								if(n ==JOptionPane.YES_OPTION){
									data.removeBook(isbn2);
									model.fireTableDataChanged();
									model.setRowCount(0);
									data.populateTable(model);
									boxModel.removeAllElements();
									data.populateComboBox(boxModel);
									
								}
							} 
							catch (HeadlessException | SQLException x) {
								// TODO Auto-generated catch block
								x.printStackTrace();
							}
							
				
					}
						
				
				}
		});
		//***************************************************REMOVE END**********************************************//

		JButton btnFile = new JButton("Open File");
		btnFile.setBounds(137, 379, 100, 20);
		contentPane.add(btnFile);
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				//Database data = new Database();
				
				int returnVal = fc.showOpenDialog(LibrarianScreen.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					txtImg.setText( fc.getSelectedFile().getName());
				}
			}
		});

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(47, 124, 46, 14);
		contentPane.add(lblIsbn);

		txtISBN = new JTextField(8);
		
		txtISBN.setBounds(137, 121, 206, 20);
		contentPane.add(txtISBN);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(47, 413, 46, 14);
		contentPane.add(lblQuantity);
		
		txtImg = new JTextField();
		txtImg.setColumns(10);
		txtImg.setBounds(240,379, 100, 20);
		contentPane.add(txtImg);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(137, 410, 206, 20);
		contentPane.add(txtQuantity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 145, 374, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(526, 103, 133, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(669, 102, 89, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Database test = new Database();
				model.setRowCount(0);
				genre = box.getSelectedItem().toString();
				if(genre.equals("-All books-")){
					try {	
						test.searchBooks(txtSearch.getText(), model);
							
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else{
					try {
						test.detailedSearch(genre, model, txtSearch.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
					if(txtSearch.getText().equals("")){
						try {
							model.setRowCount(0);
							test.populateTable(model);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
			}
		});
		
		Database test = new Database();
		model.addColumn("ISBN");
		model.addColumn("Author");
		model.addColumn("Title");
		model.addColumn("Genre");
		try{
			test.populateTable(model);
			
		}
		catch(Exception e){
			
		}
		
		
		table = new JTable(model);
		table.setModel(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		
		
		
		Database haha = new Database();
		haha.populateComboBox(boxModel);
		box = new JComboBox(boxModel);
		box.setBounds(386, 103, 118, 20);
		contentPane.add(box);
		
		//******************************************************COMBO BOX ACTION LISTENER************************************************************//
		
		box.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
		if(box.getSelectedIndex()>-1){
			genre = box.getSelectedItem().toString();
			Database test = new Database();
			model.setRowCount(0);	
			if(box.getSelectedItem().equals("-All books-")){
				
				
				try {
					model.setRowCount(0);
					test.populateTable(model);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}//end if	
			else{
				
					try {	
						test.searchByGenre(genre, model);
							
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}//end else	
		}
			
		}
		});
		
		//***************************************************** COMBO BOX ACTION LISTENER END *******************************************//
		

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
		txtQuantity.setText("");

	}
}
