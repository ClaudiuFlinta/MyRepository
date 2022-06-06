package presentation;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;

public class View extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel Main;
    private JTable table1;
    private JTextField textField1;
    private JButton insertButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table2;
    private JButton insertButton1;
    private JButton updateButton1;
    private JButton deleteButton1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTable table3;
    private JTable table4;
    private JButton makeOrderButton;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTable table5;

    public View(){
        setContentPane(Main);
        setTitle("Welcome");
        setSize(800,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    int selectRowByClick(){
        DefaultTableModel Df = (DefaultTableModel) table1.getModel();
        int selectedIndex = table1.getSelectedRow();
        int id = Integer.parseInt(Df.getValueAt(selectedIndex,0).toString());
        return id;

    }

    int selectRowByClickTable2(){
        DefaultTableModel Df = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();
        int id = Integer.parseInt(Df.getValueAt(selectedIndex,0).toString());
        return id;

    }
    int selectRowByClickTable3(){
        DefaultTableModel Df = (DefaultTableModel) table3.getModel();
        int selectedIndex = table3.getSelectedRow();
        int id = Integer.parseInt(Df.getValueAt(selectedIndex,0).toString());
        return id;

    }
    int selectRowByClickTable4(){
        DefaultTableModel Df = (DefaultTableModel) table4.getModel();
        int selectedIndex = table4.getSelectedRow();
        int id = Integer.parseInt(Df.getValueAt(selectedIndex,0).toString());
        return id;

    }

    void selectOneRow(){
        DefaultTableModel Df = (DefaultTableModel) table1.getModel();
        int selectedIndex = table1.getSelectedRow();

        textField1.setText(Df.getValueAt(selectedIndex, 1).toString());
        textField2.setText(Df.getValueAt(selectedIndex, 3).toString());
        textField3.setText(Df.getValueAt(selectedIndex, 2).toString());
    }
    void selectOneRowTable2(){
        DefaultTableModel Df = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();

        textField4.setText(Df.getValueAt(selectedIndex, 1).toString());
        textField5.setText(Df.getValueAt(selectedIndex, 2).toString());
        textField6.setText(Df.getValueAt(selectedIndex, 3).toString());
    }

    void selectOneRowTable3(){
        DefaultTableModel Df = (DefaultTableModel) table3.getModel();
        int selectedIndex = table3.getSelectedRow();

        textField7.setText(Df.getValueAt(selectedIndex, 1).toString());
        textField8.setText(Df.getValueAt(selectedIndex, 3).toString());
        textField9.setText(Df.getValueAt(selectedIndex, 2).toString());
    }

    void selectOneRowTable4(){
        DefaultTableModel Df = (DefaultTableModel) table4.getModel();
        int selectedIndex = table4.getSelectedRow();

        textField10.setText(Df.getValueAt(selectedIndex, 1).toString());
        textField11.setText(Df.getValueAt(selectedIndex, 2).toString());
        textField12.setText(Df.getValueAt(selectedIndex, 3).toString());
    }
    void addSelectedListener(MouseAdapter listenForMouse){

        table1.addMouseListener(listenForMouse);
    }
    void addSelectedListenerTable2(MouseAdapter listenForMouse){

        table2.addMouseListener(listenForMouse);
    }
    void addSelectedListenerTable3(MouseAdapter listenForMouse){

        table3.addMouseListener(listenForMouse);
    }
    void addSelectedListenerTable4(MouseAdapter listenForMouse){

        table4.addMouseListener(listenForMouse);
    }


    void addInsertListener(ActionListener listenForAdditionButton) {

        insertButton.addActionListener(listenForAdditionButton);

    }

    void addInsertListenerTable2(ActionListener listenForAdditionButton) {

        insertButton1.addActionListener(listenForAdditionButton);

    }

    void addInsertListenerTableOrder(ActionListener listenForAdditionButton) {

        makeOrderButton.addActionListener(listenForAdditionButton);

    }

    void addUpdateListener(ActionListener listenForAdditionButton) {

        updateButton.addActionListener(listenForAdditionButton);

    }

    void addUpdateListenerTable2(ActionListener listenForAdditionButton) {

        updateButton1.addActionListener(listenForAdditionButton);

    }

    void addDeleteListener(ActionListener listenForAdditionButton) {

        deleteButton.addActionListener(listenForAdditionButton);

    }
    void addDeleteListenerTable2(ActionListener listenForAdditionButton) {

        deleteButton1.addActionListener(listenForAdditionButton);

    }


    public void updateTable(ResultSet rs){
        table1.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void updateTable2(ResultSet rs){
        table2.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void updateTable3(ResultSet rs){
        table3.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void updateTable4(ResultSet rs){
        table4.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void updateTable5(ResultSet rs){
        table5.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public String getName(){

        return textField1.getText();
    }
    public String getAge(){

        return textField3.getText();
    }
    public String getAdress(){

        return textField2.getText();
    }

    public String getProductName(){

        return textField4.getText();
    }
    public String getPrice(){

        return textField5.getText();
    }
    public String getQuantity(){

        return textField6.getText();
    }

    // Getters for Order View
    // -->

    public String getOrdName(){

        return textField7.getText();
    }

    public String getOrdAdress(){

        return textField8.getText();
    }
    public String getOrdAge(){

        return textField9.getText();
    }
    public String getOrdProdName(){

        return textField10.getText();
    }
    public String getOrdPrice(){

        return textField11.getText();
    }

    public String getOrdAvailableQty(){

        return textField12.getText();
    }

    public String getOrdDesireQty(){

        return textField13.getText();
    }

}
