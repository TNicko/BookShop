import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Panel3 extends JPanel implements ActionListener {
	
	JTextArea basketList;
	JButton backBtn;
	JButton clearBasket;
	
	JPanel southPanel;
	JLabel totalPrice;
	JPanel checkoutPanel;
	JLabel checkoutLabel;JButton cardBtn;JButton paypalBtn;
	JLabel cardNumber;JTextField cardNumberField;JLabel sortCode;JTextField sortCodeField;
	JLabel emailLabel;JTextField emailField;JButton buyBtn;
	JLabel cardSuccessLabel;JLabel paypalSuccessLabel; JPanel incorrectDetailsPanel; JLabel incorrectDetails;
	
	float price = 0;
	
	Panel3() {
		
		//----------- North Panel -----------
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		JPanel btnPanel = new JPanel();
		backBtn = new JButton(" <-- Go Back");
		backBtn.addActionListener(this);
		btnPanel.add(backBtn);
		northPanel.add(btnPanel,BorderLayout.NORTH);
		JLabel basketLabel = new JLabel("Your Basket : ");
		basketLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		northPanel.add(basketLabel,BorderLayout.CENTER);
		
		//----------- Center -----------
		
		basketList = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		basketList.setBorder(border);
		
		//----------- East Panel -----------
		JPanel eastPanel = new JPanel();
		clearBasket = new JButton("Clear Basket");
		clearBasket.addActionListener(this);
		eastPanel.add(clearBasket);		
		
		//----------- South Panel -----------
		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		totalPrice = new JLabel();
		totalPrice.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		southPanel.add(totalPrice,BorderLayout.NORTH);
		
		//----------- South Panel: Checkout -----------
		checkoutPanel = new JPanel();
		checkoutPanel.setBorder(BorderFactory.createEmptyBorder(30, -5, 60, 0));
		checkoutLabel = new JLabel("Checkout :  ");
		checkoutLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		cardBtn = new JButton("Credit/Debit Card");
		cardBtn.addActionListener(this);
		paypalBtn = new JButton("Paypal");
		paypalBtn.addActionListener(this);
		checkoutPanel.add(checkoutLabel);
		checkoutPanel.add(paypalBtn);
		checkoutPanel.add(cardBtn);
		southPanel.add(checkoutPanel,BorderLayout.WEST);
		
		//----------- Checkout: Pay By Card -----------
		cardNumber = new JLabel("Card Number: ");
		cardNumberField = new JTextField(15);
		sortCode = new JLabel("   Sort Code: ");
		sortCodeField = new JTextField(5);
		cardNumber.setVisible(false);
		cardNumberField.setVisible(false);
		sortCode.setVisible(false);
		sortCodeField.setVisible(false);
		checkoutPanel.add(cardNumber);
		checkoutPanel.add(cardNumberField);
		checkoutPanel.add(sortCode);
		checkoutPanel.add(sortCodeField);
		
		//----------- Checkout: Paypal -----------
		emailLabel = new JLabel("Paypal Email: ");
		emailField = new JTextField(25);
		buyBtn = new JButton("Buy");
		buyBtn.addActionListener(this);
		emailLabel.setVisible(false);
		emailField.setVisible(false);
		buyBtn.setVisible(false);
		checkoutPanel.add(emailLabel);
		checkoutPanel.add(emailField);
		checkoutPanel.add(buyBtn);
		
		//----------- Checkout: Successful -----------
		paypalSuccessLabel = new JLabel();
		cardSuccessLabel = new JLabel();
		paypalSuccessLabel.setVisible(false);
		cardSuccessLabel.setVisible(false);
		checkoutPanel.add(cardSuccessLabel);
		checkoutPanel.add(paypalSuccessLabel);
		
		//----------- Checkout: Unsuccessful -----------
		incorrectDetails = new JLabel("Incorrect Details");
		incorrectDetails.setVisible(false);
		checkoutPanel.add(incorrectDetails);
		
		this.setSize(1000,700);
		this.setLayout(new BorderLayout());
		this.add(northPanel, BorderLayout.NORTH);
		this.add(basketList, BorderLayout.CENTER);
		this.add(southPanel,BorderLayout.SOUTH);
		this.add(eastPanel, BorderLayout.EAST);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==cardBtn) {
			checkoutLabel.setVisible(false);
			cardBtn.setVisible(false);
			paypalBtn.setVisible(false);
			
			cardNumber.setVisible(true);
			cardNumberField.setVisible(true);
			sortCode.setVisible(true);
			sortCodeField.setVisible(true);
			buyBtn.setVisible(true);
		}
		if (e.getSource()==paypalBtn) {
			checkoutLabel.setVisible(false);
			cardBtn.setVisible(false);
			paypalBtn.setVisible(false);
			
			emailLabel.setVisible(true);
			emailField.setVisible(true);
			buyBtn.setVisible(true);
		}
		if (e.getSource()==backBtn) {
			cardNumber.setVisible(false);
			cardNumberField.setVisible(false);
			sortCode.setVisible(false);
			sortCodeField.setVisible(false);
			emailLabel.setVisible(false);
			emailField.setVisible(false);
			buyBtn.setVisible(false);
			incorrectDetails.setVisible(false);
			paypalSuccessLabel.setVisible(false);
			cardSuccessLabel.setVisible(false);
			
			checkoutLabel.setVisible(true);
			cardBtn.setVisible(true);
			paypalBtn.setVisible(true);
		}
		if (e.getSource()==clearBasket) {
		
			try {
				ActivityLogging.booksInBasket("cancelled","");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			basketList.setText("");
			totalPrice.setText("");
			price = 0;
		}
		if (e.getSource()==buyBtn) {
			
			String cardNum = cardNumberField.getText();
			String sortCodeNum = sortCodeField.getText();
			String email = emailField.getText();
			cardNumberField.setText("");
			sortCodeField.setText("");
			emailField.setText("");
			int cardLength = String.valueOf(cardNum).length();
			int sortCodeLength = String.valueOf(sortCodeNum).length();
			int buySuccessful = 0;
			
			if (cardLength == 16 && sortCodeLength == 3) {
				try {
					Double.parseDouble(cardNum);
					Integer.parseInt(sortCodeNum);
					cardNumber.setVisible(false);
					cardNumberField.setVisible(false);
					sortCode.setVisible(false);
					sortCodeField.setVisible(false);
					emailLabel.setVisible(false);
					emailField.setVisible(false);
					buyBtn.setVisible(false);
					incorrectDetails.setVisible(false);

					cardSuccessLabel.setText("£"+String.format("%.4g%n", price)+" paid using card");
					cardSuccessLabel.setVisible(true);
					buySuccessful++;
					
					try {
						ActivityLogging.booksInBasket("purchased","Credit Card");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (NumberFormatException e1) {incorrectDetails.setVisible(true);}
			} else {incorrectDetails.setVisible(true);}
			if (email.length() != 0) {
				cardNumber.setVisible(false);
				cardNumberField.setVisible(false);
				sortCode.setVisible(false);
				sortCodeField.setVisible(false);
				emailLabel.setVisible(false);
				emailField.setVisible(false);
				buyBtn.setVisible(false);
				incorrectDetails.setVisible(false);

				paypalSuccessLabel.setText("£"+String.format("%.4g%n", price)+" paid using paypal");
				paypalSuccessLabel.setVisible(true);
				buySuccessful++;
				
				try {
					ActivityLogging.booksInBasket("purchased","paypal");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else if (email.length() == 0 && cardLength == 0 && sortCodeLength == 0) {incorrectDetails.setVisible(true);}
			
			if (buySuccessful == 1) {
				
				basketList.setText("");
				totalPrice.setText("");
				price = 0;
			}
		}
	}
}
