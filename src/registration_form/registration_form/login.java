package registration_form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame {

    JLabel l1, l2;
    JTextField t1;
    JButton loginButton;
    JPasswordField t2;

    login() {
        setLayout(null);
        l1 = new JLabel("Enter Username");
        l1.setBounds(140, 50, 100, 40);
        t1 = new JTextField();
        t1.setBounds(120, 100, 150, 40);

        l2 = new JLabel("Enter Password");
        l2.setBounds(140, 150, 100, 40);

        t2 = new JPasswordField();
        t2.setBounds(120, 200, 150, 40);
        setSize(400, 400);
        setLocation(500,200);

        loginButton = new JButton("Login");
        loginButton.setBounds(140, 250, 100, 40);
        loginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String username = t1.getText();
                String password = new String(t2.getPassword());
        
                final String url = "jdbc:mysql://localhost:3306/grocery";
                final String uname = "root";
                final String pass = "admin@123";
        
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
        
                try {
                    Connection con = DriverManager.getConnection(url, uname, pass);
                    Statement stmt = con.createStatement();
                    String query = String.format("INSERT INTO login(name, password) VALUES('%s', '%s')", username, password);
                    stmt.executeUpdate(query);
        
                    
                    stmt.close();
                    con.close();
                } catch (SQLException exception) {
                    System.out.println(exception);
                }
                
               
                FoodOrder window = new FoodOrder();
                window.setVisible(true);
            }
        });
        

        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(loginButton);
        setVisible(true);

    }

    public static void main(String[] args) {
        new login();
    }
}