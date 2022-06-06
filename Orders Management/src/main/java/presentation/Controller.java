package presentation;

import businessLogic.OrderBLL;
import businessLogic.ProductBLL;
import model.Orders;
import model.Product;
import model.Student;
import businessLogic.StudentBLL;


import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

/**
 * This class is for controlling the GUI
 *
 */
public class Controller {

    private View theView;
    public Controller(View theView) {

        this.theView = theView;

        this.theView.addInsertListener(new InsertListener());
        this.theView.addUpdateListener(new UpdateListener());
        this.theView.addDeleteListener(new DeleteListener());
        this.theView.addSelectedListener(new SelectListener());
        this.theView.addInsertListenerTable2(new InsertListenerTable2());
        this.theView.addUpdateListenerTable2(new UpdateListenerTable2());
        this.theView.addDeleteListenerTable2(new DeleteListenerTable2());
        this.theView.addSelectedListenerTable2(new SelectListenerTable2());
        this.theView.addSelectedListenerTable3(new SelectListenerTable3());
        this.theView.addSelectedListenerTable4(new SelectListenerTable4());
        this.theView.addInsertListenerTableOrder(new InsertListenerOrder());

    }


    /**
     * Class for selecting one row using the mouse
     *
     */
    class SelectListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

            theView.selectOneRow();

        }

    }

    /**
     * Class for selecting one row using the mouse
     *
     */
    class SelectListenerTable2 extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

            theView.selectOneRowTable2();

        }

    }
    /**
     * Class for selecting one row using the mouse
     *
     */
    class SelectListenerTable3 extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

            theView.selectOneRowTable3();

        }

    }

    /**
     * Class for selecting one row using the mouse
     *
     */
    class SelectListenerTable4 extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

            theView.selectOneRowTable4();

        }

    }

    /**
     * Class for Insert in Table Client
     *
     */
    class InsertListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{


                String name = theView.getName();
                String adress = theView.getAdress();
                int age = Integer.parseInt(theView.getAge());
                Student student = new Student(name,age, adress);

                StudentBLL studentBll = new StudentBLL();
                Student s = studentBll.insertStudent(student);
                ResultSet rs = studentBll.connectToTable();
                theView.updateTable(rs);
                rs = studentBll.connectToTable();
                theView.updateTable3(rs);
                System.out.println("Success");
                /*if (s.getId() > 0) {
                    System.out.println( studentBll.findStudentById(s.getId()));
                }*/

                // Generate error
                try {
                    studentBll.findStudentById(1);
                } catch (Exception ex) {

                    ex.printStackTrace();
                    // LOGGER.log(Level.INFO, ex.getMessage());
                }




            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }

    /**
     * Class for insert in table Product
     *
     */
    class InsertListenerTable2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{


                String productName = theView.getProductName();
                int price  = Integer.parseInt(theView.getPrice());
                int quantity = Integer.parseInt(theView.getQuantity());
                Product product = new Product(2,productName,price,quantity);

                ProductBLL productBll = new ProductBLL();
                Product p = productBll.insertProduct(product);
                ResultSet rs = productBll.connectToTable2();
                theView.updateTable2(rs);
                rs = productBll.connectToTable2();
                theView.updateTable4(rs);
                System.out.println("Success");
                /*if (s.getId() > 0) {
                    System.out.println( studentBll.findStudentById(s.getId()));
                }*/

                // Generate error
                try {
                    //productBll.findProductById(1);
                } catch (Exception ex) {

                    ex.printStackTrace();
                    // LOGGER.log(Level.INFO, ex.getMessage());
                }




            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }

    /**
     * Class for update table Client
     *
     */
    class UpdateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{

                String name = theView.getName();
                String adress = theView.getAdress();
                int age = Integer.parseInt(theView.getAge());
                int idStud = theView.selectRowByClick();
                Student student = new Student(idStud,name,age, adress);

                StudentBLL studentBll = new StudentBLL();
                Student stud = studentBll.updateStudent(student);
                ResultSet rs = studentBll.connectToTable();
                theView.updateTable(rs);
                System.out.println("Success");
                /*if (id > 0) {
                    System.out.println( studentBll.findStudentById(id));
                }*/


                // Generate error
                try {
                    studentBll.findStudentById(1);
                } catch (Exception ex) {

                    ex.printStackTrace();
                    // LOGGER.log(Level.INFO, ex.getMessage());
                }


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }

    /**
     * Class for update table Product
     *
     */
    class UpdateListenerTable2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{

                String productName = theView.getProductName();
                int price  = Integer.parseInt(theView.getPrice());
                int quantity = Integer.parseInt(theView.getQuantity());
                int idProd = theView.selectRowByClickTable2();
                Product product = new Product(idProd,productName,price,quantity);

                ProductBLL productBll = new ProductBLL();
                Product p = productBll.updateProduct(product);
                ResultSet rs = productBll.connectToTable2();
                theView.updateTable2(rs);
                System.out.println("Success");
                /*if (id > 0) {
                    System.out.println( studentBll.findStudentById(id));
                }*/


                // Generate error
                try {
                    productBll.findProductById(1);
                } catch (Exception ex) {

                    ex.printStackTrace();
                    // LOGGER.log(Level.INFO, ex.getMessage());
                }


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }

    /**
     * Class for delete from table Client
     *
     */
    class DeleteListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{

                String name = theView.getName();
                String adress = theView.getAdress();
                int age = Integer.parseInt(theView.getAge());
                int idStud = theView.selectRowByClick();
                Student student = new Student(idStud,name,age, adress);

                StudentBLL studentBll = new StudentBLL();
                Student stud = studentBll.deleteStudent(student);
                ResultSet rs = studentBll.connectToTable();
                theView.updateTable(rs);
                System.out.println("Success");
                /*if (id > 0) {
                   System.out.println( studentBll.findStudentById(id));
                }

                 */


                // Generate error
                try {
                    studentBll.findStudentById(1);
                } catch (Exception ex) {

                    ex.printStackTrace();
                    // LOGGER.log(Level.INFO, ex.getMessage());
                }


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }

    /**
     * Class for delete from table Product
     *
     */
    class DeleteListenerTable2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{

                String productName = theView.getProductName();
                int price  = Integer.parseInt(theView.getPrice());
                int quantity = Integer.parseInt(theView.getQuantity());
                int idProd = theView.selectRowByClickTable2();
                Product product = new Product(idProd,productName,price,quantity);

                ProductBLL productBll = new ProductBLL();
                Product p = productBll.deleteProduct(product);
                ResultSet rs = productBll.connectToTable2();
                theView.updateTable2(rs);
                System.out.println("Success");
                /*if (id > 0) {
                   System.out.println( studentBll.findStudentById(id));
                }

                 */


                // Generate error
                try {
                    productBll.findProductById(1);
                } catch (Exception ex) {

                    ex.printStackTrace();
                    // LOGGER.log(Level.INFO, ex.getMessage());
                }


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }

    /**
     * Class for insert an order using tables Client & Product into table Orders
     *
     */
    class InsertListenerOrder implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try{

                //extrag id-ul produsului pentru a-i putea updata cantitatea in cazul in care comanda este valida
                int idProd = theView.selectRowByClickTable4();
                String ordName = theView.getOrdName();
                String ordAddres = theView.getOrdAdress();
                int ordAge =  Integer.parseInt(theView.getOrdAge());
                String ordProdName = theView.getOrdProdName();
                int ordPrice = Integer.parseInt(theView.getOrdPrice());
                int ordAvQty = Integer.parseInt(theView.getOrdAvailableQty());
                int ordDesQty = Integer.parseInt(theView.getOrdDesireQty());

                //cazul in care se poate realiza comanda
                if(ordAvQty >= ordDesQty) {

                        int totalPrice =  ordPrice * ordDesQty;
                        Orders order = new Orders(2,ordName, ordAddres, ordAge, ordProdName, ordPrice, ordDesQty, totalPrice );
                        Generate_PDF.generateBill("C:\\Laboratoare_TP\\bill",ordName,ordAddres,ordProdName,ordPrice, ordDesQty,totalPrice);
                        OrderBLL orderBll = new OrderBLL();
                        Orders o = orderBll.insertOrder(order);
                        ResultSet rs = orderBll.connectToTableOrder();
                        theView.updateTable5(rs);

                        Product product = new Product(idProd,ordProdName,ordPrice,ordAvQty-ordDesQty);
                        ProductBLL productBll = new ProductBLL();
                        Product p = productBll.updateProduct(product);
                        rs = productBll.connectToTable2();
                        theView.updateTable2(rs);
                        rs = productBll.connectToTable2();
                        theView.updateTable4(rs);
                        System.out.println("Success");
                    /*if (s.getId() > 0) {
                        System.out.println( studentBll.findStudentById(s.getId()));
                    }*/

                        // Generate error
                        try {
                            //productBll.findProductById(1);
                        } catch (Exception ex) {

                            ex.printStackTrace();
                            // LOGGER.log(Level.INFO, ex.getMessage());
                        }
                }
                else{

                    //Nu se poate realiza comanda
                    JOptionPane.showMessageDialog(theView, "Stoc Insuficient! Va rugam introduceti o cantitate mai mica!");
                    System.out.println("Nu se poate realiza comanda!!!");
                }




            }

            catch(NumberFormatException ex){

                System.out.println(ex);

            }

        }

    }
}
