package PrezentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import BusinessLayer.User;

public class RegistrationForm extends JDialog{

    JFrame main;
    Container mainCont;
    JPanel panel1;

   JTextField nameF, emailF, phoneF, adressF;
   JPasswordField passF, confPassF;
   JLabel nameL, emailL, phoneL, adressL, passL, confPassL;
   JButton registerBtn, cancelBtn;

    public RegistrationForm(){

        main = new JFrame("Main Registration Form");

        {
            mainCont = main.getContentPane();
            mainCont.setBackground(Color.white);
            mainCont.setVisible(true);
        }
        {

            panel1 = new JPanel();
            panel1.setBounds(60, 30, 450, 600);
            panel1.setBackground(Color.getHSBColor((float) 0.48, (float) 0.286,(float)0.933));
        }
        {
            main.setVisible(true);
            main.setLayout(null);
        }
        {
            mainCont.add(panel1);
            mainCont.setSize(550, 300);
            main.setSize(600, 700);
            mainCont.setVisible(true);
            mainCont.setBackground(Color.getHSBColor((float) 0.48, (float) 0.286,(float)0.933));
        }

        {
            registerBtn = new JButton("Register");
            registerBtn.setPreferredSize(new Dimension(170, 40));
            cancelBtn = new JButton("Cancel");
            cancelBtn.setPreferredSize(new Dimension(170, 40));

            nameL=new JLabel("Username: ");
            nameL.setPreferredSize(new Dimension(190,20));
            nameL.setFont(new Font("Arial", Font.PLAIN, 20));

            nameF=new JTextField();
            nameF.setPreferredSize(new Dimension(250,30));

            emailL=new JLabel("E-mail: ");
            emailL.setPreferredSize(new Dimension(190,20));
            emailL.setFont(new Font("Arial", Font.PLAIN, 20));

            emailF=new JTextField();
            emailF.setPreferredSize(new Dimension(250,30));

            phoneL=new JLabel("Phone: ");
            phoneL.setPreferredSize(new Dimension(190,20));
            phoneL.setFont(new Font("Arial", Font.PLAIN, 20));

            phoneF=new JTextField();
            phoneF.setPreferredSize(new Dimension(250,30));

            adressL=new JLabel("Address: ");
            adressL.setPreferredSize(new Dimension(190,20));
            adressL.setFont(new Font("Arial", Font.PLAIN, 20));

            adressF=new JTextField();
            adressF.setPreferredSize(new Dimension(250,30));

            passL=new JLabel("Password: ");
            passL.setPreferredSize(new Dimension(190,20));
            passL.setFont(new Font("Arial", Font.PLAIN, 20));

            passF=new JPasswordField();
            passF.setPreferredSize(new Dimension(250,30));


            confPassL=new JLabel("Confirm Password: ");
            confPassL.setPreferredSize(new Dimension(190,20));
            confPassL.setFont(new Font("Arial", Font.PLAIN, 20));

            confPassF=new JPasswordField();
            confPassF.setPreferredSize(new Dimension(250,30));

            panel1.add(nameL);
            panel1.add(nameF);
            panel1.add(emailL);
            panel1.add(emailF);
            panel1.add(phoneL);
            panel1.add(phoneF);
            panel1.add(adressL);
            panel1.add(adressF);
            panel1.add(passL);
            panel1.add(passF);
            panel1.add(confPassL);
            panel1.add(confPassF);
            panel1.add(registerBtn);
            panel1.add(cancelBtn);

            main.setVisible(true);

        }
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
            }
        });



    }

    private void registerUser() {
        String name = nameF.getText();
        String email = emailF.getText();
        String phone = phoneF.getText();
        String address = adressF.getText();
        String password = String.valueOf(passF.getPassword());
        String confirmPassword = String.valueOf(confPassF.getPassword());

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(name, email, phone, address, password);
        if (user != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addUserToDatabase(String name, String email, String phone, String address, String password) {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
        final String USERNAME = "root";
        final String PASSWORD = "Clau_2001";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name, email, phone, address, password) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, password);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.address = address;
                user.password = password;
            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm();
        User user = myForm.user;
        if (user != null) {
            System.out.println("Successful registration of: " + user.name);
        }
        else {
            System.out.println("Registration canceled");
        }
    }
}
