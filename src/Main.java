import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main implements ActionListener {

	static Panel1 panel1;
	static Panel2 panel2;
	static AddBookPanel addBookPanel;
	static public Panel3 panel3;
	static JButton adminLoginBtn;
	static JFrame frame;
	static ArrayList<String> customerUsernames;
	static ArrayList<String> adminUsernames;
	static ArrayList<Integer> rowsUsed = new ArrayList<Integer>();
	static int row;
	
	Main() throws FileNotFoundException {
		
		panel1 = new Panel1();
		panel1.adminLoginBtn.addActionListener(this);
		panel1.customerLoginBtn.addActionListener(this);
		
		panel3 = new Panel3();
		panel3.setVisible(false);
		panel3.backBtn.addActionListener(this);
		panel3.clearBasket.addActionListener(this);
		
		addBookPanel = new AddBookPanel();
		addBookPanel.setVisible(false);
		
		panel2 = new Panel2();
		panel2.setVisible(false);
		panel2.cartBtn.addActionListener(this);
		panel2.adminAddBookBtn.addActionListener(this);
		panel2.bookTable.addMouseListener(new MouseAdapter() {
			@Override
			//Adds book/row clicked on to basket. Checks if book stock reaches 0
			public void mouseClicked(MouseEvent e) {
				row = panel2.bookTable.getSelectedRow();
				String[] rowInfo = {panel2.bookTable.getValueAt(row, 0).toString(),panel2.bookTable.getValueAt(row, 1).toString(),panel2.bookTable.getValueAt(row, 2).toString(),
						panel2.bookTable.getValueAt(row, 3).toString(),panel2.bookTable.getValueAt(row, 4).toString(),panel2.bookTable.getValueAt(row, 5).toString(),
						panel2.bookTable.getValueAt(row, 6).toString(),panel2.bookTable.getValueAt(row, 7).toString(),panel2.bookTable.getValueAt(row, 8).toString(),
						panel2.bookTable.getValueAt(row, 9).toString()};
				int quantity = Integer.valueOf((String) panel2.bookTable.getValueAt(row, 7));
				if (quantity != 0) {
					rowsUsed.add(row);
					panel2.bookTable.setValueAt(String.valueOf(quantity-1), row, 7);
					panel3.price = panel3.price + Float.parseFloat(rowInfo[6]);
					panel3.basketList.setText(panel3.basketList.getText() + Arrays.toString(rowInfo).replace("[", "").replace("]", "") + "\r\n");
					panel3.basketList.repaint();
					panel3.totalPrice.setText("Total : £" + String.format("%.4g%n", panel3.price));
					JOptionPane.showOptionDialog(null, "Book Added to Basket", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, null);
					
				
				} else {
					JOptionPane.showOptionDialog(null, "No more in stock", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, null);
				}
			}
		});
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setVisible(true);
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(panel2);
		frame.getContentPane().add(panel3);
		frame.getContentPane().add(addBookPanel);
		ImageIcon image = new ImageIcon("navIcon.png");
		frame.setIconImage(image.getImage());
		frame.setResizable(true);
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		new Main();
		// ---------- Creates a list of customers and admins ----------
		File usersData = new File("UserAccounts.txt");
		Scanner userScanner = new Scanner(usersData);
		
		customerUsernames = new ArrayList<String>();
		adminUsernames = new ArrayList<String>();
		User u;
		while (userScanner.hasNextLine()) {
			String[] userData = userScanner.nextLine().split(", ");
			u = new User(Integer.parseInt(userData[0]),userData[1],userData[2],Integer.parseInt(userData[3]),userData[4],userData[5],userData[6]);
			
			if (u.role.equals("customer")) {
				customerUsernames.add(u.username);
			} else {
				adminUsernames.add(u.username);	
			}
		}
		userScanner.close();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If Usernames correct, switches to Panel2
		
		if (e.getSource()==panel1.adminLoginBtn) {
			for (String element : adminUsernames) {
				if (panel1.loginField.getText().equals(element)) {
					panel1.setVisible(false);
					panel2.setVisible(true);
					frame.setSize(1000,700);
					panel2.cartBtn.setVisible(false);
					panel2.adminAddBookBtn.setVisible(true);
				} else { panel1.incorrectUsernameLabel.setVisible(true); }
			}
		}
		if (e.getSource()==panel1.customerLoginBtn) {
			for (String element : customerUsernames) {
				if (panel1.loginField.getText().equals(element)) {
					panel1.setVisible(false);
					panel2.setVisible(true);
					frame.setSize(1000,700);
				} else { panel1.incorrectUsernameLabel.setVisible(true); }
			}
		}
		
		if (e.getSource()==panel2.cartBtn) {
			panel2.setVisible(false);
			panel3.setVisible(true);
		}
		if (e.getSource()==panel3.backBtn) {
			panel3.setVisible(false);
			panel2.setVisible(true);
		}
		
		if (e.getSource()==panel3.clearBasket) {	
			// Changes the quantity of book available back before added to basket
			for (int i : rowsUsed) {
				int quantity = Integer.valueOf((String) panel2.bookTable.getValueAt(i, 7));
				panel2.bookTable.setValueAt(String.valueOf(quantity+1), i, 7);	
			}
		}
		if (e.getSource()==panel2.adminAddBookBtn) {
			panel2.setVisible(false);
			addBookPanel.setVisible(true);
		}
	}
}
