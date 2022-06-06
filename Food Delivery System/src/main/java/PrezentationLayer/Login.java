package PrezentationLayer;


import BusinessLayer.DeliveryService;
import BusinessLayer.User;
import BusinessLayer.Order;
import java.util.Date;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class Login extends JDialog implements Observer {

    static InterfataAngajat a;

    JFrame main;
    Container mainCont;
    JPanel panel1;
    JButton adminBtn, clientBtn, angajatBtn, newClient;
    JLabel userL, passL, clientL;
    JTextField userF;
    JPasswordField passF;
    int idClient;
    int idAdmin;

    public Login(int id){

    }

    public Login(){

        main = new JFrame("Main Login System");

        {
            mainCont = main.getContentPane();
            mainCont.setBackground(Color.white);
            mainCont.setVisible(true);
        }
        {
            panel1 = new JPanel();
            panel1.setBounds(10, 10, 320, 200);
            panel1.setBackground(Color.white);
        }
        {
            main.setVisible(true);
            main.setLayout(null);
        }
        {
            mainCont.add(panel1);
            mainCont.setSize(550, 300);
            main.setSize(380, 220);
            mainCont.setVisible(true);
        }
        {
            adminBtn = new JButton("Admin");
            adminBtn.setPreferredSize(new Dimension(100, 20));
            clientBtn = new JButton("Client");
            clientBtn.setPreferredSize(new Dimension(100, 20));
            angajatBtn = new JButton("Angajat");
            angajatBtn.setPreferredSize(new Dimension(100, 20));
            newClient = new JButton("Create Account");
            newClient.setPreferredSize(new Dimension(130, 20));

            userL=new JLabel("Username: ");
            userL.setPreferredSize(new Dimension(100,20));

            userF=new JTextField();
            userF.setPreferredSize(new Dimension(150,20));

            passL=new JLabel("Password: ");
            passL.setPreferredSize(new Dimension(100,20));

            passF=new JPasswordField();
            passF.setPreferredSize(new Dimension(150,20));

            clientL=new JLabel("New Client? Register Here");
            clientL.setPreferredSize(new Dimension(170,20));



            panel1.add(userL);
            panel1.add(userF);

            panel1.add(passL);
            panel1.add(passF);

            panel1.add(adminBtn);
            panel1.add(clientBtn);
            panel1.add(angajatBtn);

            panel1.add(clientL);
            panel1.add(newClient);

            main.setVisible(true);

        }
        {//ActionListener for main menu
            newClient.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    RegistrationForm myForm = new RegistrationForm();
                    User user = myForm.user;
                    if (user != null) {
                        System.out.println("Successful registration of: " + user.name);
                    }
                    else {
                        System.out.println("Registration canceled");
                    }
                }

            });
        }

        {//ActionListener for main menu
            clientBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    String email = userF.getText();
                    String password = String.valueOf(passF.getPassword());

                    user = getAuthenticatedUser(email, password);

                    if (user != null) {
                       InterfataClient i = new InterfataClient(idClient);
                    }
                    else {
                        JOptionPane.showMessageDialog(Login.this,
                                "Email or Password Invalid",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }

            });
        }

        {//ActionListener for main menu
            adminBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    String email = userF.getText();
                    String password = String.valueOf(passF.getPassword());

                    user = getAuthenticatedAdmin(email, password);

                    if (user != null) {
                        Interfata c = new Interfata();
                    } else {
                        JOptionPane.showMessageDialog(Login.this,
                                "Email or Password Invalid",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    //Deserializez Orders
                    String line= "";
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("Orders.txt"));
                        while((line = br.readLine()) != null){

                            System.out.println("Am citit ceva!");
                            String [] values = line.split(",");
                            ////!!!
                            ////DE vazut ce id pun
                            int id = Integer.parseInt(values[0]);
                            int idClient = Integer.parseInt(values[1]);
                            int year = Integer.parseInt(values[2]);
                            int month = Integer.parseInt(values[3]);
                            int day = Integer.parseInt(values[4]);


                            Date d = new Date(year, month,day, 3, 2);
                            Order o = new Order(id, idClient, d);
                            System.out.println(o.toString());
                            DeliveryService.addComanda(o);
                        }
                    }catch(Exception ex){

                        System.out.println("EEE"  +ex);
                    }





                }

            });

        }

        {//ActionListener for main menu
            angajatBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    String email = userF.getText();
                    String password = String.valueOf(passF.getPassword());

                    user = getAuthenticatedAngajat(email, password);

                    if (user != null) {
                        a = new InterfataAngajat();
                        System.out.println("Angajat" + a);
                    } else {
                        JOptionPane.showMessageDialog(Login.this,
                                "Email or Password Invalid",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }

            });
        }
    }

    public User user;
    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
        final String USERNAME = "root";
        final String PASSWORD = "Clau_2001";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                idClient = Integer.parseInt(resultSet.getString("id"));
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }

    private User getAuthenticatedAdmin(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
        final String USERNAME = "root";
        final String PASSWORD = "Clau_2001";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM admins WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                idAdmin = Integer.parseInt(resultSet.getString("id"));
                user.name = resultSet.getString("username");
                user.email = resultSet.getString("username");
                user.phone = "0000000";
                user.address = "Cluj";
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }

    private User getAuthenticatedAngajat(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
        final String USERNAME = "root";
        final String PASSWORD = "Clau_2001";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM angajat WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                idAdmin = Integer.parseInt(resultSet.getString("id"));
                user.name = resultSet.getString("username");
                user.email = resultSet.getString("username");
                user.phone = "0000000";
                user.address = "Cluj";
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }

    public static void main(String args[]){

        new Login();

    }

    public static void addSmth(){
        DeliveryService d = new DeliveryService();
        d.addObserver(new Login(0));
        d.nofificare();
    }

    @Override
    public void update(Observable o, Object arg) {

        a.setNotificare("S-a inserat o comnda!!\n");

    }
}
