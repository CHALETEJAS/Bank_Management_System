package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// The Transactions class extends JFrame and implements ActionListener to handle button clicks
public class Transactions extends JFrame implements ActionListener {
    
    // Declare buttons for various transaction types
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;
    
    // Constructor to set up the transactions window
    Transactions(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
            
        // Add the ATM background image to the transactions window
        ImageIcon i1 = new ImageIcon("D:\\Tejas\\Project\\Bank_Management_System\\Stuff\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);
        
        // Add a message to prompt the user to select a transaction
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);
        
        // Add and configure the Deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        // Add and configure the Cash Withdrawal button
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        label.add(withdrawl);
        
        // Add and configure the Fast Cash button
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        // Add and configure the Mini Statement button
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        label.add(ministatement);
        
        // Add and configure the Pin Change button
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        label.add(pinchange);
        
        // Add and configure the Balance Enquiry button
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        label.add(balanceenquiry);
        
        // Add and configure the Exit button
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        label.add(exit);
        
        // Set the size, location, and visibility of the transactions window
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            // Exit the application if the Exit button is clicked
            System.exit(0);
        }else if(ae.getSource() == deposit) {
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}else if(ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if(ae.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}else if(ae.getSource() == ministatement) {
			new MiniStatement(pinnumber).setVisible(true);
		}
        
        // Additional action handling for other buttons can be implemented here
    }

    // Main method to create an instance of the Transactions class and display the transactions window
    public static void main(String[] args) {
        new Transactions("");
    }
}
