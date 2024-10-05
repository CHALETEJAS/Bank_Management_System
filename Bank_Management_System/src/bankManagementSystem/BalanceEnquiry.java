package bankManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {

	JButton back;
	String pinnumber;

	BalanceEnquiry(String pinnumber) {

		this.pinnumber = pinnumber;

		setLayout(null);

		ImageIcon i1 = new ImageIcon("D:\\Tejas\\Project\\Bank_Management_System\\Stuff\\icons\\atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);

		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		label.add(back);

		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinnumber + "'");

			while (rs.next()) {
				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your Current Account balance is Rs "+ balance);
		text.setForeground(Color.white);
		text.setBounds(170, 300, 400, 30);
		label.add(text);

		setUndecorated(true);
		setSize(900, 900);
		setVisible(true);
		setLocation(900, 0);
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true); // Assuming Transactions is another JFrame or a similar GUI
														// component
	}

	public static void main(String[] args) {

		new BalanceEnquiry("");
	}

}
