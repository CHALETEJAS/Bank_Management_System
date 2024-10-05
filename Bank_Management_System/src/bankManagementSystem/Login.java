package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// The Login class extends JFrame and implements ActionListener to handle button clicks
public class Login extends JFrame implements ActionListener {
    
    // Declare buttons and text fields for login functionality
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    // Constructor to set up the login window
    Login() {
        setTitle("Automated_Teller_Machine");

        // Set the layout to null for absolute positioning
        setLayout(null);

        // Add the bank logo to the login window
        ImageIcon i1 = new ImageIcon("D:\\Tejas\\Project\\Bank_Management_System\\Stuff\\icons\\logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        // Add a welcome message to the login window
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        // Add a label and text field for entering the card number
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        // Add a label and password field for entering the PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        // Add and configure the SIGN IN button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
        
        // Add and configure the CLEAR button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        // Add and configure the SIGN UP button
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);
        
        // Set the background color of the content pane to white
        getContentPane().setBackground(Color.WHITE);

        // Set the size and location of the login window
        setSize(800, 500);
        setVisible(true);
        setLocation(500, 200);
    }
    
    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            // Clear the card number and PIN fields
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == login) {
           Conn conn = new Conn();
           String cardnumber = cardTextField.getText();
           String pinnumber = pinTextField.getText();
           String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
           try {
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()) {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
           } catch(Exception e){
               System.out.println(e);
           }
            
        } else if(ae.getSource() == signup) {
            // Handle signup action (implementation needed)
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    // Main method to create an instance of the Login class and display the login window
    public static void main(String[] args) {
        new Login();
    }
}
