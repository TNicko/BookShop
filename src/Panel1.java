import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel1 extends JPanel implements ActionListener{
	
	JButton adminBtn;
	JButton customerBtn;
	JLabel welcomeLabel;
	JButton customerLoginBtn;
	JLabel adminLabel;
	JLabel userLabel;
	JTextField loginField;
	JLabel loginLabel;
	JButton adminLoginBtn;
	String user;
	JLabel incorrectUsernameLabel;
	JButton goBackBtn;
	
	Panel1() {
		
		welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to the Book Shop!");
		welcomeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(143, 25, 214, 25);
		
		adminBtn = new JButton();
		adminBtn.setText("Admin");
		adminBtn.setFocusable(false);
		adminBtn.setBounds(163,100,174,32);
		adminBtn.addActionListener(this);
		
		
		customerBtn = new JButton();
		customerBtn.setText("Customer");
		customerBtn.setFocusable(false);
		customerBtn.setBounds(163,150,174,32);
		customerBtn.addActionListener(this);
		
		//---------------- login components start -----------------
		
		adminLabel = new JLabel();
		adminLabel.setText("Admin Login");
		adminLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setBounds(143, 25, 214, 25);
		adminLabel.setVisible(false);
		
		userLabel = new JLabel();
		userLabel.setText("User Login");
		userLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setBounds(143, 25, 214, 25);
		userLabel.setVisible(false);
		
		loginLabel = new JLabel();
		loginLabel.setText("Username");
		loginLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(0, 100, 500, 25);
		loginLabel.setVisible(false);
		
		loginField = new JTextField();
		loginField.setBounds(150, 140, 200, 20);
		loginField.setVisible(false);
		
		customerLoginBtn = new JButton();
		customerLoginBtn.setText("Login");
		customerLoginBtn.setFocusable(false);
		customerLoginBtn.setBounds(210,180,80,30);
		customerLoginBtn.setVisible(false);
		customerLoginBtn.addActionListener(this);
		
		adminLoginBtn = new JButton();
		adminLoginBtn.setText("Login");
		adminLoginBtn.setFocusable(false);
		adminLoginBtn.setBounds(210,180,80,30);
		adminLoginBtn.setVisible(false);
		adminLoginBtn.addActionListener(this);
		
		incorrectUsernameLabel = new JLabel();
		incorrectUsernameLabel.setText("Incorrect Username");
		incorrectUsernameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		incorrectUsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectUsernameLabel.setBounds(0, 100, 500, 25);
		incorrectUsernameLabel.setVisible(false);
		
		goBackBtn = new JButton();
		goBackBtn.setText("go back");
		goBackBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 8));
		goBackBtn.setFocusable(false);
		goBackBtn.setBounds(215,220,70,20);
		goBackBtn.setVisible(false);
		goBackBtn.addActionListener(this);
		
		//---------------- login components finish -----------------
		
		this.setSize(500,300);
		this.setLayout(null);
		this.add(adminBtn);
		this.add(customerBtn);
		this.add(welcomeLabel);
		this.add(adminLabel);
		this.add(userLabel);
		this.add(loginLabel);
		this.add(loginField);
		this.add(customerLoginBtn);
		this.add(adminLoginBtn);
		this.add(incorrectUsernameLabel);
		this.add(goBackBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		customerBtn.setVisible(false);
		adminBtn.setVisible(false);
		welcomeLabel.setVisible(false);
		loginLabel.setVisible(true);
		loginField.setVisible(true);
		goBackBtn.setVisible(true);
		if (e.getSource()==adminBtn) {
			adminLabel.setVisible(true);
			adminLoginBtn.setVisible(true);
		} 
		if (e.getSource()==customerBtn) {
			userLabel.setVisible(true);
			customerLoginBtn.setVisible(true);
		}
		if (e.getSource()==adminLoginBtn) {
			user = loginField.getText();
			loginLabel.setVisible(false);
		}
		if (e.getSource()==customerLoginBtn) {
			user = loginField.getText();
			loginLabel.setVisible(false);
		}
		if (e.getSource()==goBackBtn) {
			incorrectUsernameLabel.setVisible(false);
			loginLabel.setVisible(false);
			loginField.setVisible(false);
			goBackBtn.setVisible(false);
			loginLabel.setVisible(false);
			loginField.setVisible(false);
			adminLabel.setVisible(false);
			adminLoginBtn.setVisible(false);
			userLabel.setVisible(false);
			customerLoginBtn.setVisible(false);
			
			customerBtn.setVisible(true);
			adminBtn.setVisible(true);
			welcomeLabel.setVisible(true);
		}
	}
}
