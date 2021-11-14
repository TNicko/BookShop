import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Panel2 extends JPanel implements ActionListener{
	
	static JTextField searchField;
	JPanel middlePanel;
	JButton cartBtn;
	JTable bookTable;
	String[][] bookArray;
	static JComboBox genreFilterBox;
	static TableRowSorter<DefaultTableModel> sorter;
	JButton searchBtn;
	JButton adminAddBookBtn;
	
	private int hoveredRow = -1, hoveredColumn = -1;
	
	Panel2() throws FileNotFoundException{
		
		// ------------ TOP PANEL ------------
		JLabel topLabel = new JLabel();
		topLabel.setText("Book Search: ");
		
		searchField = new JTextField(20);
		
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(this);
		
		ImageIcon cartImg = new ImageIcon("shoppingBasket.png");
		Image scaleImg = cartImg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		cartImg = new ImageIcon(scaleImg);
		
		cartBtn = new JButton();
		cartBtn.setText("Your Basket");
		cartBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		cartBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		cartBtn.setIcon(cartImg);
		cartBtn.setIconTextGap(-10);
		cartBtn.setFont(new Font("Comic Sans",Font.BOLD,9));
		cartBtn.setIconTextGap(-5);
		cartBtn.setBackground(Color.LIGHT_GRAY);
		
		adminAddBookBtn = new JButton();
		adminAddBookBtn.setText("Add Book");
		adminAddBookBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		adminAddBookBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		adminAddBookBtn.setFont(new Font("Comic Sans",Font.BOLD,11));
		adminAddBookBtn.setBackground(Color.LIGHT_GRAY);
		adminAddBookBtn.setVisible(false);
		
		JLabel gap = new JLabel();
		gap.setText("                                        ");
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.LIGHT_GRAY);
		topPanel.setLayout(new FlowLayout());
		topPanel.add(topLabel);
		topPanel.add(searchField);
		topPanel.add(searchBtn);
		topPanel.add(gap);
		topPanel.add(cartBtn);
		topPanel.add(adminAddBookBtn);
		// ------------ MIDDLE PANEL : Filter Panel ------------
		
		JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		filterPanel.setBackground(Color.DARK_GRAY);
		JLabel books = new JLabel();
		books.setText("Filters ");
		books.setFont(new Font("Comic Sans",Font.BOLD,15));
		books.setForeground(Color.white);
		
		String[] genreFilters = {"All Books","Politics","Medicine","Business","Computer Science","Biogrophy"};
		genreFilterBox = new JComboBox(genreFilters);
		genreFilterBox.addActionListener(this);
        filterPanel.add(books);
        filterPanel.add(genreFilterBox);
		
		// ------------ MIDDLE PANEL : Book Table List ------------
		
		BufferedReader reader = new BufferedReader(new FileReader("Stock.txt"));
		int lines = 0;
		try {
			while (reader.readLine() != null) { lines++; }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileReader bookData = new FileReader("Stock.txt");
		Scanner bookScanner = new Scanner(bookData);
		bookArray = new String[lines][];
		int arrayIndex = 0;
		while (bookScanner.hasNextLine()) {
			String[] bookInfo = bookScanner.nextLine().split(", ");
			bookArray[arrayIndex] = bookInfo;
			arrayIndex++;
		}
		bookScanner.close();
		
		String[] headers = {"ISBN","Type","Title","Language","Genre","Date","Price","Quantity","Info1","Info2"};
		DefaultTableModel dm = new DefaultTableModel(bookArray, headers);
		sorter = new TableRowSorter<DefaultTableModel>(dm);
		bookTable = new JTable(dm);
		bookTable.setRowSorter(sorter);
		bookTable.addMouseMotionListener(new MouseMotionListener() {
	        @Override
	        public void mouseMoved(MouseEvent e) {
	            Point p = e.getPoint();
	            hoveredRow = bookTable.rowAtPoint(p);
	            hoveredColumn = bookTable.columnAtPoint(p);
	            bookTable.setRowSelectionInterval(hoveredRow, hoveredRow);
	            bookTable.repaint();    
	        }
	        @Override
	        public void mouseDragged(MouseEvent e) {
	            hoveredRow = hoveredColumn = -1;
	            bookTable.repaint();
	        }
	    });

		
		// ------------ MIDDLE PANEL : Adding Book to Basket  ------------
		
		
		
        middlePanel = new JPanel();
		middlePanel.setBackground(Color.DARK_GRAY);
		middlePanel.setLayout(new BorderLayout());
        middlePanel.add(new JScrollPane(bookTable));
        middlePanel.add(filterPanel, BorderLayout.NORTH);
		this.setSize(1000,700);
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(middlePanel,BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==searchBtn) {
			
			BookSearch.newSearch();
		}
		if (e.getSource()==genreFilterBox) {
			BookSearch.newFilter();
		}
	}
}


