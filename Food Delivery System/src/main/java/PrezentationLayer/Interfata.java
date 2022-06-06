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
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import BusinessLayer.*;
import BusinessLayer.MenuItem;

import static BusinessLayer.DeliveryService.comenzi;
import static BusinessLayer.Menu.*;


public class Interfata {


    JFrame mainF, importF, addF, deleteF, updateF, compositeF, reportF;
    Container mainMenu, importMenu, addMenu, deleteMenu, updateMenu, compositeMenu, reportMenu;
    JPanel mainPanel1, importPanel1, importPanel2, addPanel1, addPanel2, deletePanel1, deletePanel2, updatePanel1, updatePanel2, compositePanel1, compositePanel2, reportPanel1, reportPanel2, reportPanel3, reportPanel4;
    JButton  importBackBtn, importBtn, addBackBtn, addBtn, deleteBackBtn, deleteBtn, updateSelectBtn, updateBackBtn, updateBtn, compositeAddBtn, compositeCreateBtn, compositeBackBtn;
    JTextArea importMenuText, addMenuText, deleteMenuText, updateMTextAForView, updateMTextAForResult, compositeMenuText;

    ComposedProduct prod;

    private static int id = 700;

    String recordUpdate2;

    JButton buton1, buton2, buton3, buton4, buton5, buton6, report1Btn, back, report2Btn, report4Btn, report3Btn;

    JLabel l,l1,l2,ll,ll1,llll1,llll,lll,lll1,lll2 ,addIDL, addTitleL, addRatingL, addProteinL, addCaloriesL, addFatL, addSodiumL ,addPriceL, updateIDL, compositeIDL, compositeAddedL ;
    JTextField f1,f2,ff1,ffff1,fff1,fff2,addIDF, addTitleF, addRatingF, addProteinF ,addCaloriesF, addFatF, addSodiumF, addPriceF, updateIDF, compositeIDF, compositeAddedF;

    JLabel upIDL, upTitleL, upRatingL, upProteinL, upCaloriesL, upFatL, upSodiumL ,upPriceL, updateStatusL;
    JTextField upIDF, upTitleF, upRatingF, upProteinF ,upCaloriesF, upFatF, upSodiumF, upPriceF;

    JLabel deleteIDL;
    JTextField deleteIDF;



