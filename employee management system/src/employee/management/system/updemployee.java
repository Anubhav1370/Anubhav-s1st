package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updemployee extends JFrame implements ActionListener {

    JTextField teducation,tfname,taddress,tphone,temail,tsalary,tdesignation;
    JLabel tnum;
    JButton add, back;
    String number;

    updemployee(String number){

        this.number=number;

        getContentPane().setBackground(new Color(163,255,188));


        JLabel heading= new JLabel("Add Employee Details");
        heading.setBounds(300,30,500,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);


        JLabel empid= new JLabel("Unique emp id: ");
        empid.setBounds(40,100,200,30);
        empid.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(empid);
        tnum= new JLabel();
        tnum.setBounds(150,100,200,30);
        tnum.setFont(new Font("CABRI(body)",Font.BOLD,15));
        tnum.setBackground(Color.GREEN);
        add(tnum);

        JLabel name= new JLabel("Name");
        name.setBounds(40,150,200,30);
        name.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(name);
        JLabel tname = new JLabel();
        tname.setBounds(150,150,150,30);
        add(tname);

        JLabel fname= new JLabel("Fathers Name");
        fname.setBounds(40,200,200,30);
        fname.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(fname);
        tfname = new JTextField();
        tfname.setBounds(150,200,150,30);
        add(tfname);

        JLabel dob= new JLabel("DOB");
        dob.setBounds(40,250,200,30);
        dob.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(dob);
         JLabel tdob = new JLabel();
        tdob.setBounds(150,250,150,30);
        add(tdob);

        JLabel phone= new JLabel("Phone no.");
        phone.setBounds(40,300,200,30);
        phone.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(phone);
        tphone = new JTextField();
        tphone.setBounds(150,300,150,30);
        add(tphone);


        JLabel adress= new JLabel("Address");
        adress.setBounds(40,350,200,30);
        adress.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(adress);
        taddress = new JTextField();
        taddress.setBounds(150,350,150,30);
        add(taddress);


        JLabel eemail= new JLabel("Email");
        eemail.setBounds(450,150,200,30);
        eemail.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(eemail);
        temail = new JTextField();
        temail.setBounds(560,150,150,30);
        add(temail);

        JLabel aadhar= new JLabel("Aadhar No.");
        aadhar.setBounds(450,200,200,30);
        aadhar.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(aadhar);
        JLabel taadhar = new JLabel();
        taadhar.setBounds(560,200,150,30);
        add(taadhar);

        JLabel salary= new JLabel("Salary");
        salary.setBounds(450,250,200,30);
        salary.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(560,250,150,30);
        add(tsalary);

        JLabel desig= new JLabel("Designation");
        desig.setBounds(450,300,200,30);
        desig.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(desig);
        tdesignation = new JTextField();
        tdesignation.setBounds(560,300,150,30);
        add(tdesignation);

        JLabel education= new JLabel("Degree");
        education.setBounds(450,350,150,30);
        education.setFont(new Font("Sen_SERIF",Font.BOLD,15));
        add(education);
         teducation= new JTextField();
        teducation.setBounds(560,350,150,30);
        add(teducation);

        try{
            conn c=new conn();
            String query= "select * from employe where empid='"+number+"'";
            ResultSet resultSet= c.statement.executeQuery(query);
            while(resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                taadhar.setText(resultSet.getString("aadhar"));
                tsalary.setText(resultSet.getString("salary"));
                temail.setText(resultSet.getString("email"));
                tphone.setText(resultSet.getString("phone"));
                teducation.setText(resultSet.getString("education"));
                tdesignation.setText(resultSet.getString("designation"));
                empid.setText(resultSet.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        add= new JButton("Update");
        add.setBounds(300,450,100,30);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(450,450,100,30);
        back.addActionListener(this);
        add(back);



        setLayout(null);
        setSize(900,550);
        setLocation(300,80);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){

            String fname= tfname.getText();
            String salary= tsalary.getText();
            String email= temail.getText();
            String address= taddress.getText();
            String phone= tphone.getText();
            String desig= tdesignation.getText();
            String edu= teducation.getText();


            try{
                conn c= new conn();
                String query="update employe set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+edu+"',designation='"+desig+"' where empid='"+number+"'  ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new main_class();

            }catch(Exception E){
                E.printStackTrace();
            }


        }else {
            setVisible(false);
            new view_employee();
        }

    }

    public static void main(String[] args) {
        new updemployee("");
    }
}
