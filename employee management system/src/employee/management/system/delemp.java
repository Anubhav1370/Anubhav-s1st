package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class delemp extends JFrame implements ActionListener  {

    JButton remove, back;

    Choice choiceempid;

    delemp(){

        JLabel head= new JLabel("Employee ID");
        head.setBounds(10,30,150,30);
        head.setFont(new Font("tahoma",Font.BOLD,20));
        add(head);

        choiceempid= new Choice();
        choiceempid.setBounds(180,35,200,30);
        add(choiceempid);
        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employe");
            while(resultSet.next()){
                choiceempid.add(resultSet.getString("empid"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname= new JLabel("Name");
        labelname.setBounds(10,100,100,30);
        labelname.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelname);
        JLabel textname= new JLabel();
        textname.setBounds(100,100,100,30);
        add(textname);

        JLabel labelphone= new JLabel("Phone");
        labelphone.setBounds(10,130,100,30);
        labelphone.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelphone);
        JLabel textphone= new JLabel();
        textphone.setBounds(100,130,100,30);
        add(textphone);

        JLabel labelemail= new JLabel("E-mail");
        labelemail.setBounds(10,160,100,30);
        labelemail.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelemail);
        JLabel textemail= new JLabel();
        textemail.setBounds(100,160,100,30);
        add(textemail);

        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employe where empid='"+choiceempid.getSelectedItem()+"' ");
            while(resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        choiceempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c= new conn();
                    ResultSet resultSet= c.statement.executeQuery("select * from employe where empid='"+choiceempid.getSelectedItem()+"' ");
                    while(resultSet.next()) {
                        textname.setText(resultSet.getString("name"));
                        textphone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));

                    }
                }catch(Exception E){
                    E.printStackTrace();

                }
            }
        });

        remove = new JButton("Remove");
        remove.setBounds(60,210,100,30);
        remove.addActionListener(this);
        add(remove);

        back= new JButton("Back");
        back.setBounds(180,210,100,30);
        back.addActionListener(this);
        add(back);

        setSize(600,300);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== remove){
            try{
                conn c= new conn();
                String query=" delete from employe where empid= '"+choiceempid.getSelectedItem()+"'  ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Record Deleted successfully!");
                setVisible(false);
                new main_class();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
            new main_class();
        }


    }

    public static void main(String[] args) {
        new delemp();
    }
}