    public Interfata(){

        mainF = new JFrame("Main Menu");
        importF = new JFrame("Import Menu");
        addF = new JFrame("Add Menu");
        deleteF = new JFrame("Delete Menu");
        updateF = new JFrame("Update Menu");
        compositeF = new JFrame("Composite Menu");
        reportF = new JFrame("Composite Menu");

        {//--Containers

            //--Main Menu Container
            mainMenu = mainF.getContentPane();
            mainMenu.setBackground(Color.white);
            mainMenu.setVisible(true);

            //--Import Menu Container
            importMenu = importF.getContentPane();
            importMenu.setBackground(Color.white);
            importMenu.setVisible(true);

            //--Add Menu Container
            addMenu = addF.getContentPane();
            addMenu.setBackground(Color.white);
            addMenu.setVisible(true);

            //--Delete Menu Container
            deleteMenu = deleteF.getContentPane();
            deleteMenu.setBackground(Color.white);
            deleteMenu.setVisible(true);

            //--Update Menu Container
            updateMenu = updateF.getContentPane();
            updateMenu.setBackground(Color.white);
            updateMenu.setVisible(true);

            //--Composite Menu Container
            compositeMenu = compositeF.getContentPane();
            compositeMenu.setBackground(Color.white);
            compositeMenu.setVisible(true);

            //Report Menu Container
            reportMenu = reportF.getContentPane();
            reportMenu.setBackground(Color.white);
            reportMenu.setVisible(true);


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
            addPanel1.setBounds(30, 30, 250, 400);
            addPanel1.setBackground(Color.white);

            addPanel2 = new JPanel();
            addPanel2.setBounds(400, 30, 720, 600);
            addPanel2.setBackground(Color.white);

            deletePanel1 = new JPanel();
            deletePanel1.setBounds(30, 30, 250, 400);
            deletePanel1.setBackground(Color.white);

            deletePanel2 = new JPanel();
            deletePanel2.setBounds(250,100,720,900);
            deletePanel2.setBackground(Color.white);

            updatePanel1 = new JPanel();
            updatePanel1.setBounds(30, 30, 200, 600);
            updatePanel1.setBackground(Color.white);

            updatePanel2 = new JPanel();
            updatePanel2.setBounds(300, 30, 720, 600);
            updatePanel2.setBackground(Color.white);

            compositePanel1 = new JPanel();
            compositePanel1.setBounds(30, 30, 200, 600);
            compositePanel1.setBackground(Color.white);

            compositePanel2 = new JPanel();
            compositePanel2.setBounds(300, 30, 720, 600);
            compositePanel2.setBackground(Color.white);

            reportPanel1 = new JPanel();
            reportPanel1.setBounds(0, 0, 400, 300);
            reportPanel1.setBackground(Color.white);

            reportPanel2 = new JPanel();
            reportPanel2.setBounds(0, 300, 400, 300);
            reportPanel2.setBackground(Color.white);

            reportPanel3 = new JPanel();
            reportPanel3.setBounds(400, 0, 400, 300);
            reportPanel3.setBackground(Color.white);

            reportPanel4 = new JPanel();
            reportPanel4.setBounds(400, 300, 400, 300);
            reportPanel4.setBackground(Color.white);

        }

        {//--setting all frames visiblity to true

            mainF.setVisible(true);
            mainF.setLayout(null);

            importF.setVisible(false);
            importF.setLayout(null);

            addF.setVisible(false);
            addF.setLayout(null);

            deleteF.setVisible(false);
            deleteF.setLayout(null);

            updateF.setVisible(false);
            updateF.setLayout(null);

            compositeF.setVisible(false);
            compositeF.setLayout(null);

            reportF.setVisible(false);
            reportF.setLayout(null);

        }
        {//--setting frame and container size

            mainMenu.add(mainPanel1);
            mainMenu.setSize(550, 300);
            mainF.setSize(600, 600);
            mainMenu.setVisible(true);

            importMenu.add(importPanel1);
            importMenu.add(importPanel2);
            importMenu.setSize(550, 300);
            importF.setSize(1200, 900);
            importMenu.setVisible(true);

            addMenu.add(addPanel1);
            addMenu.add(addPanel2);
            addMenu.setSize(550, 300);
            addF.setSize(1400, 900);
            addMenu.setVisible(true);

            deleteMenu.add(deletePanel1);
            deleteMenu.add(deletePanel2);
            deleteMenu.setSize(550, 300);
            deleteF.setSize(1200, 900);
            deleteMenu.setVisible(true);

            updateMenu.add(updatePanel1);
            updateMenu.add(updatePanel2);
            updateMenu.setSize(550, 300);
            updateF.setSize(1200, 900);
            updateMenu.setVisible(true);

            compositeMenu.add(compositePanel1);
            compositeMenu.add(compositePanel2);
            compositeMenu.setSize(550, 300);
            compositeF.setSize(1200, 900);
            compositeMenu.setVisible(true);

            reportMenu.add(reportPanel1);
            reportMenu.add(reportPanel2);
            reportMenu.add(reportPanel3);
            reportMenu.add(reportPanel4);
            reportMenu.setSize(550, 300);
            reportF.setSize(1200, 900);
            reportMenu.setVisible(true);

        }

        {//main page

            buton1 = new JButton("Import Initial Menu");
            buton1.setPreferredSize(new Dimension(150, 150));

            buton2 = new JButton("Add new item");
            buton2.setPreferredSize(new Dimension(150, 150));

            buton3 = new JButton("Delete item");
            buton3.setPreferredSize(new Dimension(150, 150));

            buton4 = new JButton("Update Item");
            buton4.setPreferredSize(new Dimension(150, 150));

            buton5 = new JButton("Create Composed Item");
            buton5.setPreferredSize(new Dimension(150, 150));

            buton6 = new JButton("Generate Reports");
            buton6.setPreferredSize(new Dimension(150, 150));

            mainPanel1.add(buton1, BorderLayout.CENTER);
            mainPanel1.add(buton2, BorderLayout.CENTER);
            mainPanel1.add(buton3, BorderLayout.CENTER);
            mainPanel1.add(buton4, BorderLayout.CENTER);
            mainPanel1.add(buton5, BorderLayout.CENTER);
            mainPanel1.add(buton6, BorderLayout.CENTER);

            mainF.setVisible(true);
        }

        {//import page
            importBackBtn = new JButton("Back");
            importBackBtn.setPreferredSize(new Dimension(80, 20));

            importBtn = new JButton("Import");
            importBtn.setPreferredSize(new Dimension(80, 20));

            importMenuText = new JTextArea(30, 60);
            importMenuText.setPreferredSize(new Dimension(900, 150000));
            importMenuText.setEditable(false);


            JScrollPane scrollView = new JScrollPane(importMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            importPanel1.add(importBackBtn, BorderLayout.NORTH);
            importPanel1.add(importBtn, BorderLayout.SOUTH);

            importPanel2.add(scrollView, BorderLayout.CENTER);



        }

        {//add new item

            addIDL=new JLabel("ID: ");
            addIDL.setPreferredSize(new Dimension(30,20));

            addIDF=new JTextField();
            addIDF.setPreferredSize(new Dimension(180,20));

            addTitleL=new JLabel("Title: ");
            addTitleL.setPreferredSize(new Dimension(40,20));

            addTitleF=new JTextField();
            addTitleF.setPreferredSize(new Dimension(180,20));

            addRatingL=new JLabel("Rating: ");
            addRatingL.setPreferredSize(new Dimension(50,20));

            addRatingF=new JTextField();
            addRatingF.setPreferredSize(new Dimension(180,20));

            addProteinL=new JLabel("Protein: ");
            addProteinL.setPreferredSize(new Dimension(50,20));

            addProteinF=new JTextField();
            addProteinF.setPreferredSize(new Dimension(180,20));

            addCaloriesL=new JLabel("Claories: ");
            addCaloriesL.setPreferredSize(new Dimension(80,20));

            addCaloriesF=new JTextField();
            addCaloriesF.setPreferredSize(new Dimension(180,20));


            addFatL=new JLabel("Fat: ");
            addFatL.setPreferredSize(new Dimension(40,20));

            addFatF=new JTextField();
            addFatF.setPreferredSize(new Dimension(180,20));

            addSodiumL=new JLabel("Sodium: ");
            addCaloriesL.setPreferredSize(new Dimension(60,20));

            addSodiumF=new JTextField();
            addSodiumF.setPreferredSize(new Dimension(180,20));


            addPriceL=new JLabel("Price: ");
            addFatL.setPreferredSize(new Dimension(60,20));

            addPriceF=new JTextField();
            addPriceF.setPreferredSize(new Dimension(180,20));


            addBackBtn = new JButton("Back");
            addBackBtn.setPreferredSize(new Dimension(80, 20));

            addBtn = new JButton("Add Item");
            addBtn.setPreferredSize(new Dimension(100, 20));


            addPanel1.add(addTitleL,BorderLayout.NORTH);
            addPanel1.add(addTitleF,BorderLayout.NORTH);

            addPanel1.add(addRatingL,BorderLayout.NORTH);
            addPanel1.add(addRatingF,BorderLayout.NORTH);

            addPanel1.add(addProteinL,BorderLayout.NORTH);
            addPanel1.add(addProteinF,BorderLayout.NORTH);

            addPanel1.add(addCaloriesL,BorderLayout.NORTH);
            addPanel1.add(addCaloriesF,BorderLayout.NORTH);

            addPanel1.add(addFatL,BorderLayout.NORTH);
            addPanel1.add(addFatF,BorderLayout.NORTH);

            addPanel1.add(addSodiumL,BorderLayout.NORTH);
            addPanel1.add(addSodiumF,BorderLayout.NORTH);

            addPanel1.add(addPriceL,BorderLayout.NORTH);
            addPanel1.add(addPriceF,BorderLayout.NORTH);

            addPanel1.add(addBackBtn, BorderLayout.WEST);
            addPanel1.add(addBtn, BorderLayout.WEST);


        }

        {//add new item
            deleteIDL=new JLabel("ID: ");
            deleteIDL.setPreferredSize(new Dimension(30,20));

            deleteIDF=new JTextField();
            deleteIDF.setPreferredSize(new Dimension(180,20));

            deleteMenuText = new JTextArea(30,60);
            deleteMenuText.setPreferredSize(new Dimension(900, 15000));
            deleteMenuText.setEditable(false);

            JScrollPane scrollView = new JScrollPane(deleteMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            deleteBackBtn = new JButton("Back");
            deleteBackBtn.setPreferredSize(new Dimension(80, 20));

            deleteBtn = new JButton("Delete Item");
            deleteBtn.setPreferredSize(new Dimension(120, 20));

            deletePanel1.add(deleteIDL,BorderLayout.NORTH);
            deletePanel1.add(deleteIDF,BorderLayout.NORTH);

            deletePanel1.add(deleteBackBtn, BorderLayout.NORTH);
            deletePanel1.add(deleteBtn, BorderLayout.SOUTH);

            deletePanel2.add(scrollView, BorderLayout.CENTER);

        }
        {//UPDATE CURRENT ITEM
            updateIDL=new JLabel("ID: ");
            updateIDL.setPreferredSize(new Dimension(30,20));

            updateIDF=new JTextField();
            updateIDF.setPreferredSize(new Dimension(150,20));

            updateSelectBtn = new JButton("Select");
            updateSelectBtn.setPreferredSize(new Dimension(80, 20));

            updateMTextAForView=new JTextArea("Tracing the details\nID\nTitle\nRating\nProtein\nCalories\nFat\nSodium\nPrice\n");
            updateMTextAForView.setPreferredSize(new Dimension(170,150));
            updateMTextAForView.setEditable(false);



            upTitleL=new JLabel("Title: ");
            upTitleL.setPreferredSize(new Dimension(50,20));

            upTitleF=new JTextField();
            upTitleF.setPreferredSize(new Dimension(120,20));

            upRatingL=new JLabel("Rating: ");
            upRatingL.setPreferredSize(new Dimension(50,20));

            upRatingF=new JTextField();
            upRatingF.setPreferredSize(new Dimension(120,20));

            upProteinL=new JLabel("Protein: ");
            upProteinL.setPreferredSize(new Dimension(50,20));

            upProteinF=new JTextField();
            upProteinF.setPreferredSize(new Dimension(120,20));

            upCaloriesL=new JLabel("Claories: ");
            upCaloriesL.setPreferredSize(new Dimension(70,20));

            upCaloriesF=new JTextField();
            upCaloriesF.setPreferredSize(new Dimension(120,20));


            upFatL=new JLabel("Fat: ");
            upFatL.setPreferredSize(new Dimension(50,20));

            upFatF=new JTextField();
            upFatF.setPreferredSize(new Dimension(120,20));

            upSodiumL=new JLabel("Sodium: ");
            upCaloriesL.setPreferredSize(new Dimension(50,20));

            upSodiumF=new JTextField();
            upSodiumF.setPreferredSize(new Dimension(120,20));


            upPriceL=new JLabel("Price: ");
            upFatL.setPreferredSize(new Dimension(50,20));

            upPriceF=new JTextField();
            upPriceF.setPreferredSize(new Dimension(120,20));

            updateBackBtn = new JButton("Back");
            updateBackBtn.setPreferredSize(new Dimension(80, 20));

            updateBtn = new JButton("Update");
            updateBtn.setPreferredSize(new Dimension(80, 20));

            updateMTextAForResult=new JTextArea("");
            updateMTextAForResult.setPreferredSize(new Dimension(170,150));
            updateMTextAForResult.setEditable(false);

            updateStatusL=new JLabel("Status of update");
            updateStatusL.setPreferredSize(new Dimension(200,20));



            updatePanel1.add(updateIDL, BorderLayout.NORTH);
            updatePanel1.add(updateIDF, BorderLayout.NORTH);
            updatePanel1.add(updateSelectBtn, BorderLayout.SOUTH);
            updatePanel1.add(updateMTextAForView,BorderLayout.NORTH);



            updatePanel1.add(upTitleL,BorderLayout.NORTH);
            updatePanel1.add(upTitleF,BorderLayout.NORTH);

            updatePanel1.add(upRatingL,BorderLayout.NORTH);
            updatePanel1.add(upRatingF,BorderLayout.NORTH);

            updatePanel1.add(upProteinL,BorderLayout.NORTH);
            updatePanel1.add(upProteinF,BorderLayout.NORTH);

            updatePanel1.add(upCaloriesL,BorderLayout.NORTH);
            updatePanel1.add(upCaloriesF,BorderLayout.NORTH);

            updatePanel1.add(upFatL,BorderLayout.NORTH);
            updatePanel1.add(upFatF,BorderLayout.NORTH);

            updatePanel1.add(upSodiumL,BorderLayout.NORTH);
            updatePanel1.add(upSodiumF,BorderLayout.NORTH);

            updatePanel1.add(upPriceL,BorderLayout.NORTH);
            updatePanel1.add(upPriceF,BorderLayout.NORTH);


            updatePanel1.add(updateBtn, BorderLayout.SOUTH);
            updatePanel1.add(updateBackBtn, BorderLayout.SOUTH);

            updatePanel2.add(updateMTextAForResult);
            updatePanel2.add(updateStatusL);

        }

        {//CREATE COMPOSITE ITEM
            compositeIDL=new JLabel("ID: ");
            compositeIDL.setPreferredSize(new Dimension(50,20));

            compositeIDF=new JTextField();
            compositeIDF.setPreferredSize(new Dimension(120,20));

            compositeAddedL=new JLabel("Added: ");
            compositeAddedL.setPreferredSize(new Dimension(50,20));

            compositeAddedF=new JTextField();
            compositeAddedF.setPreferredSize(new Dimension(120,20));

            compositeMenuText = new JTextArea(30,60);
            compositeMenuText.setPreferredSize(new Dimension(900, 15000));
            compositeMenuText.setEditable(false);

            JScrollPane scrollView = new JScrollPane(compositeMenuText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            compositeBackBtn = new JButton("Back");
            compositeBackBtn.setPreferredSize(new Dimension(80, 20));

            compositeAddBtn = new JButton("Add");
            compositeAddBtn.setPreferredSize(new Dimension(180, 20));

            compositeCreateBtn = new JButton("Create");
            compositeCreateBtn.setPreferredSize(new Dimension(80, 20));

            compositePanel1.add(compositeIDL);
            compositePanel1.add(compositeIDF);
            compositePanel1.add(compositeAddBtn);
            compositePanel1.add(compositeAddedL);
            compositePanel1.add(compositeAddedF);
            compositePanel1.add(compositeCreateBtn);
            compositePanel1.add(compositeBackBtn);

            compositePanel2.add(scrollView, BorderLayout.CENTER);


        }

        {//CREATE Reports

            l=new JLabel("Reports About Orders between Start & End");
            l.setPreferredSize(new Dimension(350,20));


            l1=new JLabel("Start: ");
            l1.setPreferredSize(new Dimension(50,20));

            f1=new JTextField();
            f1.setPreferredSize(new Dimension(120,20));

            l2=new JLabel("End: ");
            l2.setPreferredSize(new Dimension(50,20));

            f2=new JTextField();
            f2.setPreferredSize(new Dimension(120,20));

            back = new JButton("Back");
            back.setPreferredSize(new Dimension(80, 20));

            report1Btn = new JButton("Generate Report");
            report1Btn.setPreferredSize(new Dimension(180, 20));

            ll=new JLabel("Reports About Products Ordered More Than");
            ll.setPreferredSize(new Dimension(350,20));


            ll1=new JLabel("No of Times: ");
            ll1.setPreferredSize(new Dimension(50,20));

            ff1=new JTextField();
            ff1.setPreferredSize(new Dimension(120,20));


            report2Btn = new JButton("Generate Report");
            report2Btn.setPreferredSize(new Dimension(180, 20));


            lll=new JLabel("Reports About Clients ->");
            lll.setPreferredSize(new Dimension(350,20));


            lll1=new JLabel("Count ");
            lll1.setPreferredSize(new Dimension(70,20));

            fff1=new JTextField();
            fff1.setPreferredSize(new Dimension(120,20));

            lll2=new JLabel("Price: ");
            lll2.setPreferredSize(new Dimension(70,20));

            fff2=new JTextField();
            fff2.setPreferredSize(new Dimension(120,20));


            report3Btn = new JButton("Generate Report");
            report3Btn.setPreferredSize(new Dimension(180, 20));


            llll=new JLabel("Reports About Products Order in Day ->");
            llll.setPreferredSize(new Dimension(350,20));


            llll1=new JLabel("Day[between 0 & 6]: ");
            llll1.setPreferredSize(new Dimension(70,20));

            ffff1=new JTextField();
            ffff1.setPreferredSize(new Dimension(120,20));


            report4Btn = new JButton("Generate Report");
            report4Btn.setPreferredSize(new Dimension(180, 20));




            reportPanel1.add(l);
            reportPanel1.add(l1);
            reportPanel1.add(f1);
            reportPanel1.add(l2);
            reportPanel1.add(f2);
            reportPanel1.add(report1Btn);
            reportPanel1.add(back);

            reportPanel2.add(ll);
            reportPanel2.add(ll1);
            reportPanel2.add(ff1);
            reportPanel2.add(report2Btn);

            reportPanel3.add(lll);
            reportPanel3.add(lll1);
            reportPanel3.add(fff1);
            reportPanel3.add(lll2);
            reportPanel3.add(fff2);
            reportPanel3.add(report3Btn);

            reportPanel4.add(llll);
            reportPanel4.add(llll1);
            reportPanel4.add(ffff1);
            reportPanel4.add(report4Btn);



        }

        ///////////////////////////////////////////////////////////////////////////////////////
        //---> Main Interface

        {//ActionListener for main menu
            buton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    importF.setVisible(true);
                    mainF.setVisible(false);

                }

            });
        }

        {//ActionListener for main menu
            buton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    addF.setVisible(true);
                    mainF.setVisible(false);

                }

            });
        }

        {//ActionListener for main menu
            buton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    deleteF.setVisible(true);
                    mainF.setVisible(false);

                    try
                    {
                        //View details Delete

                        deleteMenuText.setText("");
                        BufferedReader bR1DelView = new BufferedReader( new FileReader("MeniulMeu.txt") );
                        String recordDelView;


                        String DisplayView1;
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

                            DisplayView1 = "ID = " + IDDelete + " -|- Title = " + nameDelete +" -|- R: " + ratingDelete +" -|- K: "+ caloriesDelete + " -|- P: "+ proteinDelete + " -|- F: " + fatDelete +" -|- S: " + sodiumDelete + " -|- Price: "+ PriceDelete+"\n";

                            deleteMenuText.append(DisplayView1);
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
                    updateF.setVisible(true);
                    mainF.setVisible(false);
                    updateMTextAForView.setText("");



                }

            });
        }

        {//ActionListener for main menu
            buton5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    compositeF.setVisible(true);
                    mainF.setVisible(false);
                    prod = new ComposedProduct(id, 0,"");

                    try
                    {
                        //View details Delete

                        compositeMenuText.setText("");
                        BufferedReader bR1DelView = new BufferedReader( new FileReader("MeniulMeu.txt") );
                        String recordDelView;


                        String DisplayView1;
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

                            DisplayView1 = "ID = " + IDDelete + " -|- Title = " + nameDelete +" -|- R: " + ratingDelete +" -|- K: "+ caloriesDelete + " -|- P: "+ proteinDelete + " -|- F: " + fatDelete +" -|- S: " + sodiumDelete + " -|- Price: "+ PriceDelete+"\n";

                            compositeMenuText.append(DisplayView1);
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
            buton6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    reportF.setVisible(true);
                    mainF.setVisible(false);

                }

            });
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////
        //---> End Main Interface


        /////////////////////////////////////////////////////////////////////////////////////////////////
        //---> Import Menu

        {//ActionListener for main menu
            importBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {

                        System.out.println("Yess");
                        //m.readDataFromCSV();
                        readDataFromCSV();
                        String DisplayView1;

                        for (int i = 0; i < 700; i++) {
                            //BaseProduct p = (BaseProduct) m.getElement(i);
                            BaseProduct p = (BaseProduct) menuList.get(i);
                            DisplayView1 = "ID = " + i + " -|- Title = " + p.getTitle() +" -|- R: " + p.getRating() +" -|- K: "+p.getCalories() + " -|- P: "+ p.getProtein()+ " -|- F: " + p.getFat() +" -|- S: " + p.getSodium() + " -|- Price: "+ p.getPrice()+"\n";
                            importMenuText.append(DisplayView1);


                        }

                        File logFile = new File("MeniulMeu.txt");
                        if(logFile.length() == 0) {
                            for (int i = 0; i < 700; i++) {
                                //BaseProduct p = (BaseProduct) m.getElement(i);
                                BaseProduct p = (BaseProduct) menuList.get(i);
                                BufferedWriter bW1 = new BufferedWriter(new FileWriter("MeniulMeu.txt", true));
                                String ID = " " + i + " ";
                                String name = p.getTitle();
                                String Price = String.valueOf(p.getPrice());
                                String Rating = String.valueOf(p.getRating());
                                String Calories = String.valueOf(p.getCalories());
                                String Protein = String.valueOf(p.getProtein());
                                String Fat = String.valueOf(p.getFat());
                                String Sodium = String.valueOf(p.getSodium());


                                bW1.write(ID + "," + name + "," + Rating + "," + Calories + "," + Protein + "," + Fat + "," + Sodium + "," + Price);
                                bW1.flush();
                                bW1.newLine();
                                bW1.close();

                            }
                        } else{
                            System.out.println("Nu e gol");
                        }

                    }catch(Exception ex){

                        System.out.println("Eror " + ex);

                    }

                }

            });
        }

        {
            importBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    importF.setVisible(false);
                    mainF.setVisible(true);

                }

            });
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //---> End Import Menu


        ///////////////////////////////////////////////////////////////////////////////////////////////
        //---> Add menu

        {//ActionListener for main menu
            addBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        BufferedWriter bW1 = new BufferedWriter(new FileWriter("MeniulMeu.txt", true));
                        String ID = " " + id + " ";
                        String name = getAddTitle();
                        String Price = getAddPrice();
                        String Rating = getAddRating();
                        String Calories = getAddCalories();
                        String Protein = getAddProteines();
                        String Fat = getAddFat();
                        String Sodium = getAddSodium();
                        name = name.toLowerCase();

                        bW1.write(ID + "," + name + "," + Rating + "," + Calories + "," + Protein + "," + Fat + "," + Sodium + "," + Price);
                        bW1.flush();
                        bW1.newLine();
                        bW1.close();

                        String DisplayView1 = "ID = " + id + " -|- Title = " + name +" -|- R: " + Rating +" -|- K: "+ Calories + " -|- P: "+ Protein + " -|- F: " + Fat +" -|- S: " + Sodium + " -|- Price: "+ Price+"\n";
                        id++;
                        importMenuText.append(DisplayView1);


                    }catch (Exception ex){

                        System.out.println("Error!!"+ ex);

                    }

                }

            });
        }

        {
            addBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    addF.setVisible(false);
                    mainF.setVisible(true);

                }

            });
        }



        //////////////////////////////////////////////////////////////////////////////////////////////////
        //---> End Add Menu


        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        /////////////////////////////////////////////////////////////////////////////////////////////////
        //---> Update Menu

        {//ActionListener for main menu
            updateSelectBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {
                        String IDUpdate1 = " " + getAddIdNew() + " ";
                        BufferedReader brUpdate = new BufferedReader(new FileReader("MeniulMeu.txt"));

                        while ((recordUpdate2 = brUpdate.readLine()) != null) {
                            if (recordUpdate2.contains(IDUpdate1)) {

                                StringTokenizer st = new StringTokenizer(recordUpdate2,",");

                                String IDDelete=st.nextToken();
                                String nameDelete=st.nextToken();
                                String ratingDelete=st.nextToken();
                                String caloriesDelete=st.nextToken();
                                String proteinDelete=st.nextToken();
                                String fatDelete=st.nextToken();
                                String sodiumDelete=st.nextToken();
                                String PriceDelete=st.nextToken();
                                String ViewUpdate="-- Updated Record --\nID = "+IDDelete+"\nName = "+nameDelete+"\nRating = "+ratingDelete+"\nCalories = "+caloriesDelete+"\nProtein = "+proteinDelete+"\nFat = "+fatDelete+"\nSodium = "+sodiumDelete+"\nPrize = "+PriceDelete;
                                updateMTextAForView.setText(ViewUpdate);

                                break;

                            }

                        }

                        brUpdate.close();

                    }catch(Exception ex){

                    }


                }

            });
        }

        {//ActionListener for main menu
            updateBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try
                    {

                        if(getAddPriceNew().length()!=0&&getAddTitleNew().length()!=0)
                        {
                            String IDUpdate1 = " "+getAddIdNew()+" ";

                            BufferedReader brUpdate = new BufferedReader( new FileReader("MeniulMeu.txt") );
                            BufferedWriter bwUpdate2 = new BufferedWriter( new FileWriter("MenuList_temp.txt") );
                            //updateMTextFID.setText("");
                            updateMTextAForResult.setText("");


                            String IDUpdate2nd = IDUpdate1;
                            String newNameUpdate = getAddTitleNew();
                            newNameUpdate=newNameUpdate.toLowerCase();

                            String newRatingUpdate = getAddRatingNew();
                            String newCaloriesUpdate = getAddCaloriesNew();
                            String newProteinUpdate = getAddProteinesNew();
                            String newFatUpdate = getAddFatNew();
                            String newSodiumUpdate = getAddSodiumNew();


                            String newPrizeUpdate =  getAddPriceNew();



                            BufferedReader brUpdate2 = new BufferedReader( new FileReader("MeniulMeu.txt") );

                            recordUpdate2 = "";

                            while( (recordUpdate2 = brUpdate2.readLine()) != null )
                            {
                                if(recordUpdate2.contains(IDUpdate2nd))
                                {
                                    System.out.println(IDUpdate2nd);
                                    bwUpdate2.write(IDUpdate2nd+","+newNameUpdate+","+newRatingUpdate +","+  newCaloriesUpdate + "," + newProteinUpdate + "," + newFatUpdate + "," + newSodiumUpdate+ "," +newPrizeUpdate);

                                }
                                else
                                {
                                    bwUpdate2.write(recordUpdate2);
                                }

                                bwUpdate2.flush();
                                bwUpdate2.newLine();
                            }
                            brUpdate.close();
                            bwUpdate2.close();
                            brUpdate2.close();

                            File dbUpdate2 = new File("MeniulMeu.txt");
                            File tempDBUpdate2 = new File("MenuList_temp.txt");

                            dbUpdate2.delete();

                            boolean success =tempDBUpdate2.renameTo(dbUpdate2);


                            String SuccessUpdate="Record Updation status: "+success;

                            if(success==true)
                            {
                                updateStatusL.setForeground(Color.GREEN);
                                updateStatusL.setText(SuccessUpdate);
                            }
                            else
                            {
                                updateStatusL.setForeground(Color.RED);
                                updateStatusL.setText(SuccessUpdate);
                            }
                            String ViewUpdate="-- Updated Record --\nID = "+IDUpdate2nd+"\nName = "+newNameUpdate+"\nRating = "+newRatingUpdate+"\nCalories = "+newCaloriesUpdate+"\nProtein = "+newProteinUpdate+"\nFat = "+newFatUpdate+"\nSodium = "+newSodiumUpdate+"\nPrize = "+newPrizeUpdate;
                            updateMTextAForResult.setText(ViewUpdate);

                        }
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Exception msg: "+ex);
                    }
                }

            });
        }

        {//ActionListener for main menu
            updateBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    updateF.setVisible(false);
                    mainF.setVisible(true);

                }

            });
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////
        //---> End Update Menu



        //////////////////////////////////////////////////////////////////////////////////////////////////
        //---> Delete Menu

        {//ActionListener for main menu
            deleteBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try
                    {
                        if(deleteIDF.getText().length()!=0)
                        {
                            deleteMenuText.setText("");
                            //------------ delete ----------
                            String ID2, record1,choice3;


                            File tempDB = new File("MenuList_temp.txt");
                            File db = new File("MeniulMeu.txt");


                            BufferedReader br2 = new BufferedReader( new FileReader( db ) );
                            BufferedWriter bw2 = new BufferedWriter( new FileWriter( tempDB ) );


                            //---------- Delete Dish Record ----------

                            ID2 =deleteIDF.getText();

                            ID2=" "+ID2+" ";
                            while( ( record1 = br2.readLine() ) != null ) {


                                if( record1.contains(ID2) )
                                    continue;

                                bw2.write(record1);
                                bw2.flush();
                                bw2.newLine();

                            }

                            br2.close();
                            bw2.close();

                            db.delete();

                            //tempDB.renameTo(db);

                            boolean success = tempDB.renameTo(db);



                            //-------------------------
                            //View details------------------------

                            BufferedReader bR1 = new BufferedReader( new FileReader("MeniulMeu.txt") );
                            String record2;


                            String DisplayView1;
                            while( ( record2 = bR1.readLine() ) != null )
                            {
                                StringTokenizer st = new StringTokenizer(record2,",");

                                String IDDelete=st.nextToken();
                                String nameDelete=st.nextToken();
                                String ratingDelete=st.nextToken();
                                String caloriesDelete=st.nextToken();
                                String proteinDelete=st.nextToken();
                                String fatDelete=st.nextToken();
                                String sodiumDelete=st.nextToken();
                                String PriceDelete=st.nextToken();

                                DisplayView1 = "ID = " + IDDelete + " -|- Title = " + nameDelete +" -|- R: " + ratingDelete +" -|- K: "+ caloriesDelete + " -|- P: "+ proteinDelete + " -|- F: " + fatDelete +" -|- S: " + sodiumDelete + " -|- Price: "+ PriceDelete+"\n";

                                deleteMenuText.append(DisplayView1);
                            }
                            bR1.close();

                        }
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Exception msg: "+ex);
                    }

                }

            });
        }

        {
            deleteBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    deleteF.setVisible(false);
                    mainF.setVisible(true);
                    deleteMenuText.setText("");

                }

            });
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////
        //---> End Delete Menu





        {//ActionListener for main menu
            compositeBackBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    compositeF.setVisible(false);
                    mainF.setVisible(true);

                }

            });
        }






        {//ActionListener for main menu
            compositeAddBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {
                        String IDUpdate1 = " " + compositeIDF.getText() + " ";
                        BufferedReader brUpdate2 = new BufferedReader( new FileReader("MeniulMeu.txt") );

                        compositeAddedF.setText(compositeAddedF.getText() + IDUpdate1);
                        while( (recordUpdate2 = brUpdate2.readLine()) != null )
                        {
                            if(recordUpdate2.contains(IDUpdate1)) {

                                StringTokenizer st = new StringTokenizer(recordUpdate2,",");

                                String IDDelete=st.nextToken();
                                IDDelete = IDDelete.trim();
                                String nameDelete=st.nextToken();
                                String ratingDelete=st.nextToken();
                                String caloriesDelete=st.nextToken();
                                String proteinDelete=st.nextToken();
                                String fatDelete=st.nextToken();
                                String sodiumDelete=st.nextToken();
                                String PriceDelete=st.nextToken();

                                BaseProduct p = new BaseProduct(Integer.parseInt(IDDelete), Double.parseDouble(PriceDelete),nameDelete,Double.parseDouble(ratingDelete),Double.parseDouble(caloriesDelete),Double.parseDouble(proteinDelete),Double.parseDouble(fatDelete),Double.parseDouble(sodiumDelete) );
                                prod.add(p);
                                for(int i=0; i<prod.getSize(); i++){
                                    System.out.println(prod.getElement(i));
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
            compositeCreateBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    String name = prod.computeName();
                    double rating = prod.computeRating();
                    double calories = prod.computeCalories();
                    double protein = prod.computeProtein();
                    double fat = prod.computeFat();
                    double sodium = prod.computeSodium();
                    double price = prod.computePrice();
                    //m.addItem(prod);
                    //il adaug in lista de produse din restaurant

                    compositeAddedF.setText("");
                    menuList.add(prod);
                    try {
                        BufferedWriter bW1 = new BufferedWriter(new FileWriter("MeniulMeu.txt", true));
                        String ID = " " + id + " ";

                        bW1.write(ID + "," + name + "," + rating + "," + calories + "," + protein + "," + fat + "," + sodium + "," + price);
                        bW1.flush();
                        bW1.newLine();
                        bW1.close();

                        // String DisplayView1 = "ID = *" + id + "* -|- Title = " + name + " -|- Rating = " + "" + " -|- Calories = " + "" + " -|- Proteine " + "" + " -|- Fat" + "" + " -|- Sodium" + "" + " -|- Price" + price + "\n";
                        id++;
                        System.out.println("Am facut!!");

                    }catch (Exception ex){
                        System.out.println("Eroare!! " + ex);
                    }


                }

            });
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        // Generate Reports

        {
            report1Btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {
                        BufferedWriter bW1 = new BufferedWriter(new FileWriter("Report1.txt", true));

                        ArrayList<Order> titles = (ArrayList<Order>) comenzi.keySet().stream().filter((Order o) -> {return o.getHour()>=Integer.parseInt(f1.getText()) &&  o.getHour()<=Integer.parseInt(f2.getText());}).collect(Collectors.toList());

                        for(int i=0; i<titles.size(); i++){

                            bW1.write(titles.get(i).toString());
                            bW1.flush();
                            bW1.newLine();

                        }


                        bW1.close();

                    }catch (Exception ex){

                    }



                }

            });

        }
        {
            report2Btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {
                        BufferedWriter bW1 = new BufferedWriter(new FileWriter("Report2.txt", true));
                        int noOfTimes = Integer.parseInt(ff1.getText());

                        ArrayList<MenuItem> items = (ArrayList<MenuItem>) menuList.stream().filter((MenuItem m) -> {return m.getNoOfOrders()>=noOfTimes;}).collect(Collectors.toList());


                        for(int i=0; i<items.size(); i++){

                            bW1.write(items.get(i).toString());
                            bW1.flush();
                            bW1.newLine();

                        }


                        bW1.close();


                        bW1.close();
                    }catch (Exception ex){

                    }


                }

            });

        }

        {
            report3Btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {
                        BufferedWriter bW1 = new BufferedWriter(new FileWriter("Report3.txt", true));
                        final String DB_URL = "jdbc:mysql://localhost:3306/mystore";
                        final String USERNAME = "root";
                        final String PASSWORD = "Clau_2001";

                        try{
                            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                            // Connected to database successfully...

                            Statement stmt = conn.createStatement();
                            String sql = "SELECT * FROM users";
                            PreparedStatement preparedStatement = conn.prepareStatement(sql);

                            ResultSet resultSet = preparedStatement.executeQuery();

                            while (resultSet.next()) {

                                User user = new User();
                                int idClient = Integer.parseInt(resultSet.getString("id"));
                                user.name = resultSet.getString("name");
                                user.email = resultSet.getString("email");
                                user.phone = resultSet.getString("phone");
                                user.address = resultSet.getString("address");
                                user.password = resultSet.getString("password");


                                if(resultSet.getString("count") != null && resultSet.getString("price") != null) {
                                    int count = Integer.parseInt(resultSet.getString("count"));
                                    int price = Integer.parseInt(resultSet.getString("price"));
                                    if(count >=Integer.parseInt(fff1.getText()) && price >= Integer.parseInt(fff2.getText())){
                                        bW1.write("Client "+ idClient +'\n');
                                        bW1.flush();
                                        bW1.newLine();
                                    }

                                }

                            }

                            stmt.close();
                            conn.close();

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        bW1.close();

                    }catch (Exception ex){

                    }



                }

            });

        }

        {
            report4Btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    try {
                        BufferedWriter bW1 = new BufferedWriter(new FileWriter("Report4.txt", true));
                        int day = Integer.parseInt(ffff1.getText());
                        for(Order o : comenzi.keySet()) {

                            if(comenzi.get(o).getD() == day){
                                System.out.println("Da");
                                for(int i=0; i<comenzi.get(o).getComandId().size(); i++){
                                    System.out.println("Daaaa" + comenzi.get(o).getComandId().get(i));

                                    System.out.println(checkOrder[comenzi.get(o).getComandId().get(i)]);
                                    if(checkOrder[comenzi.get(o).getComandId().get(i)] == 1){
                                        System.out.println("Nu!!");
                                        checkOrder[comenzi.get(o).getComandId().get(i)] = 0;
                                        String s = "Produsul cu id-ul " + comenzi.get(o).getComandId().get(i) + "a fost comandat de " + noOfTimesOrder[comenzi.get(o).getComandId().get(i)] +" ori"+'\n';
                                        bW1.write(s);
                                        bW1.flush();
                                        bW1.newLine();
                                    }
                                }
                            }

                        }
                        bW1.close();
                    }catch (Exception ex){

                    }


                }

            });

        }

        {
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    reportF.setVisible(false);
                    mainF.setVisible(true);

                }

            });
        }


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        //---> End Generate Reports


    }

    public String getAddId(){
        return addIDF.getText();
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
    public String getAddTitleNew(){
        return upTitleF.getText();
    }
    public String getAddRatingNew(){
        return upRatingF.getText();
    }
    public String getAddCaloriesNew(){
        return upCaloriesF.getText();
    }
    public String getAddProteinesNew(){
        return upProteinF.getText();
    }
    public String getAddFatNew(){
        return upFatF.getText();
    }
    public String getAddSodiumNew(){
        return upSodiumF.getText();
    }
    public String getAddPriceNew(){
        return upPriceF.getText();
    }

    protected void showDialog() {
        int a = JOptionPane.showConfirmDialog(mainF,"Are You Sure you want to exit? ");
        if(a==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }

    public static void main(String args[]){

        new Interfata();

    }

}
