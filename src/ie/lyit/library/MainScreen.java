package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
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
			
				setResizable(false);
				setTitle("Library - Home");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 678, 530);
				JPanel contentPane = new JPanel();
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblHeader = new JLabel("");
				lblHeader.setIcon(new ImageIcon(HomeWindow.class.getResource("/images/header.png")));
				lblHeader.setBounds(135, 0, 453, 60);
				contentPane.add(lblHeader);
				
				JPanel pnlSeparator = new JPanel();
				pnlSeparator.setBackground(new Color(65, 105, 225));
				pnlSeparator.setBounds(0, 60, 672, 19);
				contentPane.add(pnlSeparator);
				
				JButton btnLoginRegister = new JButton("Login / Register");
				btnLoginRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							Login loginScreen = new Login();
							loginScreen.setVisible(true);
							dispose();
						}
				});
				btnLoginRegister.setBounds(20, 89, 280, 27);
				contentPane.add(btnLoginRegister);
				
				txtSearch = new JTextField();
				txtSearch.setBounds(342, 90, 200, 26);
				contentPane.add(txtSearch);
				txtSearch.setColumns(10);
				
				JButton btnSearch = new JButton("Search");
				btnSearch.setBounds(563, 89, 99, 27);
				contentPane.add(btnSearch);
				
				//*************************Search Button****************************************//
				btnSearch.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Database test = new Database();
						model.setRowCount(0);
						//String value = txtSearch.toString();
						
							try {	
								test.searchBooks(txtSearch.getText(), model);
							}
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(txtSearch.getText().equals("")){
								try {
									model.setRowCount(0);
									test.populateTable(model);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "Please Enter Value");
							}
					}
				});

				//**********************Search End***********************************************//
				
				final Database data = new Database();
				
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
				
				btnBorrow.setBounds(342, 467, 320, 26);
				contentPane.add(btnBorrow);
				
				final JPanel jplMainPanel = new JPanel();
				jplMainPanel.setBounds(20, 127, 280, 329);
				contentPane.add(jplMainPanel);
				jplMainPanel.setLayout(c1);
				
				JLabel lblImage = new JLabel("");
				lblImage.setIcon(new ImageIcon(MainScreen.class.getResource("/images/placeholder.jpg")));
				jplMainPanel.add(lblImage, "name_1196884078311");
				
				JPanel jplDetailsPanel = new JPanel();
				jplDetailsPanel.setBackground(Color.WHITE);
				jplMainPanel.add(jplDetailsPanel, "name_1373888375022");
				jplDetailsPanel.setLayout(null);
				
				final JLabel lblSmallImage = new JLabel("");
				lblSmallImage.setBounds(166, 0, 114, 91);
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
				txtDescription.setBounds(0, 102, 280, 216);
				txtDescription.setLineWrap(true);
				txtDescription.setWrapStyleWord(true);
				jplDetailsPanel.add(txtDescription); 
				
				//*******************************************************JTable CODE*****************************************************//
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(342, 127, 320, 329);
				contentPane.add(scrollPane);
				Database test = new Database();
				
			    //Create Model and set cellEditable to false
				
				
				model.addColumn("ISBN");
				model.addColumn("Author");
				model.addColumn("Title");
				model.addColumn("Quantity");
				try{
					test.populateTable(model);
					
				}
				catch(Exception e){
					
				}
				
				
				table = new JTable(model);
				table.setModel(model);
				
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
				
				if (Member.loggedOn) {
					JButton btnMyAccount = new JButton("My Account");
					btnMyAccount.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) { 
							MyAccount frame = new MyAccount();
							frame.setVisible(true);
							dispose();
						}
					});
					btnMyAccount.setBounds(20, 467, 280, 27);
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
							} catch (SQLException e) {		
								e.printStackTrace();
							}
							
							BufferedImage img = null;

							try {
								img = ImageIO.read(ClassLoader.getSystemResource("images/"+data.getImage(isbn2)));
							}
							
							catch (IOException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							Image scaledImage = img.getScaledInstance(lblSmallImage.getWidth(), lblSmallImage.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon icon = new ImageIcon(scaledImage);
							lblSmallImage.setIcon(icon); 
							}
						}
						
				});
				
					
				//*********************************************END*************************************************************//
				
			}//end main
}//end class
