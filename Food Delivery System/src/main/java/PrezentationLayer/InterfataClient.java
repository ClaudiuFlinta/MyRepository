package PrezentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Observer;
import java.util.StringTokenizer;

import BusinessLayer.*;
import BusinessLayer.Menu;
import BusinessLayer.MenuItem;

import java.util.ArrayList;
import java.util.stream.Collectors;
import static BusinessLayer.DeliveryService.addComanda;
import static BusinessLayer.Menu.*;
import static PrezentationLayer.Login.addSmth;

import static BusinessLayer.DeliveryService.comenzi;


public class InterfataClient {

    String recordUpdate2;

    JFrame mainF, searchF, orderF, viewF, viewOrderF;
    Container mainMenu, viewMenu, searchMenu, orderMenu, viewOrderMenu;
    JPanel panel1, panel2, mainPanel1, importPanel1, importPanel2, addPanel1, addPanel2, deletePanel1, deletePanel2, updatePanel1, updatePanel2, compositePanel1, compositePanel2, reportPanel1, reportPanel2, reportPanel3, reportPanel4;
    JButton  viewOrderBackBtn,viewBackBtn,searchBtn, searchBackBtn ,importBtn, addBackBtn, addBtn, deleteBackBtn, deleteBtn, updateSelectBtn, updateBackBtn, updateBtn, compositeAddBtn, compositeCreateBtn, compositeBackBtn;
    JTextArea searchMenuText, viewMenuText, orderMenuText, viewOrderMenuText;

    Order o;

    private int price =0;
    private int count = 0;

    //InterfataAngajat a = new InterfataAngajat();

    private static int id = 0;
    private int idClient;

    JButton buton1, buton2, buton3,buton4, orderBackBtn,orderAddBtn, orderCreateBtn;

    JLabel addIDL , orderIDL, orderAddedL, searchTitleL,searchRatingL,searchProteinL,searchCaloriesL, searchFatL,searchPriceL,searchSodiumL;
    JTextField orderAddedF, orderIDF, addTitleF, addRatingF, addProteinF ,addCaloriesF, addFatF, addSodiumF, addPriceF, updateIDF, compositeIDF, compositeAddedF, searchFT, searchTitleF, searchRatingF,searchProteinF,searchCaloriesF,searchFatF,searchPriceF,searchSodiumF;




