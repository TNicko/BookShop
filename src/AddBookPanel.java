import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddBookPanel extends JPanel implements ActionListener{
	
	JTextField isbnField;
	JTextField titleField;
	JTextField priceField;
	JTextField quantityField;
	JComboBox languageBox;
	JComboBox genreBox;
	JComboBox typeBox;
	JButton addBookBtn;
	JLabel pagesLabel; JTextField pagesField; 
	JLabel conditionLabel; JComboBox conditionBox; 
	JLabel ebookFormatLabel; JComboBox ebookFormatBox;
	JLabel audioLengthLabel; JTextField audioLengthField;
	JLabel audioFormatLabel; JComboBox audioFormatBox;
	JLabel isbnErrorLabel; JLabel titleErrorLabel; JLabel priceErrorLabel; JLabel quantityErrorLabel;
	JLabel pagesErrorLabel; JLabel audioLengthErrorLabel;
	
	AddBookPanel() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 200, 0, 400};
		gridBagLayout.rowHeights = new int[]{20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel addBookLabel = new JLabel("Add a Book :");
		addBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_addBookLabel = new GridBagConstraints();
		gbc_addBookLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addBookLabel.gridx = 1;
		gbc_addBookLabel.gridy = 1;
		add(addBookLabel, gbc_addBookLabel);
		
		JLabel isbnLabel = new JLabel("ISBN :");
		isbnLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_isbnLabel = new GridBagConstraints();
		gbc_isbnLabel.insets = new Insets(0, 0, 5, 5);
		gbc_isbnLabel.anchor = GridBagConstraints.WEST;
		gbc_isbnLabel.gridx = 1;
		gbc_isbnLabel.gridy = 3;
		add(isbnLabel, gbc_isbnLabel);
		
		isbnField = new JTextField();
		GridBagConstraints gbc_isbnField = new GridBagConstraints();
		gbc_isbnField.insets = new Insets(0, 0, 5, 5);
		gbc_isbnField.fill = GridBagConstraints.HORIZONTAL;
		gbc_isbnField.gridx = 2;
		gbc_isbnField.gridy = 3;
		add(isbnField, gbc_isbnField);
		isbnField.setColumns(10);
		
		JLabel titleLabel = new JLabel("Book Title :");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.anchor = GridBagConstraints.WEST;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 5;
		add(titleLabel, gbc_titleLabel);
		
		titleField = new JTextField();
		GridBagConstraints gbc_titleField = new GridBagConstraints();
		gbc_titleField.insets = new Insets(0, 0, 5, 5);
		gbc_titleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleField.gridx = 2;
		gbc_titleField.gridy = 5;
		add(titleField, gbc_titleField);
		titleField.setColumns(10);
		
		JLabel priceLabel = new JLabel("Price :");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.anchor = GridBagConstraints.WEST;
		gbc_priceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_priceLabel.gridx = 1;
		gbc_priceLabel.gridy = 7;
		add(priceLabel, gbc_priceLabel);
		
		priceField = new JTextField();
		GridBagConstraints gbc_priceField = new GridBagConstraints();
		gbc_priceField.insets = new Insets(0, 0, 5, 5);
		gbc_priceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceField.gridx = 2;
		gbc_priceField.gridy = 7;
		add(priceField, gbc_priceField);
		priceField.setColumns(10);
		
		JLabel quantityLabel = new JLabel("Quantity :");
		quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_quantityLabel = new GridBagConstraints();
		gbc_quantityLabel.anchor = GridBagConstraints.WEST;
		gbc_quantityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_quantityLabel.gridx = 1;
		gbc_quantityLabel.gridy = 9;
		add(quantityLabel, gbc_quantityLabel);
		
		quantityField = new JTextField();
		GridBagConstraints gbc_quantityField = new GridBagConstraints();
		gbc_quantityField.insets = new Insets(0, 0, 5, 5);
		gbc_quantityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_quantityField.gridx = 2;
		gbc_quantityField.gridy = 9;
		add(quantityField, gbc_quantityField);
		quantityField.setColumns(10);
		
		JLabel languageLabel = new JLabel("Language :");
		languageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_languageLabel = new GridBagConstraints();
		gbc_languageLabel.anchor = GridBagConstraints.WEST;
		gbc_languageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_languageLabel.gridx = 1;
		gbc_languageLabel.gridy = 11;
		add(languageLabel, gbc_languageLabel);
		
		languageBox = new JComboBox();
		languageBox.setModel(new DefaultComboBoxModel(new String[] {"English", "French"}));
		GridBagConstraints gbc_languageBox = new GridBagConstraints();
		gbc_languageBox.insets = new Insets(0, 0, 5, 5);
		gbc_languageBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_languageBox.gridx = 2;
		gbc_languageBox.gridy = 11;
		add(languageBox, gbc_languageBox);
		
		JLabel genreLabel = new JLabel("Genre :");
		genreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_genreLabel = new GridBagConstraints();
		gbc_genreLabel.anchor = GridBagConstraints.WEST;
		gbc_genreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genreLabel.gridx = 1;
		gbc_genreLabel.gridy = 13;
		add(genreLabel, gbc_genreLabel);
		
		genreBox = new JComboBox();
		genreBox.setModel(new DefaultComboBoxModel(new String[] {"Politics", "Medicine", "Business", "Computer Science", "Biography"}));
		GridBagConstraints gbc_genreBox = new GridBagConstraints();
		gbc_genreBox.insets = new Insets(0, 0, 5, 5);
		gbc_genreBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_genreBox.gridx = 2;
		gbc_genreBox.gridy = 13;
		add(genreBox, gbc_genreBox);
		
		JLabel typeLabel = new JLabel("Book Type :");
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_typeLabel = new GridBagConstraints();
		gbc_typeLabel.anchor = GridBagConstraints.WEST;
		gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_typeLabel.gridx = 1;
		gbc_typeLabel.gridy = 15;
		add(typeLabel, gbc_typeLabel);
		
		typeBox = new JComboBox();
		typeBox.addActionListener(this);
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"paperback", "ebook", "audiobook"}));
		GridBagConstraints gbc_typeBox = new GridBagConstraints();
		gbc_typeBox.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox.gridx = 2;
		gbc_typeBox.gridy = 15;
		add(typeBox, gbc_typeBox);
		
		// ----- Paperback -----
		pagesLabel = new JLabel("No. of Pages :");
		pagesLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_pagesLabel = new GridBagConstraints();
		gbc_pagesLabel.anchor = GridBagConstraints.WEST;
		gbc_pagesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_pagesLabel.gridx = 1;
		gbc_pagesLabel.gridy = 17;
		add(pagesLabel, gbc_pagesLabel);
		
		pagesField = new JTextField();
		GridBagConstraints gbc_pagesField = new GridBagConstraints();
		gbc_pagesField.insets = new Insets(0, 0, 5, 5);
		gbc_pagesField.fill = GridBagConstraints.HORIZONTAL;
		gbc_pagesField.gridx = 2;
		gbc_pagesField.gridy = 17;
		add(pagesField, gbc_pagesField);
		pagesField.setColumns(10);
		
		conditionLabel = new JLabel("Condition :");
		conditionLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_conditionLabel = new GridBagConstraints();
		gbc_conditionLabel.anchor = GridBagConstraints.WEST;
		gbc_conditionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_conditionLabel.gridx = 1;
		gbc_conditionLabel.gridy = 19;
		add(conditionLabel, gbc_conditionLabel);
		
		conditionBox = new JComboBox();
		conditionBox.setModel(new DefaultComboBoxModel(new String[] {"new", "used"}));
		GridBagConstraints gbc_conditionBox = new GridBagConstraints();
		gbc_conditionBox.insets = new Insets(0, 0, 5, 5);
		gbc_conditionBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_conditionBox.gridx = 2;
		gbc_conditionBox.gridy = 19;
		add(conditionBox, gbc_conditionBox);
		
		// ----- ebook -----
		ebookFormatLabel = new JLabel("Format :");
		ebookFormatLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_ebookFormatLabel = new GridBagConstraints();
		gbc_ebookFormatLabel.anchor = GridBagConstraints.WEST;
		gbc_ebookFormatLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ebookFormatLabel.gridx = 1;
		gbc_ebookFormatLabel.gridy = 19;
		add(ebookFormatLabel, gbc_ebookFormatLabel);
		ebookFormatLabel.setVisible(false);
		
		ebookFormatBox = new JComboBox();
		ebookFormatBox.setModel(new DefaultComboBoxModel(new String[] {"EPUB", "MOBI", "AZW3", "PDF"}));
		GridBagConstraints gbc_ebookFormatBox = new GridBagConstraints();
		gbc_ebookFormatBox.insets = new Insets(0, 0, 5, 5);
		gbc_ebookFormatBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_ebookFormatBox.gridx = 2;
		gbc_ebookFormatBox.gridy = 19;
		add(ebookFormatBox, gbc_ebookFormatBox);
		ebookFormatBox.setVisible(false);
		
		// ----- AudioBook -----
		audioLengthLabel = new JLabel("Audio Length (hours) :");
		audioLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_audioLengthLabel = new GridBagConstraints();
		gbc_audioLengthLabel.anchor = GridBagConstraints.WEST;
		gbc_audioLengthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_audioLengthLabel.gridx = 1;
		gbc_audioLengthLabel.gridy = 17;
		add(audioLengthLabel, gbc_audioLengthLabel);
		audioLengthLabel.setVisible(false);
		
		audioLengthField = new JTextField();
		GridBagConstraints gbc_audioLengthField = new GridBagConstraints();
		gbc_audioLengthField.insets = new Insets(0, 0, 5, 5);
		gbc_audioLengthField.fill = GridBagConstraints.HORIZONTAL;
		gbc_audioLengthField.gridx = 2;
		gbc_audioLengthField.gridy = 17;
		add(audioLengthField, gbc_audioLengthField);
		audioLengthField.setColumns(10);
		audioLengthField.setVisible(false);
		
		audioFormatLabel = new JLabel("Format :");
		audioFormatLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_audioFormatLabel = new GridBagConstraints();
		gbc_audioFormatLabel.anchor = GridBagConstraints.WEST;
		gbc_audioFormatLabel.insets = new Insets(0, 0, 5, 5);
		gbc_audioFormatLabel.gridx = 1;
		gbc_audioFormatLabel.gridy = 19;
		add(audioFormatLabel, gbc_audioFormatLabel);
		audioFormatLabel.setVisible(false);
		
		audioFormatBox = new JComboBox();
		audioFormatBox.setModel(new DefaultComboBoxModel(new String[] {"MP3", "WMA", "AAC"}));
		GridBagConstraints gbc_audioFormatBox = new GridBagConstraints();
		gbc_audioFormatBox.insets = new Insets(0, 0, 5, 5);
		gbc_audioFormatBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_audioFormatBox.gridx = 2;
		gbc_audioFormatBox.gridy = 19;
		add(audioFormatBox, gbc_audioFormatBox);
		audioFormatBox.setVisible(false);
		
		addBookBtn = new JButton("Add Book");
		addBookBtn.addActionListener(this);
		addBookBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_addBookBtn = new GridBagConstraints();
		gbc_addBookBtn.insets = new Insets(0, 0, 5, 5);
		gbc_addBookBtn.gridx = 1;
		gbc_addBookBtn.gridy = 22;
		add(addBookBtn, gbc_addBookBtn);
		
		// ----- Labels for Incorrect Data in TextFields -----
		isbnErrorLabel = new JLabel("");
		isbnErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		isbnErrorLabel.setForeground(Color.red);
		GridBagConstraints gbc_isbnErrorLabel = new GridBagConstraints();
		gbc_isbnErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_isbnErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_isbnErrorLabel.gridx = 4;
		gbc_isbnErrorLabel.gridy = 3;
		add(isbnErrorLabel, gbc_isbnErrorLabel);
		
		titleErrorLabel = new JLabel("");
		titleErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		titleErrorLabel.setForeground(Color.red);
		GridBagConstraints gbc_titleErrorLabel = new GridBagConstraints();
		gbc_titleErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_titleErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleErrorLabel.gridx = 4;
		gbc_titleErrorLabel.gridy = 5;
		add(titleErrorLabel, gbc_titleErrorLabel);
		
		priceErrorLabel = new JLabel("");
		priceErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		priceErrorLabel.setForeground(Color.red);
		GridBagConstraints gbc_priceErrorLabel = new GridBagConstraints();
		gbc_priceErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_priceErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_priceErrorLabel.gridx = 4;
		gbc_priceErrorLabel.gridy = 7;
		add(priceErrorLabel, gbc_priceErrorLabel);
		
		quantityErrorLabel = new JLabel("");
		quantityErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		quantityErrorLabel.setForeground(Color.red);
		GridBagConstraints gbc_quantityErrorLabel = new GridBagConstraints();
		gbc_quantityErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_quantityErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_quantityErrorLabel.gridx = 4;
		gbc_quantityErrorLabel.gridy = 9;
		add(quantityErrorLabel, gbc_quantityErrorLabel);
		
		pagesErrorLabel = new JLabel("");
		pagesErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		pagesErrorLabel.setForeground(Color.red);
		GridBagConstraints gbc_pagesErrorLabel = new GridBagConstraints();
		gbc_pagesErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_pagesErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_pagesErrorLabel.gridx = 4;
		gbc_pagesErrorLabel.gridy = 17;
		add(pagesErrorLabel, gbc_pagesErrorLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==typeBox) {
			if (typeBox.getSelectedItem().toString().equals("ebook")) {
				conditionLabel.setVisible(false);
				conditionBox.setVisible(false);
				audioLengthLabel.setVisible(false);
				audioLengthField.setVisible(false);
				audioFormatLabel.setVisible(false);
				audioFormatBox.setVisible(false);
				
				pagesLabel.setVisible(true);
				pagesField.setVisible(true);
				ebookFormatLabel.setVisible(true);
				ebookFormatBox.setVisible(true);
			} else if (typeBox.getSelectedItem().toString().equals("audiobook")) {
				pagesLabel.setVisible(false);
				pagesField.setVisible(false);
				conditionLabel.setVisible(false);
				conditionBox.setVisible(false);
				ebookFormatLabel.setVisible(false);
				ebookFormatBox.setVisible(false);
				
				audioLengthLabel.setVisible(true);
				audioLengthField.setVisible(true);
				audioFormatLabel.setVisible(true);
				audioFormatBox.setVisible(true);
			} else {
				ebookFormatLabel.setVisible(false);
				ebookFormatBox.setVisible(false);
				audioLengthLabel.setVisible(false);
				audioLengthField.setVisible(false);
				audioFormatLabel.setVisible(false);
				audioFormatBox.setVisible(false);
				
				pagesLabel.setVisible(true);
				pagesField.setVisible(true);
				conditionLabel.setVisible(true);
				conditionBox.setVisible(true);
			}
		}
		
		if (e.getSource()==addBookBtn) {
			
			String stockLine;
			String isbn = isbnField.getText();
			String title = titleField.getText();
			String price = priceField.getText();
			String quantity = quantityField.getText();
			String language = languageBox.getSelectedItem().toString();
			String genre = genreBox.getSelectedItem().toString();
			String type = typeBox.getSelectedItem().toString();
			
			// ---------- Checking every textField for incorrect values and errors ----------
			int isbnTrue = 0;
			int isbnLength = isbn.length();
			if (isbnLength==8) {
				try {
					Integer.parseInt(isbn);
					isbnTrue = 1;
					isbnErrorLabel.setText("");
				} catch (NumberFormatException e1) { isbnErrorLabel.setText("isbn must be an 8 number"); } 
			} else { isbnErrorLabel.setText("isbn must be an 8 digit number"); } 
			
			int quantityTrue = 0;
			int quantityLength = quantity.length();
			if (quantityLength != 0 && quantityLength < 3 && quantity != "0") {
				try {
					Integer.parseInt(quantity);
					quantityTrue = 1;
					quantityErrorLabel.setText("");
				} catch (NumberFormatException e1) { quantityErrorLabel.setText("quantity must be between 1 and 99"); }
			} else { quantityErrorLabel.setText("quantity must be between 1 and 99"); }
			
			int priceTrue = 0;
			int priceLength = price.length();
			if (priceLength != 0 && price != "0") {
				try {
					Double.parseDouble(price);
					priceTrue = 1;
					priceErrorLabel.setText("");
				} catch (NumberFormatException e1) { priceErrorLabel.setText("price must be a number"); }	
			} else { priceErrorLabel.setText("price must be a number greater than 0"); }
			
			int titleTrue = 0;
			if (title.equals("")) {
				titleErrorLabel.setText("title cannot be left blank");
			} else { titleTrue = 1; titleErrorLabel.setText(""); }
			
			int pagesTrue = 0;
			int audioHoursTrue = 0;
			if (type.equals("paperback") || type.equals("ebook")) {
				int pagesLength = pagesField.getText().length();
				if (pagesLength != 0) {
					try {
						Integer.parseInt(pagesField.getText());
						pagesTrue = 1;
						pagesErrorLabel.setText("");
					} catch (NumberFormatException e1) { pagesErrorLabel.setText("must be a whole number"); }
				} else { pagesErrorLabel.setText("must be a whole number"); }
			} else if (type.equals("audiobook")){
				int audioLength = audioLengthField.getText().length();
				if (audioLength != 0) {
					try {
						Double.parseDouble(audioLengthField.getText());
						audioHoursTrue = 1;
						pagesErrorLabel.setText("");
					} catch (NumberFormatException e1) { pagesErrorLabel.setText("must be a number"); }	
				} else { pagesErrorLabel.setText("must be a number"); } 
			}
			
			// ----- Checks if isbn already exists -----
			try {
				Panel2 panel2 = new Panel2();
				int rows = panel2.bookTable.getRowCount();
				for (int i = 0; i<rows;i++) {
					if (panel2.bookTable.getValueAt(i, 0).toString().equals(isbn)) {
						isbnTrue = 0;
					}
				}
			} catch (FileNotFoundException e1) {e1.printStackTrace();}
			
			
			// Gets Date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			
			// ---------- Adding Book to Stock.txt ----------
			try {
				FileWriter writer = new FileWriter("Stock.txt", true);
				if (isbnTrue == 1 && quantityTrue == 1 && priceTrue == 1 && titleTrue == 1) {
					stockLine = isbn+", "+type+", "+title+", "+language+", "+genre+", "+currentDate+", "+price+", "+quantity;
					if (type.equals("paperback") && pagesTrue == 1) {
						stockLine = stockLine+", "+pagesField.getText()+", "+conditionBox.getSelectedItem().toString();
						writer.write("\r\n"+stockLine);
					} else if (type.equals("ebook") && pagesTrue == 1) {
						stockLine = stockLine+", "+pagesField.getText()+", "+ebookFormatBox.getSelectedItem().toString();
						writer.write(stockLine);
					} else if (type.equals("audiobook") && audioHoursTrue == 1) {
						stockLine = stockLine+", "+audioLengthField.getText()+", "+audioFormatBox.getSelectedItem().toString();
						writer.write(stockLine);
					}
				}
				writer.close();
			} catch (IOException e1) {e1.printStackTrace();}
		}
		
	}
}
