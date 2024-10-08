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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin, repin;
	JButton change, back;
	String pinnumber;
	
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("D:\\Tejas\\Project\\Bank_Management_System\\Stuff\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);
		
        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        label.add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        label.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        label.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        label.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        label.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        label.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);
        
        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == change) {
			try {
				
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN ");
					return;
				}
				
				Conn conn = new Conn();
				String query1 = "update bank set pin = '"+rpin + "' where pin = '"+ pinnumber+"'";
				String query2 = "update login set pin = '"+rpin + "' where pin = '"+ pinnumber+"'";
				String query3 = "update signupthree set pin = '"+rpin + "' where pin = '"+ pinnumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				
				setVisible(true);
				new Transactions(rpin).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
		
	}

	public static void main(String[] args) {
	
		new PinChange("").setVisible(true);

	}

}