    public InterfataClient(int idClient){

        this.idClient = idClient;

        mainF = new JFrame("Main Menu");
        viewF = new JFrame("View Menu");
        searchF = new JFrame("Search Menu");
        orderF = new JFrame("Create Order");
        viewOrderF = new JFrame("View Orders");


        {//--Containers

            //--Main Menu Container
            mainMenu = mainF.getContentPane();
            mainMenu.setBackground(Color.white);
            mainMenu.setVisible(true);
            //---
            //--Add Menu Container
            viewMenu = viewF.getContentPane();
            viewMenu.setBackground(Color.white);
            viewMenu.setVisible(true);

            searchMenu = searchF.getContentPane();
            searchMenu.setBackground(Color.white);
            searchMenu.setVisible(true);

            orderMenu = orderF.getContentPane();
            orderMenu.setBackground(Color.white);
            orderMenu.setVisible(true);

            viewOrderMenu = viewOrderF.getContentPane();
            viewOrderMenu.setBackground(Color.white);
            viewOrderMenu.setVisible(true);



        }

        {//--Setting Size of panel

            //--Main Menu Panel
            mainPanel1 = new JPanel();
            mainPanel1.setBounds(50, 50, 400, 500);
            mainPanel1.setBackground(Color.white);

            //--Add Menu Panel
            importPanel1 = new JPanel();
            importPanel1.setBounds(30, 30, 170, 200);
            importPanel1.setBackground(Color.white);

            importPanel2 = new JPanel();
            importPanel2.setBounds(250, 30, 720, 700);
            importPanel2.setBackground(Color.white);

            addPanel1 = new JPanel();
            addPanel1.setBounds(30, 30, 200, 400);
            addPanel1.setBackground(Color.white);

            addPanel2 = new JPanel();
            addPanel2.setBounds(400, 30, 720, 600);
            addPanel2.setBackground(Color.white);

            deletePanel1 = new JPanel();
            deletePanel1.setBounds(30, 30, 200, 600);
            deletePanel1.setBackground(Color.white);

            deletePanel2 = new JPanel();
            deletePanel2.setBounds(250,100,720,900);
            deletePanel2.setBackground(Color.white);

            panel1 = new JPanel();
            panel1.setBounds(30, 30, 200, 600);
            panel1.setBackground(Color.white);

            panel2 = new JPanel();
            panel2.setBounds(250,100,720,900);
            panel2.setBackground(Color.white);





        }

        {//--setting all frames visiblity to true

            mainF.setVisible(true);
            mainF.setLayout(null);

            viewF.setVisible(false);
            viewF.setLayout(null);

            searchF.setVisible(false);
            searchF.setLayout(null);

            orderF.setVisible(false);
            orderF.setLayout(null);

            viewOrderF.setVisible(false);
            viewOrderF.setLayout(null);


        }
        {//--setting frame and container size
            //--(main)setting frame and container size
            mainMenu.add(mainPanel1);
            mainMenu.setSize(550, 300);
            mainF.setSize(600, 600);
            mainMenu.setVisible(true);

            //---
            //--(add)setting frame and container size
            viewMenu.add(importPanel1);
            viewMenu.add(importPanel2);
            viewMenu.setSize(550, 300);
            viewF.setSize(1200, 900);
            viewMenu.setVisible(true);

            searchMenu.add(addPanel1);
            searchMenu.add(addPanel2);
            searchMenu.setSize(550, 300);
            searchF.setSize(1400, 900);
            searchMenu.setVisible(true);

            orderMenu.add(deletePanel1);
            orderMenu.add(deletePanel2);
            orderMenu.setSize(550, 300);
            orderF.setSize(1200, 900);
            orderMenu.setVisible(true);

            viewOrderMenu.add(panel1);
            viewOrderMenu.add(panel2);
            viewOrderMenu.setSize(550, 300);
            viewOrderF.setSize(1200, 900);
            viewOrderMenu.setVisible(true);


        }

        {//main page

            buton1 = new JButton("View Menu");
            buton1.setPreferredSize(new Dimension(150, 150));

            buton2 = new JButton("Search for item");
            buton2.setPreferredSize(new Dimension(150, 150));

            buton3 = new JButton("Create Order");
            buton3.setPreferredSize(new Dimension(150, 150));

            buton4 = new JButton("View Orders");
            buton4.setPreferredSize(new Dimension(150, 150));


            mainPanel1.add(buton1, BorderLayout.CENTER);
            mainPanel1.add(buton2, BorderLayout.CENTER);
            mainPanel1.add(buton3, BorderLayout.CENTER);
            mainPanel1.add(buton4, BorderLayout.CENTER);

            mainF.setVisible(true);
        }

        {//View Page
            viewBackBtn = new JButton("Back");
            viewBackBtn.setPreferredSize(new Dimension(80, 20));

            viewMenuText = new JTextArea(30, 60);
            viewMenuText.setPreferredSize(new Dimension(900, 15000));
            viewMenuText.setEditable(false);

            //---
            //----------------------------------------------------------------
            JScrollPane scrollView = new JScrollPane(viewMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            //----------------------------------------------------------------
            importPanel1.add(viewBackBtn, BorderLayout.NORTH);

            importPanel2.add(scrollView, BorderLayout.CENTER);

        }

        {//Search for Item

            searchTitleL=new JLabel("Title: ");
            searchTitleL.setPreferredSize(new Dimension(50,20));

            searchTitleF=new JTextField();
            searchTitleF.setPreferredSize(new Dimension(120,20));

            searchRatingL=new JLabel("Rating: ");
            searchRatingL.setPreferredSize(new Dimension(50,20));

            searchRatingF=new JTextField();
            searchRatingF.setPreferredSize(new Dimension(120,20));

            searchProteinL=new JLabel("Protein: ");
            searchProteinL.setPreferredSize(new Dimension(50,20));

            searchProteinF=new JTextField();
            searchProteinF.setPreferredSize(new Dimension(120,20));

            searchCaloriesL=new JLabel("Claories: ");
            searchCaloriesL.setPreferredSize(new Dimension(70,20));

            searchCaloriesF=new JTextField();
            searchCaloriesF.setPreferredSize(new Dimension(120,20));


            searchFatL=new JLabel("Fat: ");
            searchFatL.setPreferredSize(new Dimension(50,20));

            searchFatF=new JTextField();
            searchFatF.setPreferredSize(new Dimension(120,20));

            searchSodiumL=new JLabel("Sodium: ");
            searchCaloriesL.setPreferredSize(new Dimension(50,20));

            searchSodiumF=new JTextField();
            searchSodiumF.setPreferredSize(new Dimension(120,20));

            searchPriceL=new JLabel("Price: ");
            searchFatL.setPreferredSize(new Dimension(50,20));

            searchPriceF=new JTextField();
            searchPriceF.setPreferredSize(new Dimension(120,20));


            searchBtn = new JButton("Search");
            searchBtn.setPreferredSize(new Dimension(80, 20));

            searchBackBtn = new JButton("Back");
            searchBackBtn.setPreferredSize(new Dimension(80, 20));

            searchMenuText = new JTextArea(30, 60);
            searchMenuText.setPreferredSize(new Dimension(900, 15000));
            searchMenuText.setEditable(false);

            //---
            //----------------------------------------------------------------
            JScrollPane scrollView = new JScrollPane(searchMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            //----------------------------------------------------------------

            addPanel1.add(searchTitleL);
            addPanel1.add(searchTitleF);

            addPanel1.add(searchRatingL);
            addPanel1.add(searchRatingF);

            addPanel1.add(searchCaloriesL);
            addPanel1.add(searchCaloriesF);

            addPanel1.add(searchProteinL);
            addPanel1.add(searchProteinF);

            addPanel1.add(searchFatL);
            addPanel1.add(searchFatF);

            addPanel1.add(searchSodiumL);
            addPanel1.add(searchSodiumF);

            addPanel1.add(searchPriceL);
            addPanel1.add(searchPriceF);

            addPanel1.add(searchBtn);
            addPanel1.add(searchBackBtn);

            addPanel2.add(scrollView, BorderLayout.CENTER);



        }

        {//Create Order

            orderIDL=new JLabel("ID: ");
            orderIDL.setPreferredSize(new Dimension(50,20));

            orderIDF=new JTextField();
            orderIDF.setPreferredSize(new Dimension(120,20));

            orderAddedL=new JLabel("Added: ");
            orderAddedL.setPreferredSize(new Dimension(50,20));

            orderAddedF=new JTextField();
            orderAddedF.setPreferredSize(new Dimension(120,20));

            orderMenuText = new JTextArea(30,60);
            orderMenuText.setPreferredSize(new Dimension(900, 15000));
            orderMenuText.setEditable(false);

            JScrollPane scrollView = new JScrollPane(orderMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            orderBackBtn = new JButton("Back");
            orderBackBtn.setPreferredSize(new Dimension(80, 20));

            orderAddBtn = new JButton("Add");
            orderAddBtn.setPreferredSize(new Dimension(180, 20));

            orderCreateBtn = new JButton("Create");
            orderCreateBtn.setPreferredSize(new Dimension(80, 20));

            deletePanel1.add(orderIDL);
            deletePanel1.add(orderIDF);
            deletePanel1.add(orderAddBtn);
            deletePanel1.add(orderAddedL);
            deletePanel1.add(orderAddedF);
            deletePanel1.add(orderCreateBtn);
            deletePanel1.add(orderBackBtn);

            deletePanel2.add(scrollView, BorderLayout.CENTER);

        }

        {//View Orders



            viewOrderMenuText = new JTextArea(30,60);
            viewOrderMenuText.setPreferredSize(new Dimension(900, 15000));
            viewOrderMenuText.setEditable(false);

            JScrollPane scrollView = new JScrollPane(viewOrderMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            viewOrderBackBtn = new JButton("Back");
            viewOrderBackBtn.setPreferredSize(new Dimension(80, 20));


            panel1.add(viewOrderBackBtn);

            panel2.add(scrollView, BorderLayout.CENTER);

        }


        {//ActionListener for main menu
            orderBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    orderF.setVisible(false);
                    mainF.setVisible(true);


                }

            });
        }


        {//ActionListener for main menu
            viewBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    viewF.setVisible(false);
                    mainF.setVisible(true);

                }

            });
        }

        {//ActionListener for main menu
            searchBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    searchF.setVisible(false);
                    mainF.setVisible(true);



                }

            });
        }

        {
            searchBtn.addActionListener(new ActionListener()
            {
                //----------------------------------------------------------------
                public void actionPerformed(ActionEvent ae)
                {

                    searchMenuText.setText("");
                    System.out.println(menuList.size());

                    String title = searchTitleF.getText();
                    String rating = searchRatingF.getText();
                    String calories = searchCaloriesF.getText();
                    String protein = searchProteinF.getText();
                    String fat = searchFatF.getText();
                    String sodium = searchSodiumF.getText();
                    String price = searchPriceF.getText();

                    ArrayList<MenuItem> titles = new ArrayList<>();
                    ArrayList<MenuItem> prices = new ArrayList<>();
                    ArrayList<MenuItem> calorie = new ArrayList<>();
                    ArrayList<MenuItem> ratings = new ArrayList<>();
                    ArrayList<MenuItem> fats = new ArrayList<>();
                    ArrayList<MenuItem> sodiums = new ArrayList<>();
                    ArrayList<MenuItem> proteins = new ArrayList<>();


                    if(!searchTitleF.getText().isEmpty()){

                        titles = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getTitle().contains(searchTitleF.getText());}).collect(Collectors.toList());

                    }


                    if(!searchPriceF.getText().isEmpty()){

                        prices = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getPrice() == Double.parseDouble(price);}).collect(Collectors.toList());
                        if(!titles.isEmpty()) {
                            titles.retainAll(prices);
                        } else{
                            titles = prices;
                        }
                    }


                    if(!searchCaloriesF.getText().isEmpty()){

                        calorie = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getCalories() == Double.parseDouble(calories);}).collect(Collectors.toList());
                        if(!titles.isEmpty()) {
                            titles.retainAll(calorie);
                        } else{
                            titles = calorie;
                        }
                    }

                    if(!searchRatingF.getText().isEmpty()){

                        ratings = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getRating() == Double.parseDouble(rating);}).collect(Collectors.toList());
                        if(!titles.isEmpty()) {
                            titles.retainAll(ratings);
                        } else{
                            titles = ratings;
                        }
                    }

                    if(!searchProteinF.getText().isEmpty()){

                        proteins = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getProtein() == Double.parseDouble(protein);}).collect(Collectors.toList());
                        if(!titles.isEmpty()) {
                            titles.retainAll(proteins);
                        } else{
                            titles = proteins;
                        }
                    }

                    if(!searchFatF.getText().isEmpty()){

                        fats = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getFat() == Double.parseDouble(fat);}).collect(Collectors.toList());
                        if(!titles.isEmpty()) {
                            titles.retainAll(fats);
                        } else{
                            titles = fats;
                        }
                    }

                    if(!searchSodiumF.getText().isEmpty()){

                        sodiums = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem menuItem) -> {return menuItem.getSodium() == Double.parseDouble(sodium);}).collect(Collectors.toList());
                        if(!titles.isEmpty()) {
                            titles.retainAll(sodiums);
                        } else{
                            titles = sodiums;
                        }
                    }

                    String DisplayView1;

                    for (int i = 0; i < titles.size(); i++) {
                        //BaseProduct p = (BaseProduct) m.getElement(i);
                        MenuItem p = titles.get(i);
                        DisplayView1 = "ID = " + i + " -|- Title = " + p.getTitle() +" -|- R: " + p.getRating() +" -|- K: "+p.getCalories() + " -|- P: "+ p.getProtein()+ " -|- F: " + p.getFat() +" -|- S: " + p.getSodium() + " -|- Price: "+ p.getPrice()+"\n";
                        searchMenuText.append(DisplayView1);

                    }

                    titles.clear();



                }
            });
        }

        {//ActionListener for main menu
            buton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    viewF.setVisible(true);
                    mainF.setVisible(false);

                    //adaug meniul updatat de Administrator

                    try
                    {
                        //View details Delete

                        BufferedReader bR1DelView = new BufferedReader( new FileReader("MeniulMeu.txt") );
                        String recordDelView;

                        int iDel=0;
                        String DisplayDel1[]=new String[1024];
                        while( ( recordDelView = bR1DelView.readLine() ) != null )
                        {
                            StringTokenizer stDel = new StringTokenizer(recordDelView,",");

                            String IDDelView=stDel.nextToken();
                            String nameDelView=stDel.nextToken();
                            String PrizeDelView=stDel.nextToken();

                            DisplayDel1[iDel]="ID = "+IDDelView+" *** Name = "+nameDelView+" *** Prize = "+PrizeDelView+"\n";

                            viewMenuText.append(DisplayDel1[iDel]);
                            iDel++;
                        }
                        bR1DelView.close();
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Exception msg: "+ex);
                    }


                }

            });
        }

        {//ActionListener for main menu
            buton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    searchF.setVisible(true);
                    mainF.setVisible(false);


                }

            });
        }

        {//ActionListener for main menu
            buton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    orderF.setVisible(true);
                    mainF.setVisible(false);

                    o = new Order(id, idClient);
                    id++;

                    try
                    {
                        //View details Delete

                        BufferedReader bR1DelView = new BufferedReader( new FileReader("MeniulMeu.txt") );
                        String recordDelView;

                        int iDel=0;
                        //String DisplayDel1[]=new String[1024];
                        while( ( recordDelView = bR1DelView.readLine() ) != null )
                        {
                            StringTokenizer stDel = new StringTokenizer(recordDelView,",");

                            String IDDelete=stDel.nextToken();
                            String nameDelete=stDel.nextToken();
                            String ratingDelete=stDel.nextToken();
                            String caloriesDelete=stDel.nextToken();
                            String proteinDelete=stDel.nextToken();
                            String fatDelete=stDel.nextToken();
                            String sodiumDelete=stDel.nextToken();
                            String PriceDelete=stDel.nextToken();

                            String DisplayView1 = "ID = " + IDDelete + " -|- Title = " + nameDelete +" -|- R: " + ratingDelete +" -|- K: "+ caloriesDelete + " -|- P: "+ proteinDelete + " -|- F: " + fatDelete +" -|- S: " + sodiumDelete + " -|- Price: "+ PriceDelete+"\n";

                            orderMenuText.append(DisplayView1);
                            iDel++;
                        }
                        bR1DelView.close();
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Exception msg: "+ex);
                    }


                }

            });
        }

        {//ActionListener for main menu
            buton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    viewOrderF.setVisible(true);
                    mainF.setVisible(false);

                    for(Order o : comenzi.keySet()) {

                        viewOrderMenuText.append(String.valueOf(comenzi.get(o)) + '\n');
                        System.out.println(comenzi.get(o).getHour());

                    }


                }

            });
        }

        {//ActionListener for main menu
            viewOrderBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    viewOrderF.setVisible(false);
                    mainF.setVisible(true);

                    viewOrderMenuText.setText("");
                }

            });
        }



        {//ActionListener for main menu
            orderAddBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                try{
                    String IDUpdate1 = " " + orderIDF.getText() + " ";
                    BufferedReader brUpdate2 = new BufferedReader( new FileReader("MeniulMeu.txt") );

                    orderAddedF.setText(orderAddedF.getText() + IDUpdate1);

                    while( (recordUpdate2 = brUpdate2.readLine()) != null )
                    {
                        if(recordUpdate2.contains(IDUpdate1)) {

                            StringTokenizer st = new StringTokenizer(recordUpdate2,",");

                            String IDDelete=st.nextToken();
                            String nameDelete=st.nextToken();
                            String ratingDelete=st.nextToken();
                            String caloriesDelete=st.nextToken();
                            String proteinDelete=st.nextToken();
                            String fatDelete=st.nextToken();
                            String sodiumDelete=st.nextToken();
                            String PriceDelete=st.nextToken();

                            //IDDelete =IDDelete.trim();

                            IDUpdate1 = IDUpdate1.trim();
                            System.out.println(IDUpdate1);

                            BaseProduct p = new BaseProduct(Integer.parseInt(IDUpdate1),Double.parseDouble(PriceDelete),nameDelete,Double.parseDouble(ratingDelete),Double.parseDouble(caloriesDelete),Double.parseDouble(proteinDelete),Double.parseDouble(fatDelete),Double.parseDouble(sodiumDelete));
                            o.addMenuItem(p);
                            price = (int) (price + p.getPrice());
                            noOfTimesOrder[p.getId()]=noOfTimesOrder[p.getId()]+1;
                            checkOrder[p.getId()] = 1;
                            for(int i=0; i<menuList.size(); i++){
                                if(stringCompare(menuList.get(i).getTitle(),p.getTitle()) == 0){
                                    menuList.get(i).setNumberOfOrders();
                                    System.out.println(p);
                                    break;
                                }
                            }
                            break;
                        }

                    }

                }catch (Exception ex){

                    System.out.println("Error" + ex);
                }



                }

            });
        }
        {//ActionListener for main menu
            orderCreateBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    orderAddedF.setText("");
                    if(o != null){

                        DeliveryService.addComanda(o);

                        //O adaug intr-un fisier txt
                        try {
                            BufferedWriter bW1 = new BufferedWriter(new FileWriter("Orders.txt", true));
                            String s =  o.getId() + "," + o.getClientId() +  "," + o.getYear() + ","+o.getMonth()+"," +o.getDate();
                            bW1.write(s);
                            bW1.flush();
                            bW1.newLine();
                            bW1.close();


                        }catch (Exception ex){

                        }
                        System.out.println(o.hashCode());
                        addSmth();
                        //Generare Factura
                        try {
                            BufferedWriter bW1 = new BufferedWriter(new FileWriter("Bill"+ id +".txt", true));
                            bW1.write(comenzi.get(o).toString() +'\n');
                            bW1.flush();
                            bW1.newLine();
                            bW1.close();


                        }catch (Exception ex){

                        }
                       //Conectare la baza de date si adaugare la count si price
                        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
                        final String USERNAME = "root";
                        final String PASSWORD = "Clau_2001";
                        count = count + 1;

                        try{
                            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                            // Connected to database successfully...

                            Statement stmt = conn.createStatement();
                            String sql = "UPDATE users SET count=?, price=? WHERE id=?";
                            PreparedStatement preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, String.valueOf(count));
                            preparedStatement.setString(2, String.valueOf(price));
                            preparedStatement.setString(3, String.valueOf(idClient));

                            preparedStatement.executeUpdate();


                            stmt.close();
                            conn.close();

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        //DeliveryService.parcurgereComenzi();

                    }

                }

            });
        }



    }


    public String getAddTitle(){
        return addTitleF.getText();
    }
    public String getAddRating(){
        return addRatingF.getText();
    }
    public String getAddCalories(){
        return addCaloriesF.getText();
    }
    public String getAddProteines(){
        return addProteinF.getText();
    }
    public String getAddFat(){
        return addFatF.getText();
    }
    public String getAddSodium(){
        return addSodiumF.getText();
    }
    public String getAddPrice(){
        return addPriceF.getText();
    }

    public String getAddIdNew(){
        return updateIDF.getText();
    }


    protected void showDialog() {
        int a = JOptionPane.showConfirmDialog(mainF,"Are You Sure you want to exit? ");
        if(a==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }

    public static void main(String args[]){

        new InterfataClient(0);

    }
    public static int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }

        else {
            return 0;
        }
    }



}
