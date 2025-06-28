package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField  textAddress, textPhone, textEmail, textAadhar, textCourse, textBranch;
    JLabel empText;
    JButton submit, cancel;
    Choice cEMPID;

    UpdateTeacher(){

        getContentPane().setBackground(new Color(230,230,230));

        JLabel heading =  new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empID = new JLabel("Select Employee ID");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif", Font.PLAIN,20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250,100,200,20);
        add(cEMPID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from teacher");
            while (rs.next()){
                cEMPID.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fName = new JLabel("Father Name");
        fName.setBounds(400,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);

        JLabel textFather = new JLabel();
        textFather.setBounds(600,150,150,30);
        add(textFather);

        JLabel EMPIDD = new JLabel("Employee ID");
        EMPIDD.setBounds(50,200,200,30);
        EMPIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EMPIDD);

        empText = new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dobdob = new JLabel();
        dobdob.setBounds(600,200,150,30);
        add(dobdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        JLabel phone = new JLabel("Contact number");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        JLabel email = new JLabel("Email ID");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200,300,150,30);
        add(textEmail);

        JLabel aadharNo = new JLabel("Aadhar Number");
        aadharNo.setBounds(400,300,200,30);
        aadharNo.setFont(new Font("serif",Font.BOLD,20));
        add(aadharNo);

        JLabel textAadhar = new JLabel();
        textAadhar.setBounds(600,300,150,30);
        add(textAadhar);

        JLabel M10 = new JLabel("10th Marks (%)");
        M10.setBounds(50,350,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        JLabel textM10 = new JLabel();
        textM10.setBounds(200,350,150,30);
        add(textM10);

        JLabel M12 = new JLabel("12th Marks (%)");
        M12.setBounds(400,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(600,350,150,30);
        add(textM12);

        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textCourse = new JTextField();
        textCourse.setBounds(200,400,150,30);
        add(textCourse);

        JLabel Department = new JLabel("Department");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textBranch = new JTextField();
        textBranch.setBounds(600,400,150,30);
        add(textBranch);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where empId = '"+cEMPID.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_x"));
                textM12.setText(resultSet.getString("class_xii"));
                textAadhar.setText(resultSet.getString("aadhar"));
                empText.setText(resultSet.getString("empId"));
                textCourse.setText(resultSet.getString("education"));
                textBranch.setText(resultSet.getString("department"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empId = '"+cEMPID.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        dobdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_x"));
                        textM12.setText(resultSet.getString("class_xii"));
                        textAadhar.setText(resultSet.getString("aadhar"));
                        empText.setText(resultSet.getString("empId"));
                        textCourse.setText(resultSet.getString("education"));
                        textBranch.setText(resultSet.getString("department"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String empid = empText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String course = textCourse.getText();
            String branch = textBranch.getText();
            try {
                String Q = "update teacher set address = '"+address+"', phone = '"+phone+"', " +
                        "email = '"+email+"', education = '"+course+"', department = '"+branch+"' " +
                        "where empId = '"+empid+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(Q);

                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
