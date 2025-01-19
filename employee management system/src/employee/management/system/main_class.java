package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame {
    main_class(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2= i1.getImage().getScaledInstance(920, 500, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,920,500);
        add(img);

        JLabel heading= new JLabel("Employee Management System");
        heading.setBounds(260,120,400,50);
        heading.setFont(new Font("Times New Roman",Font.BOLD,25));
        img.add(heading); //so that the heading is visible over the image

        JButton add= new JButton("ADD DATA");
        add.setBounds(240,170,120,30);
        add.setForeground(Color.cyan);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);

            }
        });
        img.add(add);

        JButton delete= new JButton("DELETE DATA");
        delete.setBounds(340,270,120,30);
        delete.setForeground(Color.cyan);
        delete.setBackground(Color.BLACK);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new delemp();

            }
        });
        img.add(delete);

        JButton view= new JButton("VIEW DATA");
        view.setBounds(440,170,120,30);
        view.setForeground(Color.cyan);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_employee();
                setVisible(false);

            }
        });
        img.add(view);

        setSize(900,500);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new main_class();
    }
}
