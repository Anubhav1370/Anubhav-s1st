package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {
    splash(){

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2= i1.getImage().getScaledInstance(1000,550, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,1000,550);
        add(image);

        setSize(1000,550);
        setLocation(110, 50);
        setLayout(null);   //there is a default layout but we don't want the default one so we can set the value to null.
        setVisible(true); // by default the value of frame is false and its hidden.

        try{
            Thread.sleep(5000);
            setVisible(false);
            new login();

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new splash();
    }
}
