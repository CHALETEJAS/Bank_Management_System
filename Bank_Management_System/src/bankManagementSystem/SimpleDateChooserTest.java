package bankManagementSystem;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

public class SimpleDateChooserTest extends JFrame {

    public SimpleDateChooserTest() {
        setLayout(null);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(50, 50, 200, 30);
        add(dateChooser);

        setSize(300, 200);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDateChooserTest();
    }
}
