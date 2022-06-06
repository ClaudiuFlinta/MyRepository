import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame{

    private JTextField firstString = new JTextField(40);
    private JTextField secondString = new JTextField(40);
    private JTextField calcSolution = new JTextField(40);
    private JTextField substractionSolution = new JTextField(40);
    private JTextField divisionSolution1 = new JTextField(24);
    private JTextField divisionSolution2 = new JTextField(15);
    private JTextField multiplicationSolution = new JTextField(40);
    private JTextField derivationSolution = new JTextField(40);
    private JTextField integrationSolution = new JTextField(40);
    private JLabel additionLabel1 = new JLabel("Introduceti polinom 1: ");
    private JLabel additionLabel2 = new JLabel("Introduceti polinom 2: ");
    private JLabel additionLabel3 = new JLabel("Rezultat Adunare / +: ");
    private JLabel additionLabel4 = new JLabel("Rezultat Scadere / -: ");
    private JLabel additionLabel5 = new JLabel("Rezultat Inmultire  : ");
    private JLabel additionLabel6 = new JLabel("Rezultat Impartire  : ");
    private JLabel additionLabel7 = new JLabel("Rezultat Derivare   : ");
    private JLabel additionLabel8 = new JLabel("Rezultat Integrare  : ");
    //private JButton calculateButton = new JButton("Transform");
    private JButton additionButton = new JButton("Adunare");
    private JButton substractionButton = new JButton("Scadere");
    private JButton divisionButton = new JButton("Impartire");
    private JButton multiplicationButton = new JButton("Inmultire");
    private JButton derivationButton = new JButton("Derivare");
    private JButton integrationButton = new JButton("Integrare");

    CalculatorView(){

        JFrame mainframe =  new JFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(650,650);
        mainframe.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,600));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));


        panel.add(additionLabel1);
        panel.add(firstString);
        //panel.add(calculateButton);
        panel.add(additionLabel2);
        panel.add(secondString);
        panel.add(additionButton);
        panel.add(substractionButton);
        panel.add(divisionButton);
        panel.add(multiplicationButton);
        panel.add(derivationButton);
        panel.add(integrationButton);
        panel.add(additionLabel3);
        panel.add(calcSolution);
        panel.add(additionLabel4);
        panel.add(substractionSolution);
        panel.add(additionLabel5);
        panel.add(multiplicationSolution);
        panel.add(additionLabel6);
        panel.add(divisionSolution1);
        panel.add(divisionSolution2);
        panel.add(additionLabel7);
        panel.add(derivationSolution);
        panel.add(additionLabel8);
        panel.add(integrationSolution);

        mainframe.add(panel);

        mainframe.setVisible(true);

    }
    public String getFirstString(){

        return firstString.getText();

    }

    public String getSecondString(){

        return secondString.getText();

    }

   /* void addTransformListener(ActionListener listenForCalcButton){

        calculateButton.addActionListener(listenForCalcButton);


    }
    */

    void addAdditionListener(ActionListener listenForAdditionButton) {

        additionButton.addActionListener(listenForAdditionButton);

    }

    void addSubstractionListener(ActionListener listenForAdditionButton) {

        substractionButton.addActionListener(listenForAdditionButton);

    }

    void addMultiplicationListener(ActionListener listenForAdditionButton) {

        multiplicationButton.addActionListener(listenForAdditionButton);

    }

    void addDivisionListener(ActionListener listenForAdditionButton) {

        divisionButton.addActionListener(listenForAdditionButton);

    }

    void addDerivationListener(ActionListener listenForAdditionButton) {

        derivationButton.addActionListener(listenForAdditionButton);

    }

    void addIntegrationListener(ActionListener listenForAdditionButton) {

        integrationButton.addActionListener(listenForAdditionButton);

    }

    public void setCalcSolution(String solution){

        calcSolution.setText(solution);

    }
    public void setSubstractionSolution(String solution){

        substractionSolution.setText(solution);

    }

    public void setMultiplicationSolution(String solution){

        multiplicationSolution.setText(solution);

    }

    public void setDivisionSolution1(String solution){

        divisionSolution1.setText(solution);

    }

    public void setDivisionSolution2(String solution){

        divisionSolution2.setText(solution);

    }

    public void setDerivationSolution(String solution){

        derivationSolution.setText(solution);

    }

    public void setIntegrationSolution(String solution){

        integrationSolution.setText(solution);

    }

    void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this, errorMessage);

    }

}
