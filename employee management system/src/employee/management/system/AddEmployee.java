package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tnum;
    JDateChooser tdob;
    JComboBox Ceducation;
    Random rand=new Random();
    int num=rand.nextInt(999999);

    JButton add,back;

    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));


        JLabel heading= new JLabel("Add Employee Details");
        heading.setBounds(300,30,500,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);


        JLabel empid= new JLabel("Unique emp id: ");
        empid.setBounds(40,100,200,30);
        empid.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(empid);
        tnum= new JLabel(" "+num+"");
        tnum.setBounds(150,100,200,30);
        tnum.setFont(new Font("CABRI(body)",Font.BOLD,15));
        tnum.setBackground(Color.GREEN);
        add(tnum);

        JLabel name= new JLabel("Name");
        name.setBounds(40,150,200,30);
        name.setFont(new Font("SEN_SERIF",Font.BOLD,15));
        add(name);
        tname = new JTextField();
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
        tdob = new JDateChooser();
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
        taadhar = new JTextField();
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

        String items[]= {"BBA","MBA","M.COM","B.COM","B.TECH","M.TECH","B.SC","M.SC","PHD","BCA","MCA","B.Arts","M.Arts"};
        Ceducation= new JComboBox(items);
        Ceducation.setBounds(560,350,150,30);
        add(Ceducation);

        add= new JButton("ADD");
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
            String name=tname.getText();
            String fname= tfname.getText();
            String dob= ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary= tsalary.getText();
            String email= temail.getText();
            String address= taddress.getText();
            String phone= tphone.getText();
            String adhar= taadhar.getText();
            String desig= tdesignation.getText();
            String edu= (String) Ceducation.getSelectedItem();
            String num= tnum.getText();


            try{
                conn c= new conn();
                String query= "insert into employe values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+edu+"','"+desig+"','"+adhar+"','"+num+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully!");
                setVisible(false);
                new main_class();

            }catch(Exception E){
                E.printStackTrace();

            }

        }else{
            setVisible(false);
            new main_class();
        }



    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
