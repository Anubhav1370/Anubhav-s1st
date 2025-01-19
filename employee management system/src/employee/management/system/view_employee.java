package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_employee extends JFrame implements ActionListener {
        Choice chemp;
        JTable table;
        JButton sea, print ,back, update;

    view_employee(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search= new JLabel("Search by Employee id:");
        search.setBounds(20,20,150,20);
        add(search);

        chemp = new Choice();
        chemp.setBounds(180,20,150,20);
        add(chemp);

        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from employe");
            while(resultSet.next()){
                chemp.add(resultSet.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c= new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employe");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        sea = new JButton("Search");
        sea.setBounds(20,70,80,20);
        sea.addActionListener(this);
        add(sea);

        update = new JButton("Update");
        update.setBounds(120,70,80,20);
        update.addActionListener(this);
        add(update);

        print = new JButton("Print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,600);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== sea){
            String query= "select * from employe where empid = '"+chemp.getSelectedItem()+"' ";

            try{
                conn c = new conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));


            }catch(Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()== print){
            try{
                table.print();

            }catch(Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()== update){
            setVisible(false);
            new updemployee(chemp.getSelectedItem());

        }else{
            setVisible(false);
            new main_class();
        }

    }

    public static void main(String[] args) {
        new view_employee();

    }
}
