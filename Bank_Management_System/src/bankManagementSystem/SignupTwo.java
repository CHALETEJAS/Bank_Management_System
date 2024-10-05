package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField nameTextField, fnameTextField, emailTextField, aadharNumTextField, panNumberTextField, senoirTextField, pinTextField; 
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    
    SignupTwo(String formno) {
        
    	this.formno = formno;
        setLayout(null);
       
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[]= {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[]= {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        
        JLabel income1 = new JLabel("Income: ");
        income1.setFont(new Font("Raleway", Font.BOLD, 22));
        income1.setBounds(100, 240, 200, 30);
        add(income1);
        
        String valIncome[]= {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel education1 = new JLabel("Educational ");
        education1.setFont(new Font("Raleway", Font.BOLD, 22));
        education1.setBounds(100, 290, 200, 30);
        add(education1);
        
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        String educationValues[]= {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel occupation1 = new JLabel("Occupation: ");
        occupation1.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation1.setBounds(100, 390, 200, 30);
        add(occupation1);
        
        String occupationValues[]= {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel panNumber = new JLabel("Pan Number: ");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        panNumber.setBounds(100, 440, 200, 30);
        add(panNumber);
        
        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panNumberTextField.setBounds(300, 440, 400, 30);
        add(panNumberTextField);
        
        JLabel aadharNum = new JLabel("Aadhar Number: ");
        aadharNum.setFont(new Font("Raleway", Font.BOLD, 22));
        aadharNum.setBounds(100, 490, 200, 30);
        add(aadharNum);
        
        aadharNumTextField = new JTextField();
        aadharNumTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharNumTextField.setBounds(300, 490, 400, 30);
        add(aadharNumTextField);
        
        JLabel senoir = new JLabel("Senior Citizen: ");
        senoir.setFont(new Font("Raleway", Font.BOLD, 22));
        senoir.setBounds(100, 540, 200, 30);
        add(senoir);
        
        syes = new JRadioButton("Yes");
        syes.setBackground(Color.white);
        syes.setBounds(300, 540, 200, 30);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBackground(Color.white);
        sno.setBounds(500, 540, 200, 30);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.white);
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBackground(Color.white);
        eno.setBounds(500, 590, 100, 30);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
       
//        String formno = "" + random; // random is long
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
        	seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
        	seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if (eyes.isSelected()) {
        	existingaccount = "Yes";
        } else if(eno.isSelected()) {
        	existingaccount = "No";
        }
        
        
        String span = panNumberTextField.getText();
        String saadhar = aadharNumTextField.getText();
       
        
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount  + "')";
                c.s.executeUpdate(query);
                
                // Signup3 Object
        } catch (Exception e) {
            System.out.println(e);
        }        
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
