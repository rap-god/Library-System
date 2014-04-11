package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class MainScreen extends JFrame{
	private JTextField txtSearch;
	private JTable table;
	private int row = 0;
	private JComboBox box;
	private String genre;
	Book selectedBook;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
					    JOptionPane.showMessageDialog(null,"Cannot set look and feel!");
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
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public MainScreen() throws SQLException {
			
				final CardLayout c1 = new CardLayout(0,0);
				final DefaultTableModel model = new DefaultTableModel(){
					
					 public boolean isCellEditable(int row, int column){
						 return false;
					 }      
					};
					DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			
				setResizable(false);
				setTitle("Library");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 759, 534);
				JPanel contentPane = new JPanel();
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblHeader = new JLabel("");
				lblHeader.setIcon(new ImageIcon(MainScreen.class.getResource("/images/header.png")));
				lblHeader.setBounds(165, 0, 453, 60);
				contentPane.add(lblHeader);
				
				JPanel pnlSeparator = new JPanel();
				pnlSeparator.setBackground(new Color(65, 105, 225));
				pnlSeparator.setBounds(0, 60, 753, 19);
				contentPane.add(pnlSeparator);
				
				if(!Member.loggedOn) {
					JButton btnLoginRegister = new JButton("Login / Register");
					btnLoginRegister.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
								Login loginScreen = new Login();
								loginScreen.setVisible(true);
								dispose();
							}
					});
					btnLoginRegister.setBounds(20, 89, 124, 31);
					contentPane.add(btnLoginRegister);
				}
				
				else {
					setTitle(Member.getCurrentMember().getMemberID() +"'s Library");
				}
				
				txtSearch = new JTextField();
				txtSearch.setBounds(372, 90, 272, 30);
				contentPane.add(txtSearch);
				txtSearch.setColumns(10);
				
				Database haha = new Database();
				haha.populateComboBox(boxModel);
				
				box = new JComboBox(boxModel);
				box.setBounds(150, 90, 190, 30);
				contentPane.add(box);
				
				//******************************************************COMBO BOX ACTION LISTENER************************************************************//
				
				box.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent e) {
				genre = box.getSelectedItem().toString();
				Database test = new Database();
				model.setRowCount(0);	
				if(box.getSelectedItem().equals("-All books-")){
					
					
					try {
						model.setRowCount(0);
						test.populateTable(model);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
				}//end if	
				else{	
					try {	
						test.searchByGenre(genre, model);
							
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}//end else		
				}
				});
				
				//***************************************************** COMBO BOX ACTION LISTENER END *******************************************//
				//******************************************************SEARCH BUTTON************************************************************//
				JButton btnSearch = new JButton("Search");
				btnSearch.setBounds(654, 90, 89, 31);
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
								e1.printStackTrace();
							}
						}
						else{
							try {
								test.detailedSearch(genre, model, txtSearch.getText());
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					
							if(txtSearch.getText().equals("")){
								try {
									model.setRowCount(0);
									test.populateTable(model);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}	
							}	
					}
				});

				//******************************************************SEARCH BUTTON END************************************************************//
				
				final Database data = new Database();
				Book b = new Book();
				try {
					b = data.getBookByTitle("Grapes of Wrath");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

					JButton btnBorrow = new JButton("Borrow");
					btnBorrow.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (Member.loggedOn) {
								Loan l;
								data.createLoan(l = new Loan(Member.getCurrentMember().getMemberID(), selectedBook.getISBN()));
								JOptionPane.showMessageDialog(null, "Loan taken out on: " +selectedBook.getTitle());
								System.out.println(l.getLoanDate());
							}

							else {
								JOptionPane.showMessageDialog(null, "You must be logged in to perform this operation!");
							}
						}
					});
					btnBorrow.setBounds(372, 466, 371, 35);
					contentPane.add(btnBorrow);
					
					final JPanel jplMainPanel = new JPanel();
					jplMainPanel.setBounds(20, 127, 280, 329);
					contentPane.add(jplMainPanel);
					jplMainPanel.setLayout(c1);
					
					JLabel lblImage = new JLabel("");
					lblImage.setIcon(new ImageIcon(MainScreen.class.getResource("/images/books_logo.jpg")));
					jplMainPanel.add(lblImage, "name_1196884078311");
					
					JPanel jplDetailsPanel = new JPanel();
					jplDetailsPanel.setBackground(Color.WHITE);
					jplMainPanel.add(jplDetailsPanel, "name_1373888375022");
					jplDetailsPanel.setLayout(null);
					
					final JLabel lblSmallImage = new JLabel("");
					lblSmallImage.setBounds(166, 0, 114, 108);
					jplDetailsPanel.add(lblSmallImage);
					
					final JLabel lblTitle = new JLabel("");
					lblTitle.setBounds(0, 0, 156, 23);
					jplDetailsPanel.add(lblTitle);
					
					final JLabel lblAuthor = new JLabel("");
					lblAuthor.setBounds(0, 34, 156, 23);
					jplDetailsPanel.add(lblAuthor);
					
					final JLabel lblPublisher = new JLabel("");
					lblPublisher.setBounds(0, 68, 156, 23);
					jplDetailsPanel.add(lblPublisher);
					
					final JTextArea txtDescription = new JTextArea();
					txtDescription.setEditable(false);
					txtDescription.setBounds(10, 119, 270, 199);
					jplDetailsPanel.add(txtDescription);
					
					
					//******************************************************JTABLE CODE************************************************************//
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(372, 132, 371, 324);
					contentPane.add(scrollPane);
					Database test = new Database();
					
					model.addColumn("ISBN");
					model.addColumn("Author");
					model.addColumn("Title");
					model.addColumn("Genre");
					try{
						test.populateTable(model);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					table = new JTable(model);
					table.setModel(model);
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					
					
					
					if(Member.loggedOn) {
						JButton btnMyAccount = new JButton("My Account");
						btnMyAccount.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) { 
								MyAccount frame = new MyAccount();
								frame.setVisible(true);
								dispose();
							}
						});
						btnMyAccount.setBounds(20, 466, 280, 35);
						contentPane.add(btnMyAccount);
					}
					
					
					table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
					{
						Database test = new Database();
						public void valueChanged(ListSelectionEvent arg0){
							
							if(table.getSelectedRow()> -1){
								row = table.getSelectedRow();
								int col=0;
								Object isbn = table.getValueAt(row, col);
								int isbn2 = (Integer) isbn;
								try {
									selectedBook = test.getBookByISBN(isbn2);
									c1.last(jplMainPanel);
									lblTitle.setText(selectedBook.getTitle());
									lblAuthor.setText(selectedBook.getAuthor());
									lblPublisher.setText(selectedBook.getPublisher());
									txtDescription.setText(selectedBook.getDescription());
									txtDescription.setLineWrap(true);
									txtDescription.setWrapStyleWord(true);
									BufferedImage img = null;

									try {
										img = ImageIO.read(ClassLoader.getSystemResource("images/"+data.getImage(isbn2)));
									}
									
									catch (IOException e) {
										e.printStackTrace();
									}
									
									Image scaledImage = img.getScaledInstance(lblSmallImage.getWidth(), lblSmallImage.getHeight(), Image.SCALE_SMOOTH);
									ImageIcon icon = new ImageIcon(scaledImage);
									lblSmallImage.setIcon(icon); 
									
								} catch (SQLException e) {
									e.printStackTrace();
								}
								catch(NullPointerException e1) {

								}
							}
						}
					});
					
						
					//******************************************************JTABLE CODE END************************************************************//
					
				}//end main
}//end class
