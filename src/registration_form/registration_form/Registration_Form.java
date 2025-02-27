package registration_form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration_Form extends JFrame implements ActionListener {
  JLabel l1, l2, l3, l4;
  JLabel img;

  JButton b1;
  ImageIcon i1;

  Registration_Form() {
    l1 = new JLabel("Welcome");

    l2 = new JLabel("to");

    l3 = new JLabel("Grocery");

    l4 = new JLabel("Shop");

    b1 = new JButton("Let's Go");
    Font largerFont1 = new Font(b1.getFont().getName(), Font.BOLD, 35);
    b1.setFont(largerFont1);
    i1 = new ImageIcon("trolley.jpg");

    // i1 = new ImageIcon("./trolley.jpg");
    img = new JLabel(i1);
    img.setBounds(10, 10, 200, 400);

    l1.setBounds(230, 100, 200, 45);

    Font largerFont = new Font(l1.getFont().getName(), Font.BOLD, 35);
    l1.setFont(largerFont);

    l2.setBounds(280, 150, 200, 45);
    Font large1 = new Font(l2.getFont().getName(), Font.BOLD, 35);
    l2.setFont(large1);

    l3.setBounds(240, 200, 200, 45);
    Font large2Font = new Font(l3.getFont().getName(), Font.BOLD, 35);
    l3.setFont(large2Font);

    l4.setBounds(265, 250, 200, 45);
    Font large3Font = new Font(l4.getFont().getName(), Font.BOLD, 35);
    l4.setFont(large3Font);

    b1.setBounds(150, 360, 200, 80);
    b1.setBackground(Color.GREEN);
    b1.addActionListener(this);

    add(l1, BorderLayout.EAST);

    add(l2, BorderLayout.EAST);

    add(l3, BorderLayout.EAST);

    add(l4, BorderLayout.EAST);

    add(b1, BorderLayout.EAST);
    add(img, BorderLayout.WEST);
    getContentPane().setBackground(Color.WHITE);

    setSize(500, 500);
    setLocation(500,200);
    setLayout(new BorderLayout(0, 200));
    setVisible(true);
    

  }
  public void actionPerformed(ActionEvent e)
  {
    this.dispose();
    login window=new login();
    window.setVisible(true);
  }

  public static void main(String[] args) {

    new Registration_Form();
  }

}
