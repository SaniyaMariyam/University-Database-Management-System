package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/university_logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,0,300,200);
        add(img);

        JLabel heading = new JLabel("<html> Ramaiah University of </br>Applied Sciences</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("RUAS");
        name.setBounds(60,260,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        JLabel contact = new JLabel("ramaiahuniversity@gmail.com");
        contact.setBounds(60,320,550,40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(contact);

        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(new Color(130,130,130));
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
