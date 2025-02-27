package registration_form;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FoodOrder extends JFrame implements ActionListener {
    JLabel l, orderno, c1l1, c1l2, c1l3, c1l4, c1l5,
            c2l1, c2l2, c2l3, c2l4, c2l5;
    JCheckBox c1, c2, c3, c4, c5;
    JCheckBox c2ch1, c2ch2, c2ch3, c2ch4, c2ch5,
            c3ch1, c3ch2, c3ch3, c3ch4, c3ch5;
    JTextField c1t1, c1t2, c1t3, c1t4, c1t5;
    DefaultTableModel model;
    JTable t1;
    JButton b;
    int randomno;

    FoodOrder() {

        l = new JLabel("Pokemon Grocery Shop");
        l.setFont(new Font("Protest Riot", Font.BOLD, 30));
        l.setBounds(50, 50, 500, 50);
        l.setForeground(Color.BLUE);

        model = new DefaultTableModel();
        t1 = new JTable(model);
        model.addColumn("Product");
        model.addColumn("Quantity (kg)");
        model.addColumn("Price");

        int min = 1000;
        int max = 10000;
        Random r = new Random();
        randomno = r.nextInt(max + 1 - min) + min;
        orderno = new JLabel("Order No : " + randomno);
        orderno.setFont(new Font("Protest Riot", Font.BOLD, 20));
        orderno.setBounds(650, 70, 200, 50);
        orderno.setForeground(Color.BLUE);

        c1 = new JCheckBox("Rice  (Rs.70 per kg)");
        c2 = new JCheckBox("Dall  (Rs.90 per kg)");
        c3 = new JCheckBox("Flour (Rs.40 per kg)");
        c4 = new JCheckBox("Sugar (Rs.40 per kg)");
        c5 = new JCheckBox("Tea  (Rs.200 per kg)");
        c5.setBounds(100, 350, 150, 20);
        c4.setBounds(100, 300, 150, 20);
        c3.setBounds(100, 250, 150, 20);
        c2.setBounds(100, 200, 150, 20);
        c1.setBounds(100, 150, 150, 20);

        c1t1 = new JTextField(2);
        c1t2 = new JTextField(2);
        c1t3 = new JTextField(2);
        c1t4 = new JTextField(2);
        c1t5 = new JTextField(2);
        c1t5.setBounds(250, 350, 50, 20);
        c1t4.setBounds(250, 300, 50, 20);
        c1t3.setBounds(250, 250, 50, 20);
        c1t2.setBounds(250, 200, 50, 20);
        c1t1.setBounds(250, 150, 50, 20);

        c1l1 = new JLabel("Kg");
        c1l2 = new JLabel("Kg");
        c1l3 = new JLabel("Kg");
        c1l4 = new JLabel("Kg");
        c1l5 = new JLabel("Kg");

        c1l5.setBounds(310, 350, 30, 20);
        c1l4.setBounds(310, 300, 30, 20);
        c1l3.setBounds(310, 250, 30, 20);
        c1l2.setBounds(310, 200, 30, 20);
        c1l1.setBounds(310, 150, 30, 20);

        c2ch1 = new JCheckBox("Detol ( 100 ml Rs.100)");
        c2ch2 = new JCheckBox("Lifeboy Soap(Rs.50)");
        c2ch3 = new JCheckBox("Dove Shampoo(1L Rs.700)");
        c2ch4 = new JCheckBox("Nestle Maggi(100g Rs.80)");
        c2ch5 = new JCheckBox("Cadbury (50g Rs.100)");
        c2ch5.setBounds(360, 350, 150, 20);
        c2ch4.setBounds(360, 300, 180, 20);
        c2ch3.setBounds(360, 250, 200, 20);
        c2ch2.setBounds(360, 200, 150, 20);
        c2ch1.setBounds(360, 150, 150, 20);

        c3ch1 = new JCheckBox("Refined Oil (1L Rs.150)");
        c3ch2 = new JCheckBox("Mustard Oil (1L Rs.200)");
        c3ch3 = new JCheckBox("Sabji Mashala (100g Rs.50)");
        c3ch4 = new JCheckBox("Maggi Mashala (100g Rs.100)");
        c3ch5 = new JCheckBox("Tata Salt (1kg Rs.30)");
        c3ch5.setBounds(600, 350, 200, 20);
        c3ch4.setBounds(600, 300, 200, 20);
        c3ch3.setBounds(600, 250, 200, 20);
        c3ch2.setBounds(600, 200, 200, 20);
        c3ch1.setBounds(600, 150, 200, 20);

        b = new JButton("Buy");
        b.setBounds(700, 400, 100, 50);
        b.setFont(new Font("Protest Riot", Font.BOLD, 30));
        b.setForeground(Color.BLUE);
        b.addActionListener(this);

        add(l);
        add(orderno);
        add(c1l1);
        add(c1l2);
        add(c1l3);
        add(c1l4);
        add(c1l5);
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(c1t1);
        add(c1t2);
        add(c1t3);
        add(c1t4);
        add(c1t5);
        add(c2ch1);
        add(c2ch2);
        add(c2ch3);
        add(c2ch4);
        add(c2ch5);
        add(c3ch1);
        add(c3ch2);
        add(c3ch3);
        add(c3ch4);
        add(c3ch5);
        add(b);

        JScrollPane scrollPane = new JScrollPane(t1);
        scrollPane.setBounds(100, 500, 720, 200);
        add(scrollPane);

        // getContentPane().setBackground(Color.white);
        setSize(950, 750);
        setLayout(null);
        setVisible(true);
        setLocation(250, 50);
    }

    public void actionPerformed(ActionEvent e) {

        float amount = 0;
        if (c1.isSelected()) {
            c1t1.requestFocusInWindow();
            int price = 70;
            float weight = Float.parseFloat(c1t1.getText());
            float totalPrice = price * weight;
            amount += totalPrice;
            model.addRow(new Object[] { "Rice", weight, totalPrice });

        }

        if (c2.isSelected()) {
            int price = 90;
            float weight = Float.parseFloat(c1t2.getText());
            float totalPrice = price * weight;
            amount += totalPrice;
            model.addRow(new Object[] { "Dall", weight, totalPrice });

        }

        if (c3.isSelected()) {
            int price = 40;
            float weight = Float.parseFloat(c1t3.getText());
            float totalPrice = price * weight;
            amount += totalPrice;
            model.addRow(new Object[] { "Flour", weight, totalPrice });

        }
        if (c4.isSelected()) {
            int price = 40;
            float weight = Float.parseFloat(c1t4.getText());
            float totalPrice = price * weight;
            amount += totalPrice;
            model.addRow(new Object[] { "Sugar", weight, totalPrice });

        }
        if (c5.isSelected()) {
            int price = 200;
            float weight = Float.parseFloat(c1t5.getText());
            float totalPrice = price * weight;
            amount += totalPrice;
            model.addRow(new Object[] { "Tea", weight, totalPrice });

        }
        if (c2ch1.isSelected()) {
            int price = 100;

            model.addRow(new Object[] { "Detol", "100ml", price });

        }
        if (c2ch2.isSelected()) {
            int price = 50;
            amount += price;
            model.addRow(new Object[] { "Lifeboy Soap", "-", price });

        }
        if (c2ch3.isSelected()) {
            int price = 700;
            amount += price;
            model.addRow(new Object[] { "Dove Shampoo", "1L", price });

        }
        if (c2ch4.isSelected()) {
            int price = 80;
            amount += price;
            model.addRow(new Object[] { "Nestle Maggi", "100g", price });

        }
        if (c2ch5.isSelected()) {
            int price = 100;
            amount += price;
            model.addRow(new Object[] { "Cadbury", "50g", price });

        }

        if (c3ch1.isSelected()) {
            int price = 150;
            amount += price;
            model.addRow(new Object[] { "Refined Oil", "1L", price });

        }
        if (c3ch2.isSelected()) {
            int price = 200;
            amount += price;
            model.addRow(new Object[] { "Mustard Oil", "1L", price });

        }
        if (c3ch3.isSelected()) {
            int price = 50;
            amount += price;
            model.addRow(new Object[] { "Sabji Mashala", "100g", price });

        }
        if (c3ch4.isSelected()) {
            int price = 100;
            amount += price;
            model.addRow(new Object[] { "Maggi Mashala", "100g", price });

        }
        if (c3ch5.isSelected()) {
            int price = 30;
            amount += price;
            model.addRow(new Object[] { "Tata Salt", "1kg", price });

        }
        JOptionPane.showMessageDialog(this, "Sum : " + amount);

        // database code here
        int min = 1000;
        int max = 10000;
        Random r = new Random();
        randomno = r.nextInt( max - min + 1) + min;
        final String url = "jdbc:mysql://localhost:3306/fruitshop";
        final String username = "root";
        final String password = "admin@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = (Statement) con.createStatement();
            String query = String.format("insert into details(orderno,totalPurchase) values(%d,%f)", randomno, amount);
            stmt.executeUpdate(query);
        } catch (SQLException exception) {
            System.out.println(exception);
        }

    };

    public static void main(String[] args) {
        new FoodOrder();
    }

}
