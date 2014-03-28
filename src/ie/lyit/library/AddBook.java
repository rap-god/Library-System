package ie.lyit.library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

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


public class AddBook extends JFrame {
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
					AddBook frame = new AddBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}//end main

}//end class
