package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login , back;

    login(){
        JLabel username= new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername= new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password= new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword= new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login= new JButton("Login");
        login.setBounds(80,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.CYAN);
        login.addActionListener(this);
        add(login);

        back= new JButton("Back");
        back.setBounds(200,140,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.CYAN);
        back.addActionListener(this);
        add(back);


        ImageIcon ia= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image ib= ia.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon ic= new ImageIcon(ib);
        JLabel imge= new JLabel(ic);
        imge.setBounds(350,0,600,300);
        add(imge);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2= i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,250);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            try{
                String username= tusername.getText();
                String password= tpassword.getText();

                conn conn= new conn();

                String query= " select * from login where username='"+username+"' and password='"+password+"'";
                ResultSet resultset = conn.statement.executeQuery(query);

                if(resultset.next()){
                    setVisible(false);
                    new main_class();

                }else{
                    JOptionPane.showMessageDialog(null, "wrong username or password");
                }

            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            System.exit(7);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
