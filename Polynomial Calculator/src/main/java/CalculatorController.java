import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class CalculatorController {

    private CalculatorView theView;
    private ModelCalculator theModel;

    public CalculatorController(CalculatorView theView, ModelCalculator theModel) {
        this.theView = theView;
        this.theModel = theModel;

        //this.theView.addTransformListener(new TransformListener());
        this.theView.addAdditionListener(new AdditionListener());
        this.theView.addSubstractionListener(new SubstractionListener());
        this.theView.addMultiplicationListener(new MultiplicationListener());
        this.theView.addDivisionListener(new DivisionListener());
        this.theView.addDerivationListener(new DerivationListener());
        this.theView.addIntegrationListener(new IntegrationListener());
    }

    //Clasa de test pentru transformare cu Regex
//Am folosit-o la inceput
/*
    class TransformListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {


            String firstString;
            String secondString;

            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered

            try{

                firstString = theView.getFirstString();
                secondString = theView.getSecondString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom p2 = new Polinom();
                //polimonul rezultat = rezultatul operatiei pe cele 2 polinomame
                Polinom rezultat = new Polinom();

                theModel.transform(firstString,p1);

                System.out.println(p1);


                theView.setCalcSolution(theModel.displayResult());

            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }


    }
*/
    //clasa care implementeaza ActionListener pentru operatia de Adunare
    class AdditionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            String firstString;
            String secondString;

            try{

                firstString = theView.getFirstString();
                secondString = theView.getSecondString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom p2 = new Polinom();
                //polimonul rezultat = rezultatul operatiei pe cele 2 polinomame
                Polinom rezultat = new Polinom();

                theModel.transform(firstString,p1);
                theModel.transform(secondString,p2);

                System.out.println(p1);
                System.out.println(p2);

                rezultat = theModel.add(p1, p2);

                System.out.println(rezultat);
                theView.setCalcSolution(theModel.displayResult(rezultat));


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }

    }
    //clasa care implementeaza ActionListener pentru operatia de Scadere
    class SubstractionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            String firstString;
            String secondString;

            try{

                firstString = theView.getFirstString();
                secondString = theView.getSecondString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom p2 = new Polinom();
                //polimonul rezultat = rezultatul operatiei pe cele 2 polinomame
                Polinom rezultat = new Polinom();

                theModel.transform(firstString,p1);
                theModel.transform(secondString,p2);

                System.out.println(p1);
                System.out.println(p2);

                rezultat = theModel.substraction(p1, p2);

                System.out.println(rezultat);
                theView.setSubstractionSolution(theModel.displayResult(rezultat));


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }

    }

    //clasa care implementeaza ActionListener pentru operatia de Inmultire
    class MultiplicationListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            String firstString;
            String secondString;

            try{

                firstString = theView.getFirstString();
                secondString = theView.getSecondString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom p2 = new Polinom();
                //polimonul rezultat = rezultatul operatiei pe cele 2 polinomame
                Polinom rezultat = new Polinom();

                theModel.transform(firstString,p1);
                theModel.transform(secondString,p2);

                System.out.println(p1);
                System.out.println(p2);

                rezultat = theModel.multiplication(p1, p2);

                System.out.println(rezultat);
                theView.setMultiplicationSolution(theModel.displayResult(rezultat));


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }

    }

    //clasa care implementeaza ActionListener pentru operatia de Inmultire
    class DivisionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            String firstString;
            String secondString;

            try{

                firstString = theView.getFirstString();
                secondString = theView.getSecondString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom p2 = new Polinom();
                //polimonul rezultat = rezultatul operatiei pe cele 2 polinomame
                List<Polinom> rezultat = new ArrayList<Polinom>();

                theModel.transform(firstString,p1);
                theModel.transform(secondString,p2);

                System.out.println(p1);
                System.out.println(p2);

                rezultat = theModel.division(p1, p2);

                System.out.println(rezultat);
                theView.setDivisionSolution1(theModel.displayResult(rezultat.get(0)));
                theView.setDivisionSolution2(theModel.displayResult(rezultat.get(1)));



            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }

    }

    //clasa care implementeaza ActionListener pentru operatia de Derivare
    class DerivationListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            String firstString;

            try{

                firstString = theView.getFirstString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom rezultat = new Polinom();

                theModel.transform(firstString,p1);

                System.out.println(p1);

                rezultat = theModel.derivation(p1);

                System.out.println(rezultat);
                theView.setDerivationSolution(theModel.displayResult(rezultat));


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }

    }

    //clasa care implementeaza ActionListener pentru operatia de Derivare
    class IntegrationListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            String firstString;

            try{

                firstString = theView.getFirstString();

                //polinomul p1 = primul polinom preluat din textField
                Polinom p1 = new Polinom();
                //polinimul p2 = al doilea polinom preluat din textField
                Polinom rezultat = new Polinom();

                theModel.transform(firstString,p1);

                System.out.println(p1);

                rezultat = theModel.integration(p1);

                System.out.println(rezultat);
                theView.setIntegrationSolution(theModel.displayResult(rezultat));


            }

            catch(NumberFormatException ex){

                System.out.println(ex);

                theView.displayErrorMessage("Wrong format for string");

            }

        }

    }






}
