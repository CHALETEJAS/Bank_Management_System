package bankManagementSystem;

import java.awt.Color;
import java.util.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton deposit, back;
	String pinnumber;
	
	Deposit(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("D:\\Tejas\\Project\\Bank_Management_System\\Stuff\\icons\\atm.jpg");
	    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel label = new JLabel(i3);
	    label.setBounds(0, 0, 900, 900);
	    add(label);
	    
	    JLabel text = new JLabel("Enter the amount you want to deposit");
	    text.setForeground(Color.white);
	    text.setFont(new Font("System", Font.BOLD,16));
	    text.setBounds(170, 300, 400, 20);
	    label.add(text);
	    
	    amount = new JTextField();
	    amount.setFont(new Font("Raleway", Font.BOLD,22));
	    amount.setBounds(170, 350, 320, 20);
	    label.add(amount);
	    
	    deposit = new JButton("Deposit");
	    deposit.setBounds(355, 485, 150, 30);
	    deposit.addActionListener(this);
	    label.add(deposit);
	    
	    back = new JButton("Back");
	    back.setBounds(355, 520, 150, 30);
	    back.addActionListener(this);
	    label.add(back);
	    
	    
	    setSize(900, 900);
	    setLocation(300, 0);
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {
			String number = amount.getText();
//			Date date = new Date();
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formattedDate = date.format(formatter);
			
			if(number.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			}else {
				try {
					Conn conn = new Conn();
					String query = "insert into bank value('"+pinnumber+"','"+date+"','Deposit', '"+number+"')";
					conn.s.executeLargeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs"+number+" Deposited Succeddfully");
					setVisible(true);
					new Transactions(pinnumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
				}
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		
		new Deposit("");
		
	}

}
